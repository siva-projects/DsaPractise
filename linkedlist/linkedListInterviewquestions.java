package linkedlist;

import java.util.LinkedList;

public class linkedlistInterviewQuestions{
	private static Node head;
	private static Node tail;
	private static int size;
	public linkedlistInterviewQuestions() {
		this.size = 0;
	}
	private class Node{
		private int value;
		private Node next;
		public Node(int value)
		{
			this.value = value;
		}
		public Node(int value, Node next)
		{
			this.value = value;
			this.next = next;
		}
	}

	public static void main(String[] args)
	{
		linkedlistInterviewQuestions lq = new linkedlistInterviewQuestions();
		lq.insertFirst(1);
		lq.insertFirst(0);
		System.out.println(lq.isHappy(3));
	}
	
	
	
	
	public Node recursiveInsert(int value, int index, Node head) {
		// handled in a way such that if index is > 0 and < size , this will trigger
		Node temp = head;
		if(index == 0)
		{
			System.out.println("Inserting value : "+value+" in index : "+index);
			Node node = new Node(value);
			node.next = head;
			size += 1;
			return node;
		}
		size += 1;
		Node node = recursiveInsert(value, index-1, head.next);
		head.next = node;
		return head;
	}
	
	
// question-1	 remove duplicated from a list 
	// 1 -> 1 -> 2  Expected Output should be 1 -> 2
//	public Node deleteDuplicates(Node head) {
//        if(head == null || head.next == null)
//        {
//            return head;
//        }
//        Node first = head, second = head.next;
//        while(second!=null)
//        {
//            if(first.value == second.value)
//            {
//                first.next = null;
//                second = second.next;
//            }else{
//                first.next = second;
//                first=second;
//                second = second.next;
//            }
//        }
//        return head;
//    }
	
	
	
	
// Question-2  Given two sorted lists , they have to be merged together in a sorted way
	// list1 = 1 -> 2 -> 4 ; list2 = 1 -> 3 -> 4 ; Expected Output = 1 - > 1 - > 2 - > 3 - > 4 - > 4
//	public Node mergeTwoLists(Node list1, Node list2) {
//        if(list1 == null)
//            return list2;
//        else if(list2 == null)
//            return list1;
//        else{
//        Node first = list1;
//        Node second = list2;
//        Node mergedList = new Node();
//        Node ans = mergedList;
//        while(first != null && second != null)
//        {
//            // System.out.println(first.value+" : first, second: "+second.value);
//            if(first.value < second.value)
//            {
//                Node node = new Node(first.value);
//                first = first.next;
//                mergedList.next = node;
//            }else{
//                Node node = new Node(second.value);
//                second = second.next;
//                mergedList.next = node;
//            }
//            mergedList = mergedList.next;
//        }
//        while(first!=null)
//        {
//            Node node = new Node(first.value);
//            first = first.next;
//            mergedList.next = node;
//            mergedList = mergedList.next;
//        }
//        while(second != null)
//        {
//            Node node = new Node(second.value);
//            second = second.next;
//            mergedList.next = node;
//            mergedList = mergedList.next;
//        }
//        return ans.next;
//        }
//    }
//	
	
	
	
	
// Question - 3 Linked List Cycle
	public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head; 
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }
	
	
	
	
	// length of linked list cycle
	public int linkedListLength(Node head)
	{
		Node fast = head;
        Node slow = head; 
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
            {
            	int len = 1;
            	slow = slow.next;
            	while( slow != fast)
            	{
            		len +=  1;
            		slow = slow.next;
            	}
            	return len;
            }
        }
        return -1;
        
	}
	
	
// Question - 4 Linked list cycle II
// leetcode link  -  https://leetcode.com/problems/linked-list-cycle-ii/description/
	public Node detectCycle(Node head) {
        Node fast = head;
        Node slow = head; 
        Node temp =head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
            {
                return findlen(fast,slow,temp);
            }
        }
        return null;
    }
    public Node findlen(Node fast,Node slow,Node head)
    {
        int len = 0;
        do{
            len++;
            fast = fast.next;
        }while(fast != slow);
        
        slow=head;
        while(slow != null)
        {
            int n = len;
            fast = slow;
            while( n > 0)
            {
             fast = fast.next;
             if(slow == fast)
                { 
                 return slow;
                }
            n = n - 1;
            }
            slow = slow.next;
        }
   
        return null;
    }
	
	
    
    // Question 5 -- find happy Number or not 
    // leetcode Link - https://leetcode.com/problems/happy-number/submissions/847319372/
    
    public boolean isHappy(int n)
    {
    	
    // Cool approach
    	 int fast = n;int slow = n;
         do
         {
         slow = square(slow);
         fast = square(square(fast));
         }while(slow != fast);
         
         if(slow == 1)
             return true;
         else
             return false;
         
         
// 	A little bit easy approach 
//        LinkedList l = new LinkedList();
//        
//        int temp = getSum(n);
//        l.add(temp);
//        while(temp != 1)
//        {
//            int number = getSum(temp);
//            if(l.indexOf(number) != -1 ) return false;
//            l.add(number);
//            temp = number;
//        }
//        return true;
        
    }
    public int square(int n)
    {
        System.out.println("cal for "+n);
        int temp = n;int sum = 0;
        while(temp!=0)
        {
            int t = temp%10;
            sum  = sum + (t * t);
            temp = temp/10;
        }
        System.out.println("returning sum "+sum);
        return sum;
    }
	
    
    
    
    
// Question 6 - Middle of a linked List 
// Leetcode link - https://leetcode.com/problems/middle-of-the-linked-list/description/
    
    public Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    
    
    
// Question 7  -- Sort a linked list 
// Wrote an answer same as bubble sort, got time limit exceeded error, 
// kept on hold to write solution same as merge sort..
    
    
    
    
    
    
    
    
    
    
    
    
// Question 8 -- Reverse a linked list 
// just return a linked list and return the head;
 
    
    public Node reverseList(Node head) {
        if(head==null || head.next==null)
		{
			return head;
		}
		Node back = null;
		Node temp = head.next;
		while(temp!=null)
		{
			head.next = back;
			back=head;
			head=temp;
			temp=temp.next;
		}
		head.next=back;
        return head;
    }
      
   
// Doing the same reversing list , this time using recursion 
    
    public Node reverseListUsingRecursion(Node head) {
        if(head==null || head.next==null)
		{
			return head;
		}
        Node ans = head;
        while(ans.next!=null)
        {
            ans = ans.next;
        }
        reverse(head);
        head.next = null;
        return ans;
    }

    public Node reverse(Node node)
    {
        if(node.next == null)
        {
            return node;
        }
        Node first = reverse(node.next);
        first.next = node;
        return node;
    }
    
    
////////////////////////////////////////////////////////////////////////////////////
    
	
	public Node insertFirst(int value)
	{
		Node node = new Node(value);
		node.next = head;
		head = node;
		
		if(tail == null)
	        tail = head;
		
		size += 1;
		return head;
	}
	public Node insertLast(int value)
	{
		if(tail == null)
		{
			insertFirst(value);
			return null;
		}
		Node node = new Node(value);
		tail.next=node;
		tail = node;
		size += 1;
		return tail;
		
	}
	public void display()
	{
		Node temp = head;
		if(temp == null) {
			System.out.println("LinkedList is empty ");
		}
		while(temp!=null)
		{
			System.out.print(temp.value);
			if(temp.next != null) {System.out.print(" -> ");}
			temp = temp.next;
		}
		System.out.println("");
	}
}