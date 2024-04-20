package linkedlist;

public class singleLinkedlist {
    private Node head;
    private Node tail;
    private int size;
    public singleLinkedlist()
    {
        this.size = 0;
    } 
    private class Node
    {
        private int value;
        private Node next;
 
        public Node(int value)
        {
        this.value = value;
        }
        public Node(int value,Node next)
        {
        this.value = value;
        this.next = next;
        }
    }



public Node get(int index)
{
    Node node = head;
    for(int i=0;i<index;i++)
    {
        node=node.next;
    }
    return node;
}
public void display(){
    Node temp = head;
    while(temp != null)
    {
        System.out.print(temp.value+" -> ");
        temp = temp.next;
    }
    System.out.println("END");
}
public Node find(int value)
{
    Node node = head;int ans = -1;
    while(node.next != null){
        ans++;
        if(node.value == value)
            return node;
        else
            node=node.next;
    }
    return null;
}
public int findIndex(int value)
{
    Node node = head;int ans = -1;
    while(node.next != null){
        ans++;
        if(node.value == value)
            return ans;
        else
            node=node.next;
    }
    return ans;
}



public void insertFirst(int val){
    Node node = new Node(val);
    node.next=head;
    head=node;

    if(tail == null)
        tail = head;
    
    size += 1;
}
public void insertLast(int val){
    if(tail == null)
    {
    insertFirst(val);
    return;
    }
    Node node = new Node(val);
    tail.next=node;
    tail=node;
    size +=1;
}
public void insertAtIndex(int index,int value)
{
    if(index > size || index < 0)
    {
        System.out.println("check index");
        return ;
    }
    if(index == 0){
        insertFirst(value);
        return ;
    }
    if(index == size) 
    {
        insertLast(value);
        return;
    }
        Node temp = head;
        for(int i=0;i<index - 1;i++)
        {
            temp=temp.next;
        }
        Node node = new Node(value,temp.next);
        temp.next=node;
        size++;
}
/// INSERT USING RECURISON with VOID RETURN type
// Node actual = head;
public void insertRec(int  index, int value){
    // Node prev = actual;
    //     if(index == 0){
    //         Node newnode = new Node(value);
    //         newnode.next=actual;
    //         prev.next = newnode;
    //         return;
    //     }
        System.out.println(head.value+" is the head here");
        head = insertRecursion(value, index, head);
    
} 
    /// INSERT USING RECURSION with RETURN type as NODE
private Node insertRecursion(int value , int index, Node node){

    if(index == 0){
        Node newnode = new Node(value, node);
        size++;
        return newnode;
    }
    node.next = insertRecursion(value, index-1, node.next);
    return node;
}



public int deleteFirst()
{
    if(head ==  null)
    {
        return -1;
    }
    int val=head.value;
    head=head.next;
    size--;
    return val;
}
public int deleteLast()
{
    if(size<=1)
    {
        return deleteFirst();
    }
    Node secondLast=get(size-2);
    int val=secondLast.value;
    tail=secondLast;
    tail.next = null; 
    size--;
    return val;
}
public int  deleteAtIndex(int index)
{
    if(index == 0)
    {
        return deleteFirst();
    }
    if(index == size - 1)
    {
        return deleteLast();
    }
    Node temp = get(index - 1);
    int value = temp.value;
    temp.next = temp.next.next;
    size--;
    return value;
}

}
