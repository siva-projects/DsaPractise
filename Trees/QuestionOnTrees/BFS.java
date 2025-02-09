package QuestionOnTrees;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static class  Node {
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
        
    }
    private Node root;

    public void construct( int[] arr){
        root = construct(0, arr);
    }

    private Node construct( int index, int[] arr){
        if(index >= arr.length){
            return null; 
        }
        Node node = new Node(arr[index]);
        node.left = construct(2*index+1, arr);
        node.right = construct( 2* index+2, arr);
        return node;

    }
    public void prettyDisplay(){
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level){
        if(node == null){
            return ;
        }
        prettyDisplay(node.right, level + 1);
        if(level != 0){
            for(int i=0;i<level-1;i++){
                System.out.print("|\t\t");
            }
            System.out.println("|----->" + node.value);
        }else{
            System.out.println(node.value);
        }

        prettyDisplay(node.left, level+1);
    }
    public static void main(String[] args) {
        System.out.println("testing the BFS");
        BFS btree = new BFS();
        int[] arr = {3,5,9,1,2,10,12,22,33,44,55,16,66,8,77};
        btree.construct( arr);
        btree.prettyDisplay();
        int[] pathArray = {3, 9 , 12, 18};
        System.out.println(btree.pathExists(pathArray));
        // btree.PostOrderPractise();
        // System.out.println(btree.levelOrderSuccesor(44));
    }



    // Question - 3 level order successor of a ele in a binary tree
    // Given a binary tree and an element in  a binary tree, find the immediate next element of the given element
    // if next value of given element is present in same level return it
    // if given element is itself last element of that level, return the immediate element in the next level.
    public int levelOrderSuccesor(int element){
        return levelOrderSuccesor(root, element);
    }
    private int levelOrderSuccesor(Node node,int element){
        int ans = -1;
        if(node == null){
            return ans;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            Node currentNode = queue.peek();
            if(currentNode.left != null){
                queue.offer(currentNode.left);
            }
            if(currentNode.right != null){
                queue.offer(currentNode.right);
            }
            if(element == currentNode.value){
                queue.poll();
                element = queue.peek()!=null ? queue.peek().value : -1;
                break;
            }
            queue.poll();
        }
        return element;

    }

    public void PostOrderPractise(){
        PostOrderPractise(root);
    }
    // DFS , post order practise
    public  void PostOrderPractise(Node node){
        if(node == null){
            return ;
        }
        PostOrderPractise(node.left);
        PostOrderPractise(node.right);
        
        System.out.println("value : "+node.value);
        return;
    }




    // Question 23 path exists in binary tree from root to leaf
    public boolean pathExists(int[] arr){
        return pathExists(arr, root, 0);
    }
    public  boolean pathExists(int[] arr, Node node, int index){
           if(node == null){
            return false;
           }

           if(node.value != arr[index] || index >= arr.length){
            return false;
           }
           if(node.left == null && node.right == null && index == arr.length - 1){
            return true;
           }
           return pathExists(arr, node.left, index+1) || pathExists(arr, node.right, index+1);
    }

    
    // DFS using stack ...
    
}