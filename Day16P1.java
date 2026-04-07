import java.util.*;
public class Day16P1{
    public static Map<Integer, List<int[]>> graph = new HashMap<>();

    public static void addEdge(int u, int v, int w){
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, w});
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, w});
    }

    //Dijekstra
    public static int[] dijekstra(int start, int v)
    {
        //distance array
        int[] distance = new int[v+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        //min heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        distance[start] = 0;
        pq.offer(new int[]{0, start});
        
        while(!pq.isEmpty()){
            int[] peek = pq.poll();
            int curr_dist = peek[0];
            int node = peek[1];

            //if the distance we is less then the new distance return
            if(curr_dist > distance[node]) continue;

            for(int[] neighbor : graph.get(node)){
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDistance = distance[node] + weight;

                if(newDistance < distance[nextNode]){
                    distance[nextNode] = newDistance;
                    pq.offer(new int[]{newDistance, nextNode});

                }
            }

        }
        return distance;

    }


    public static void main(String[] args){
        addEdge(1, 2, 4);
        addEdge(1, 3, 2);
        addEdge(2, 4, 5);
        addEdge(3, 4, 1);
        addEdge(3, 5, 6);
        addEdge(4, 5, 3);

        int[] fd = dijekstra(1, 5);

        //print new array
        for(int i = 1; i <= 5; i++){
            System.out.println(i+ " - "+fd[i]);
        }


    }
}