public class Day39P1{

    public static int[][] floyedWarshall(int[][] graph, int V){
        int INF = 99999;

        int dist[][] = new int[V][V];
        //fill diagonal with zero
        //rest all fill wiht infinity
        for(int i =0; i <V; i++){
            for(int j =0; j < V; j++){
                if(i==j) dist[i][j] =0;
                else dist[i][j] = INF;
            }
        }

        //prepare k0 matrix
        for(int[] edge:graph){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            dist[u][v] = w;
        }

        // Floyd-Warshall core — try every intermediate vertex k
            for(int k = 0; k < V; k++) {
                for(int i = 0; i < V; i++) {
                    for(int j = 0; j < V; j++) {
                        // Only update if path through k is valid
                        // dist[i][k] and dist[k][j] must not be INF
                            if(dist[i][k] != INF && dist[k][j] != INF) {
                                if(dist[i][k] + dist[k][j] < dist[i][j]) {
                                    dist[i][j] = dist[i][k] + dist[k][j];
                                }
                            }
                        }
            }
        }
    return dist;
    }

    //driver function
    public static void main(String[] args){
        int[][] edges = {
            {0,1,3},
            {0,3,7},
            {1,0,8},
            {1,2,2},
            {2,0,5},
            {2,3,1},
            {3,0,2}
        };
        int V = 4;
        int[][] finalDist = floyedWarshall(edges, V);
        
        //check the matrix k^0
        for(int[] row: finalDist){
            for(int i =0; i < row.length; i++){
                System.out.print(row[i]+", ");
            }
            System.out.println();
        }
    }
}