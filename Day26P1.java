class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
    }
}



public class Day26P1{

    public static boolean hasPathSum(TreeNode root, int target){
        if(root == null) return false;
        if(root.left == null && root.right == null){
            return root.val == target;
        }
        //recursive call for left and right child
        return hasPathSum(root.left, target-root.val) ||
            hasPathSum(root.right, target-root.val);
    }

    //Diameter of Tree
    public static int diameter = 0;

    public static int findDiameter(TreeNode root){
        diameter = 0; //reset the static diameter
        calculateHeight(root);
        return diameter;

    }
    //calculate height of tree
    public static int calculateHeight(TreeNode node){
        if(node == null) return 0;
        int lHeight = calculateHeight(node.left);
        int rHeight = calculateHeight(node.right);
        //diameter through this node is equal to leftHeight + rightHeight
        diameter = Math.max(diameter, lHeight + rHeight);
        return 1 + Math.max(lHeight, rHeight);

    }
    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;
        if(root == p || root == q) return root;

        TreeNode left  = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if(left != null && right != null) return root;
        return left != null ? left : right;
    }


    public static void main(String[] args){

        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        System.out.println("Tree has path sum:    " + hasPathSum(tree, 7));

        System.out.println("Diameter of this tree is: " + findDiameter(tree));
        System.out.println("Lowest common ancestor is: " + lca(tree, tree.left.left, tree.left.right).val);

    }
}