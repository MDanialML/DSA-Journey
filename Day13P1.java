import java.util.Queue;
import java.util.LinkedList;


class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BST{
    TreeNode root;

    BST(){
        this.root= null;
    }


    public void insert(int data){
       root = insert(root, data);
    }
    //insert into BST
    private TreeNode insert(TreeNode node,int data){
        if(node == null){
            return new TreeNode(data);
        }
        if(node.data > data){
            node.left = insert(node.left,data);
        }else{
            node.right = insert(node.right, data);
        }
        return node;
    }


    

    public void levelOrder(){
        levelOrder(root);
    }
    //Level Order Traversal
    private void levelOrder(TreeNode root){
        //base case
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);

        }
    }

    public int treeHeight(){
        return treeHeight(root);
    }
    private int treeHeight(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(treeHeight(root.left), treeHeight(root.right)); 

    }

    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(TreeNode root){
        //base case
        if(root == null) return true;
        int lHeight = treeHeight(root.left);
        int rHeight = treeHeight(root.right);
        if(Math.abs(lHeight - rHeight) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

}



public class Day13P1{



    public static void main(String[] args)
    {
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(20);

        bst.levelOrder();
        System.out.println();
        System.out.println(bst.treeHeight());
        System.out.println(bst.isBalanced());


    }
}