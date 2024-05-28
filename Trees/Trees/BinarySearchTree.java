import java.util.Arrays;

public class BinarySearchTree {

    public class Node{
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value){
            this.value = value;
        }
        
        public int getValue(){
            return value;
        }
    }

    private Node root;

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root==null;
    }

    // INSERTING THE NODE

    public void insert(int value){
        root = insert(value, root);
    }

    private Node insert(int value, Node node){
        if(node == null){
            return new Node(value);
        }

        if(value < node.value){
            node.left = insert(value, node.left);
        }

        if(value > node.value){
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    // Just populating 
    public void populate(int[] nums){
        for(int i=0;i<nums.length;i++){
            insert(nums[i]);
        }
    }


    // populating Sorted
    public void populateSorted(int[] nums){
        populateSorted(0,nums.length,nums);
    }

    private void populateSorted(int start,int end, int[] nums){
        if(start>=end){
            return;
        }

        int mid = (start+end)/2;
        insert(nums[mid]);
        populateSorted(start, mid, nums); // for inserting left side of array
        populateSorted(mid+1, end, nums);
    }


    // Checking whether tree created is balanced or not

    public boolean balanced(){
        return balanced(root);
    }

    private boolean balanced(Node node){
        if(node == null){
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }




    // to Display the tree

    public void display(){
        prettyDisplay(root, 0);
    }

    public void prettyDisplay(Node node, int level){
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
    BinarySearchTree tree = new BinarySearchTree();
		 int[] nums = {5,6,7,8,2,3,4,1};
		 Arrays.sort(nums);
		 tree.populateSorted(nums);
//		 tree.populate(nums);
		 tree.display();
}
}