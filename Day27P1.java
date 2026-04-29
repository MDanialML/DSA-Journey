import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class Day27P1{

    public static Map<Integer, List<Integer>> graph = new HashMap<>();
    
    //create directed acyclic graph
    public static void addEdge(int u, int v){
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
    }

    public static int[] topologicalSort(Map<Integer, List<Integer>> graph, int V) {
    int[] inDegree = new int[V];

    // Calculate in-degrees
    for(int i =0; i < V; i++) {
        for(int neighbor : graph.getOrDefault(i, new ArrayList<>())) {
        inDegree[neighbor]++;
    }
    }

    // Add all in-degree 0 nodes to queue
    Queue<Integer> queue = new LinkedList<>();
    for(int i = 0; i < V; i++) {
        if(inDegree[i] == 0) queue.offer(i);
    }

    int[] result = new int[V];
    int index = 0;

    while(!queue.isEmpty()) {
        int node = queue.poll();
        result[index++] = node;

        for(int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            inDegree[neighbor]--;
            if(inDegree[neighbor] == 0) queue.offer(neighbor);
        }
    }

    // If index != V → cycle exists
    return index == V ? result : new int[]{};
    }



    //driver function
    public static void main(String[] args){


        addEdge(0,1);
        addEdge(0, 2);
        addEdge(1, 3);
        addEdge(2, 3);
        addEdge(3, 4);
        
        int v = 5;

        int[] result = topologicalSort(graph, v);

        for(int i : result){
            System.out.print(i+", ");
        }
        System.out.println();

        

    }
}