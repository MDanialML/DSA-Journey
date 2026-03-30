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


    public void inOrder(){
        inOrder(root);
    }

    //inorder traversel
    private void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.data+ " ");
        inOrder(node.right);
    }

    public boolean searchNode(int data){
        return searchNode(root, data);
    }


    private boolean searchNode(TreeNode node, int data){
        if(node == null){
            return false;
        }
        if(node.data == data){
        return true;
        }
        if(data < node.data){
            return searchNode(node.left, data);
        }else{
        return searchNode(node.right, data);
        }

    }

}



public class Day12P1{

    public static void main(String[] args)
    {
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(20);
        bst.inOrder();
        System.out.println(bst.searchNode(7));   
        System.out.println(bst.searchNode(99));

    }
}