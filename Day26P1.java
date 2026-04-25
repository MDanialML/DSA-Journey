import java.util.List;
import java.util.ArrayList;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
    }
}



public class Day26P1{

    public static boolean hasPathSum(TreeNode root, int target, List<Integer> path){
        if(root == null) return false;
        path.add(root.val);
        if(root.left == null && root.right == null){
            System.out.println("target path:" + path);
            return root.val == target;
        }
        //recursive call for left and right child
        return hasPathSum(root.left, target-root.val, new ArrayList<>(path)) ||
            hasPathSum(root.right, target-root.val, new ArrayList<>(path));
    }

    public static void main(String[] args){

        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        System.out.println("Tree has path sum:    " + hasPathSum(tree, 7, new ArrayList<>()));

    }
}