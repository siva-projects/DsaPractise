public class segmentTreePractise {

    public static class Node{
        public int data;
        int startInterval;
        int endInterval;
        public Node left;
        public Node right;

        public Node(int startInterval, int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    Node root;

    public Node segmentTree(int[] arr){
        // create a tree using the array
        this.root = constructTree(arr, 0, arr.length-1);
        return root;
    }

    // Creating the Segment Tree...
    private Node constructTree(int[] arr, int start, int end){
        if(start == end){
            //leaf Node
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        //create new node with index you are at
        Node node = new Node(start, end);
        int mid = (start+end)/2;
        
        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid+1, end);

        node.data = node.left.data + node.right.data;
        return node;
  }


  // query 
  public int query(int qsi, int qei){
    return this.query(this.root, qsi, qei);
  }

  private int query(Node node, int qsi, int qei){
    
    if(node.startInterval >= qsi && node.endInterval <= qei){
      // node is completely inside the query...
      return node.data;
    }else if(node.startInterval > qei || node.endInterval < qsi){
      // node is completely outside the query...
      return 0;
    }else{
      return this.query(node.left, qsi, qei) + this.query(node.right,qsi,qei);
    }

  }

  // update the value at a particular index
  public void update(int index, int updateData){
    this.root.data =  this.update(this.root, index, updateData);
  }

  private int update(Node node, int index, int updateData){
    if(node.startInterval == index && node.endInterval == index){
      node.data = updateData;
      return node.data;
    }else if(node.endInterval < index || node.startInterval > index){
      return node.data;
    }
    return node.data = update(node.left, index, updateData) + update(node.right, index, updateData);
  }

  // pretty display function to display the tree 
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
          System.out.println("|----->" + node.data);
      }else{
          System.out.println(node.data);
      }

      prettyDisplay(node.left, level+1);
  }

    
    public void display() {
        display(this.root);
      }
      
    private void display(Node node) {
        String str = "";
    
        if(node.left != null) {
          str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + " => "; 
        } else {
          str = str + "No left child";
        }
    
        // for current node
        str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " <= "; 
        
        if(node.right != null) {
          str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data; 
        } else {
          str = str + "No right child";
        }
    
        System.out.println(str + '\n');
    
        // call recursion
        if(node.left != null) {
          display(node.left);
        }
    
        if(node.right != null) {
          display(node.right);
        }
      }
    

    public static void main(String[] args){
        int[] arr = {3, 8, 7, 6, -2, -8, 4, 9};
        segmentTreePractise tree = new segmentTreePractise();
        tree.segmentTree(arr);
        System.out.println("------------- before --------------");
        tree.prettyDisplay();
        System.out.println("------------- before --------------");

        tree.update(2, 14);

        System.out.println("------------- after --------------");
        tree.prettyDisplay();
        System.out.println("------------- after --------------");
        // System.out.println(tree.query(2,2 ));
        

    }
}
