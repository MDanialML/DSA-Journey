public class Day32P1{


    public static void dfs(int[][]grid, int i, int j){

        if(i < 0 || i >= grid.length ||
                j < 0 || j >= grid[0].length ||
                grid[i][j] == 0) return;

        grid[i][j] = 0;
        dfs(grid, i-1, j); // up
        dfs(grid, i+1, j); // down
        dfs(grid, i, j+1); // right
        dfs(grid, i, j-1); // left
        }
    


    public static int checkIsland(int[][] grid){
        //edge case
        if(grid.length == 0){
            return 0;
        }
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
               if(grid[i][j] == 1) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    //driver funtion 
    public static void main(String[] args){
        int[][] grid = {
                {1,1,1,1,0},
                {1,1,0,1,0},
                {1,1,0,0,0},
                {0,0,0,0,0}};
    
    for(int[] i : grid){
        for(int num : i){
            System.out.print(num + ", ");
        }
        System.out.println();
        }
        System.out.println("Number of island: "+ checkIsland(grid));

    }


}