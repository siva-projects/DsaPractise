package Trees;
import java.util.*;
public class PractiseBinaryTree {
    
    public static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }
    private Node root;

    public void populate(Scanner scanner){
        System.out.println("Enter the root node: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }
    private void populate(Scanner scanner, Node node){
        System.out.println("Do you want to enter left of "+node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value of left of "+node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.println("Do you want to enter right value of "+node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println(" Enter the value right to "+node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }
    public void prettyDisplay(){
        prettyDisplay(root, 0);
    }
    private void prettyDisplay(Node node, int level){
        if(node == null){
            return ;
        }
        prettyDisplay(node.right, level+1);

        if(level!=0){
            for(int i=0;i<level-1;i++){
                System.out.print("|\t\t");
            }
            System.out.println("|----->" +node.value);
        }else{
            System.out.println(node.value);
        }

        prettyDisplay(node.left, level+1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PractiseBinaryTree tree = new PractiseBinaryTree();
        tree.populate(scanner);
        tree.prettyDisplay();
    }
}
