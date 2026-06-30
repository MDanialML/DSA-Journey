import java.util.Arrays;
public class Day38P1{

    public static int[] bellmanFord(int[][] edges, int V, int source) {
    int[] distance = new int[V];
    Arrays.fill(distance, Integer.MAX_VALUE);
    distance[source] = 0;

    // V-1 relaxation passes
    for(int i = 0; i < V - 1; i++) {
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1], weight = edge[2];
            if(distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                distance[v] = distance[u] + weight;
            }
        }
    }

    // Negative cycle check — one more pass
    for(int[] edge : edges) {
        int u = edge[0], v = edge[1], weight = edge[2];
        if(distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
            throw new RuntimeException("Negative weight cycle detected!");
        }
    }

    return distance;
}


    //driver function
    public static void main(String[] args){
        // Each row = {source, destination, weight}
    int[][] edges = {
        {0, 1, 6},
        {0, 2, 7},
        {1, 2, 8},
        {1, 3, -4},
        {1, 4, 5},
        {2, 3, 9},
        {2, 4, -3},
        {3, 0, 2},
        {4, 3, 7}
    };
    int[] finalDistance = bellmanFord(edges, 5, 0);
   for(int num : finalDistance){
    System.out.println(num);
   }

    }
}