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

    static class UnionFind {
    int[] parent;
    int[] rank;

    UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
    }

    int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) return false; // already connected

        // Union by rank — attach smaller tree under larger
        if(rank[rootX] < rank[rootY])      parent[rootX] = rootY;
        else if(rank[rootX] > rank[rootY]) parent[rootY] = rootX;
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }

    boolean connected(int x, int y) {
        return find(x) == find(y);
    }
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

        UnionFind uf = new UnionFind(v);
        System.out.println("Union 0,1: "+ uf.union(0, 1));
        System.out.println("Union of 1, 2: " + uf.union(1, 2));
        System.out.println("Union of 3, 4" + uf.union(3, 4));
        System.out.println("0, 2 connected? " + uf.connected(0, 2));
        System.out.println("0, 3 connected? " + uf.connected(0, 3));
        System.out.println("Union 2, 3: " + uf.union(2, 3));
        System.out.println("0, 4 connected? " + uf.connected(0, 4));
    }
}