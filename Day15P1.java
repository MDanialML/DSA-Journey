import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day15P1{

    public static Map<Integer, List<Integer>> graph = new HashMap<>();

    //add edge
    public static void addEdge(int u, int v){
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    //bfs
    public static void bfs(int start){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node+ " ");
            visited.add(node);
            for(int neighbor : graph.get(node)){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }


    //dfs graph
    public static void dfs(int start, Set<Integer> visited){
        //base case
        if(visited.contains(start)) return;
        System.out.print(start+" ");
        visited.add(start);
        for(int neighbor : graph.get(start)){
            dfs(neighbor, visited);
        }
        
    }

    // Public entry point
    public static boolean hasCycle() {
        Set<Integer> visited = new HashSet<>();
            for(int node : graph.keySet()) {
        if(!visited.contains(node)) {
            if(dfsHasCycle(node, -1, visited)) return true;
        }
    }
    return false;
    }

    // Private recursive helper
    public static boolean dfsHasCycle(int node, int parent, Set<Integer> visited) {
        visited.add(node);
        for(int neighbor : graph.get(node)) {
            if(!visited.contains(neighbor)) {
                // recurse
                if(dfsHasCycle(neighbor, node, visited)) return true;
            } else if(neighbor != parent) {
                // visited AND not parent → cycle
                return true;
            }
        }
        return false;
    }

    //driver code
    public static void main(String[] args){
        //create a graph
        addEdge(1,2);
        addEdge(1, 3);
        addEdge(2, 4);
        addEdge(3, 4);
        addEdge(4, 5);

    System.out.print("BFS: ");
    bfs(1);
    System.out.println();

    System.out.print("DFS: ");
    Set<Integer> visited = new HashSet<>();
    dfs(1, visited);
    System.out.println();

    System.out.println("Cycle exists: " + hasCycle());
    }

}

