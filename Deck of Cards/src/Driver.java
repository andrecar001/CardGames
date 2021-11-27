
public class Driver {
	
	public static void main(String[] args) {
		Card c1 = new Card("Ace", "Spades", 1);
		Card c2 = new Card("Two", "Clubs", 2);
		Card c3 = new Card("Three", "Hearts", 3);
		Card c4 = new Card("Four", "Diamonds", 4);
		
		
		CardList cList = new CardList();
		cList.append(c4);
		cList.prepend(c1);
		cList.insertAfter(c1,c3);
		cList.insertAfter(c1,c2);
		cList.delete(cList.get(0));
		cList.delete(cList.get(0));
		System.out.println(cList.toString());
		//System.out.println(cList.get(0));
	}

}
