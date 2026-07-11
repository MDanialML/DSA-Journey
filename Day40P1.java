import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class Day40P1{


    public static boolean canFinish(int[][] prerequisites, int numCourses){
        //prepare adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        //initialize empty lists for each course
        for(int i =0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        //add dependency list
        for(int[] pre: prerequisites){
            int a = pre[0];
            int b = pre[1];
            //now independent node which is b in pre must come first
            adj.get(b).add(a);
        }

        //calculate indegree
        int[] inDegree = new int[numCourses];
        for(int[] pre: prerequisites){
            inDegree[pre[0]]++;
        }

        //kahn's algorithm
        Queue<Integer> q = new LinkedList<>();

        //push vertex with indegree 0 to queue
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        
        int courseCount = 0;
        while(!q.isEmpty()){
            courseCount++;
            int curr = q.poll();
            List<Integer> dependent = adj.get(curr);
            for(int nextCourse : dependent){
                inDegree[nextCourse]--;
                if(inDegree[nextCourse] == 0) q.add(nextCourse);
            }
        }
        return courseCount == numCourses;

    }

    //driver function
    public static void main(String[] args){
        int[][] prerequisites = {{1,0},{2,0},{3,1}};
        int numCourses = 4;

        boolean willFinish = canFinish(prerequisites, numCourses);
        System.out.println("Can take all the courses:   "+ willFinish);
        
    }
}