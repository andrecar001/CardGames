/**
 * Doubly-LinkedList of Cards
 * 
 * @author crdan_000
 *
 */
public class CardList {
	/**
	 * The node used by CardList
	 *
	 */
	private class CardNode{
		Card data;
		CardNode next;
		CardNode prev;
	}
	
	/*
	 * Instance Variables
	 */
	private CardNode head;
	private CardNode tail;
	
	public CardList() {
		head = null;
		tail = null;
	}
	//prepend
	public void prepend(Card c) {
		var newNode = new CardNode();
		newNode.data = c;
		newNode.next = null;
		newNode.prev = null;
		
		if(head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			newNode.next = head;
			head = newNode;
			newNode.next.prev = newNode;
		}
	}
	//append
	public void append(Card c) {
		var newNode = new CardNode();
		newNode.data = c;
		newNode.next = null;
		newNode.prev = null;
		
		if(head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
	}
	//insertAfter
	public boolean insertAfter(Card curCard, Card newCard) {
		CardNode curNode = search(curCard);
		CardNode newNode = new CardNode();
		newNode.data = newCard;
		newNode.next = null;
		newNode.prev = curNode;
		if(head == null) {
			head = newNode;
			tail = newNode;
			return true;	
		}
		else if(curNode == tail) {
			
			tail.next = newNode;
			tail = newNode;
			return true;
		}
		else {
			newNode.next = curNode.next;
			curNode.next = newNode;
			return true;
		}
	}
	//delete
	public boolean delete(Card c) {
		CardNode curNode = search(c);
		var sucNode = curNode.next;
		var predNode = curNode.prev;
		
		if(sucNode != null) {
			sucNode.prev = predNode;
		}
		if(predNode != null) {
			predNode.next = sucNode;
		}
		if(curNode == head) {
			head = sucNode;
		}
		if(curNode == tail) {
			tail = predNode;
			
		}
		
		return true;
	}
	//get
	public Card get(int n) {
		int count = 0;
		CardNode curNode = head;
		while(count < n) {
			if(curNode == null) {
				throw new IndexOutOfBoundsException();
			}
			curNode = curNode.next;
			count++;
		}
		return curNode.data;
	}
	//length
	public int length() {
		int count = 0;
		CardNode curNode = head;
		while (curNode != null) {
			curNode = curNode.next;
			count++;
		}
		return count;
	}
	
	public CardNode search(Card key) {
		CardNode curNode = head;
		
		while(curNode != null) {
			if(curNode.data.equals(key)) {
				return curNode;
			}
			curNode = curNode.next;
		}
		return null;
	}
	//TODO Create sorting method
	public void sort() {
		head = mergeSort(head);
		
	}
	
	private CardNode mergeSort(CardNode start) {
		//We'll use a Merge sort here
		if(start == null || start.next == null) {
			return start;
		}
		
		CardNode[] arr = split(start);
		CardNode firstHalf = arr[0];
		CardNode secondHalf = arr[1];
		
		firstHalf = mergeSort(firstHalf);
		secondHalf = mergeSort(secondHalf);
		
		return merge(firstHalf, secondHalf);
		
	}
	private CardNode merge(CardNode list1, CardNode list2) {
		//Base Case
		if(list1 == null) {
			return list2;
		}
		else if(list2 == null) {
			return list1;
		}
		
		CardNode result;
		if(list1.data.compareTo(list2.data) <= 0) {
			result = list1;
			result.next = merge(list1.next,list2);
		}
		else {
			result = list2;
			result.next = merge(list1,list2.next);
		}
		return result;
	}
	private CardNode[] split(CardNode pointer) {
		//Base Case
		if(pointer == null || pointer.next == null) {
			return new CardNode[] {pointer, null};
		}
		
		CardNode backward = pointer;
		CardNode forward = pointer.next;
		
		while(forward != null) {
			forward = forward.next;
			if(forward != null) {
				backward = backward.next;
				forward = forward.next;
			}
			
		}
		
		CardNode[] arr = new CardNode[] {pointer, backward.next};
		backward.next = null;
		return arr;
	}
	
	//toString
	@Override
	public String toString() {
		String finString = "";
		CardNode curNode = head;
		while(curNode != null) {
			finString = finString + curNode.data.toString() + "\n";
			curNode = curNode.next;
		}
		return finString;
	}

}
