package linkedlist;

public class linkedprac {

	public static void main(String[] args) {

		//    singleLinkedlist slist = new singleLinkedlist();
		//    slist.insertFirst(77);
		//    slist.insertFirst(44);
		//    slist.insertFirst(23);
		//    slist.insertFirst(55);
		//    slist.insertRec(2, 11);
		//    slist.display();

		   doubleLinkedList dl = new doubleLinkedList();
		
//		dl.insertAtIndex(9, 100);
//		dl.insertAtIndex(0, -2);
		dl.insertAtIndex(3, 1);
		dl.deleteAtIndex(0);
		dl.display();
		dl.deleteAtIndex(3);
		dl.display();
		dl.deleteAtIndex(1);
		dl.display();
		dl.deleteAtIndex(3);
		dl.display();
		System.out.println(dl.findValue(6));
		System.out.println(dl.findValue(1));
		System.out.println(dl.findValue(3));
		System.out.println(dl.findValue(-1));
		dl.deleteValue(3);
		dl.display();
		dl.deleteValue(1);
		dl.display();
	}

}
