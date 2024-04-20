package linkedlist;
import java.io.*;

public class doubleLinkedList{	
	private Node head;
	private Node tail;
	public int size;
	public doubleLinkedList()
	{
		this.size = 0;
	}
	private class Node
	{
		private int value;
		private Node next;
		private Node previous;
		public Node(int value)
		{
			this.value = value;
		}
		public Node(int value, Node next, Node previous)
		{
			this.value = value;
			this.next = next;
			this.previous = previous;
		}
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
			if(temp.next != null) {System.out.print(" <==> ");}
			temp = temp.next;
		}
		System.out.println("");
	}
	public Node get(int index)
	{
		// returns the value of index - 1
		if(index > size)
		{
			return null;
		}
		Node temp = head;
		for(int i=0;i<index-1;i++)
		{
			temp = temp.next;
		}
		return temp;
	}
	public int findValue(int value)
	{
		// always returns the first foud index of value
		// return -1 if not found
		int ans = 0;
		Node temp = head;
		while(temp!=null)
		{
			if(temp.value == value)
				return ans;
			else
			{
				ans += 1;temp = temp.next;
			}
		}
		System.out.println("value not in list , returning -1 ");
		return -1;
	}
	
	
	
	public void insertFirst(int value)
	{
		Node node = new Node(value);
		if(head == null && tail == null)
		{
			head = node;tail = node;
			size += 1;
			return ;
		}
		node.next = head;
		head.previous = node;
		head = node;
		size += 1;
	}
	public void insertLast(int value)
	{
		Node node = new Node(value);
		if(head == null && tail == null)
		{
			head = node;tail = node;
			size += 1;
			return ;
		}
		
		node.previous = tail;
		tail.next=node;
		tail = node;
		size += 1;
	}
	public void insertAtIndex(int index, int value)
	{
		Node temp = get(index); 
		System.out.println(temp.value);
		if(temp == null)
		{
			System.out.println("index > size, so can't insert");
			return ;
		}
		if(index == size)
		{
			insertLast(value);
		}
		else if(index == 0)
		{
			insertFirst(value);
		}
		else
		{
		Node node = new Node(value, temp.next, temp);
		temp.next.previous = node;
		temp.next = node;
		size += 1;
		}
		
	}
	
	
	
	public void deleteFirst()
	{
		if(head == tail && head!=null)
		{
			System.out.println("removed : "+head.value);
			head = null;tail = null;
			size -= 1;
			return;
		}
		if(head == null || tail == null)
		{
			System.out.println("List is already empty and can't be deleted");
			return;
		}
		System.out.println("removed : "+head.value);
		head = head.next;
		head.previous = null;
		size -= 1;
	}
	public void deleteLast()
	{
		if(head == tail && head!=null)
		{
			System.out.println("removed : "+head.value);
			head = null;tail = null;
			size -= 1;
			return;
		}
		if(head == null || tail == null)
		{
			System.out.println("List is already empty and can't be deleted");
			return;
		}
		System.out.println("removed : "+tail.value);
		Node temp = tail;
		tail = temp.previous;
		tail.next = null;
		temp.previous = null;
		size -= 1;
	}
	public void deleteAtIndex(int index)
	{
		if(index == 0)
		{
			deleteFirst();
			return;
		}
		if(index == size-1)
		{
			deleteLast();
			return;
		}
		Node temp = get(index);
		Node delete = temp.next;
		System.out.println("removed : "+delete.value);
		temp.next = delete.next;
		delete.next.previous = delete.previous;
		delete.next=null;delete.previous=null;
		size -= 1;
	}
	public void deleteValue(int value)
	{
		int index = findValue(value);
		if(index == -1) {
			return;
		}
		deleteAtIndex(index);
	}
}