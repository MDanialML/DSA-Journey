import java.util.*;
public class Day25P1{

    public static int[][] mergeIntervals(int[][] intervals){
        //edge cases
        if(intervals.length == 0){
            throw new IllegalArgumentException("Invalid input!");
        }
        if(intervals.length == 1) return intervals;

        //sort intervals start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        
        for(int i =1; i < intervals.length; i++){
            //check overlapping interval
            if(intervals[i][0] <= current[1]){
                //merge both intervals
                current[1] = Math.max(current[1], intervals[i][1]);
            }else{
                result.add(current);
                current = intervals[i];
            }
        }
        //add last interval
        result.add(current);
        return result.toArray(new int[result.size()][]);
        
    } 
    public static void main(String[] args){

        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merged = mergeIntervals(intervals);
        for(int[] num : merged){
            System.out.println("[" + num[0] + ", " + num[1] + "]");
        }

    }
}