
public class Tree{ 

    public class Node{
    public int value;
    public Node right;
    public Node left;
    public int height;
    public Node(int value){
        this.value = value;
        }
    }
    private static Node root;
    
    public void insert(int value, String direction){
        Node node = new Node(value);
        if(root == null && direction == ""){
            root = node;
        }
        else if(direction == "left"){
            root.left = node;
        }else{
            root.right = node;
        }
    }
    public void display(Node node, String details){
        if(node == null){
            return ;
        }
        System.out.println(details+node.value);
        display(node.left, "left child of "+node.value+" : ");

        display(node.right, "left child of "+node.value+" : ");
    }

    public static void main(String[] args){
        Tree avlTree = new Tree();
        // avlTree.display();
        avlTree.insert(2,"");
        avlTree.insert(1,"left");
        avlTree.insert(3,"right");

        avlTree.display(root, "root details are");

    }

}