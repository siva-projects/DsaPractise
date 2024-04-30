package linkedlist;

import java.util.LinkedList;

public class linkedlistInterviewQuestions{
	private static ListNode head;
	private static ListNode tail;
	private static int size;
	public linkedlistInterviewQuestions() {
		this.size = 0;
	}
	private class ListNode{
		private int value;
		private ListNode next;
		public ListNode(int value)
		{
			this.value = value;
		}
		public ListNode(int value, ListNode next)
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
	
	
	
	
	public ListNode recursiveInsert(int value, int index, ListNode head) {
		// handled in a way such that if index is > 0 and < size , this will trigger
		ListNode temp = head;
		if(index == 0)
		{
			System.out.println("Inserting value : "+value+" in index : "+index);
			ListNode node = new ListNode(value);
			node.next = head;
			size += 1;
			return node;
		}
		size += 1;
		ListNode node = recursiveInsert(value, index-1, head.next);
		head.next = node;
		return head;
	}
	
	
// question-1	 remove duplicated from a list 
	// 1 -> 1 -> 2  Expected Output should be 1 -> 2
//	public ListNode deleteDuplicates(ListNode head) {
//        if(head == null || head.next == null)
//        {
//            return head;
//        }
//        ListNode first = head, second = head.next;
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
//	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        if(list1 == null)
//            return list2;
//        else if(list2 == null)
//            return list1;
//        else{
//        ListNode first = list1;
//        ListNode second = list2;
//        ListNode mergedList = new ListNode();
//        ListNode ans = mergedList;
//        while(first != null && second != null)
//        {
//            // System.out.println(first.value+" : first, second: "+second.value);
//            if(first.value < second.value)
//            {
//                ListNode node = new ListNode(first.value);
//                first = first.next;
//                mergedList.next = node;
//            }else{
//                ListNode node = new ListNode(second.value);
//                second = second.next;
//                mergedList.next = node;
//            }
//            mergedList = mergedList.next;
//        }
//        while(first!=null)
//        {
//            ListNode node = new ListNode(first.value);
//            first = first.next;
//            mergedList.next = node;
//            mergedList = mergedList.next;
//        }
//        while(second != null)
//        {
//            ListNode node = new ListNode(second.value);
//            second = second.next;
//            mergedList.next = node;
//            mergedList = mergedList.next;
//        }
//        return ans.next;
//        }
//    }
//	
	
	
	
	
// Question - 3 Linked List Cycle
	public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head; 
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }
	
	
	
	
	// length of linked list cycle
	public int linkedListLength(ListNode head)
	{
		ListNode fast = head;
        ListNode slow = head; 
        
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
	public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head; 
        ListNode temp =head;
        
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
    public ListNode findlen(ListNode fast,ListNode slow,ListNode head)
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
    
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
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
 
    
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
		{
			return head;
		}
		ListNode back = null;
		ListNode temp = head.next;
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
    
    public ListNode reverseListUsingRecursion(ListNode head) {
        if(head==null || head.next==null)
		{
			return head;
		}
        ListNode ans = head;
        while(ans.next!=null)
        {
            ans = ans.next;
        }
        reverse(head);
        head.next = null;
        return ans;
    }

    public ListNode reverse(ListNode node)
    {
        if(node.next == null)
        {
            return node;
        }
        ListNode first = reverse(node.next);
        first.next = node;
        return node;
    }
    
    
    
    
/// Question 9 - Reverse a linked list II , 
/// leetcode - https://leetcode.com/problems/reverse-linked-list-ii/description/
 
    // Kushal approach
    
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        if(left == right )
//        {
//        	return head;
//        }
//        
//        // skip the first left-1 nodes
//        ListNode current = head;
//        ListNode prev = null;
//        for(int i=0; current != null && i < left - 1;i++)
//        {
//        	prev = current;
//        	current = current.next;
//        }
//        
//        ListNode last = prev;
//        ListNode newEnd = current;
//        
//        // reverse betweeen left and right
//        ListNode next = current.next;
//        for(int i=0; current != null && i < right - left + 1;i++)
//        {
//        	current.next = prev;
//        	prev= current;
//        	current = next;
//        	if(next!=null)
//        	{
//        		next = next.next;
//        	}
//        }
//        
//        if(last != null)
//        	last.next = prev;
//        else
//        	head = prev;
//        
//        newEnd.next = current;
//        return head;
//    }
    
    
// my approach 
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null || right-left==0){
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        // skipping left-1 nodes
        ListNode prev=dummy;
        ListNode curr=head;
        for(int i=0;i<left-1;i++){
            prev = curr;
            curr = curr.next;
        }
        ListNode reversedHead = reverseBasedOnNumber(curr, right-left);
        prev.next = reversedHead;
        return dummy.next;
    }
    public ListNode reverseBasedOnNumber(ListNode head, int n){
            if(head.next == null){
                    return head;
                }
                ListNode temp = head;
                ListNode back = null;
                ListNode first = head;
                ListNode second = head.next;
                for(int i=0;i<n;i++){
                    first.next = back;
                    back=first;
                    first=second;
                    second = second.next;
                }
                first.next=back;
                temp.next = second;
                return first;
    }
    }
 //////////////////////////////////
 
 
 //Question - 10    Palindrome linked list
 // leetcode link - https://leetcode.com/problems/palindrome-linked-list/description/
 
 public boolean isPalindrome(ListNode head) {
     ListNode temp = head;
     ListNode newListHead = new ListNode(temp.value);

     ListNode temp2= newListHead;
     temp=temp.next;
     while(temp!=null)
     {
         ListNode node= new ListNode(temp.value);
         temp2.next = node;
         temp2=temp2.next;
         temp = temp.next;
     }
     ListNode reverseListNode = reversePalindrome(newListHead);
     while(head!=null)
     {
         if(head.value != reverseListNode.value){
             return false;
         }else{
             head = head.next;
             reverseListNode = reverseListNode.next;
         }
     }
     return true;

 }

 public ListNode reversePalindrome(ListNode head){
     if(head.next == null){return head;}
     ListNode back = null;
     ListNode first = head;
     ListNode second = head.next;
     while(second!=null)
     {
         first.next = back;
         back = first;
         first = second;
         second= second.next;
     }	
     first.next = back;
     return first;
 }
 
 
 
 //////////////////
 // Question 11 - Reorder List 
 // leetcode link - https://leetcode.com/problems/reorder-list/description/
 
 public void reorderList(ListNode head) {
     if(head.next == null){ return ; }
     int length = 0;
     ListNode t = head;
     while(t.next!=null){ length = length + 1; t=t.next;}
     
     ListNode first = head, second = createAndReturnNewList(head);
     ListNode temp = first.next;
     for(int i=0;i<=length-1;i++)
     {
         first.next = second;
         first = second;
         second=temp;
         temp = first.next;
     }
     first.next = null;
     return ;
 }

 public ListNode createAndReturnNewList(ListNode head){
     
     ListNode temp = head;
     ListNode newListHead = new ListNode(temp.value);

  ListNode temp2= newListHead;
  temp=temp.next;
  while(temp!=null)
  {
      ListNode node= new ListNode(temp.value);
      temp2.next = node;
      temp2=temp2.next;
      temp = temp.next;
  }
  return reverse(newListHead);
 }

 public ListNode reverse(ListNode head){
     if(head.next == null){
         return head;
     }
     ListNode back = null;
     ListNode first = head;
     ListNode second = head.next;
     while(second!=null){
         first.next = back;
         back=first;
         first=second;
         second = second.next;
     }
     first.next=back;
     return first;
 }
 public void display(ListNode head){
     while(head!=null){
         System.out.print(head.value+" -> ");
         head = head.next;
     }
     System.out.println("");
 }
 
 
 //////////////////////////////////////////////////////////////////////////////////
   
////////////////////////////////////////////////////////////////////////////////////
    
	
	public ListNode insertFirst(int value)
	{
		ListNode node = new ListNode(value);
		node.next = head;
		head = node;
		
		if(tail == null)
	        tail = head;
		
		size += 1;
		return head;
	}
	public ListNode insertLast(int value)
	{
		if(tail == null)
		{
			insertFirst(value);
			return null;
		}
		ListNode node = new ListNode(value);
		tail.next=node;
		tail = node;
		size += 1;
		return tail;
		
	}
	public void display()
	{
		ListNode temp = head;
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



// Queston 17 - Rotate Linked LIst 
// Leetcode link - https://leetcode.com/problems/rotate-list/

public ListNode rotateRight(ListNode head, int k) {
    if(head==null || head.next == null ){
        return head;
    }
    // finding length
    int len=1;
    ListNode temp = head;
    while(temp.next!=null){
        len += 1;
        temp = temp.next;
    }
    if(k<len){
    return reverseListOnDemand(head, k);
    }else{
    return reverseListOnDemand(head, (k%len));
    }
}
public ListNode reverseListOnDemand(ListNode head, int k){
    if(head.next == null){
        return head;
    }
    ListNode first = head;
    ListNode second = head.next;
   for(int i=0;i<k;i++){
        ListNode newHead = Need(head, first, second);
        head = newHead;
        first = head;
        second = head.next;
   }
   return head;
}

public ListNode Need(ListNode head, ListNode first, ListNode second){
    while(second.next!=null){
        first = first.next;
        second = second.next;
    }
    first.next=null;
    second.next = head;
    head = second;
    return head;
}

}
//////////////////////////////////////////////////////////////////


// pending Questions -   15, 16

//https://leetcode.com/problems/add-two-numbers/description/

