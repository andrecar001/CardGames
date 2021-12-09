
public class Deck {
	private final int MAX_CARDS;
	private CardList ALL_CARDS;				//Array of all cards in the deck
	private CardList inDeck;			//List of cards currently IN deck
	private CardList outOfDeck;		//Array of Cards out of the deck
	
	public Deck(CardList ALL_CARDS) {
		this.ALL_CARDS = ALL_CARDS;
		this.inDeck = new CardList();
		this.outOfDeck = new CardList();
		MAX_CARDS = ALL_CARDS.length();
		for(int i = 0; i < ALL_CARDS.length(); i++) {
			this.inDeck.append(ALL_CARDS.get(i));
		}
	}
	
	
	//Get cards Currently in deck
	public CardList getDeck() {
		return inDeck;
	}
	//Get cards currently out of deck
	public CardList getOutOfDeck() {
		return outOfDeck;
	}
	//Grab a card from the top of the deck
	public Card draw() {
		Card card = inDeck.get(0);
		inDeck.delete(card);
		outOfDeck.prepend(card);
		return card;
	}
	
	//Insert a card at the top of the deck
	public void insertTop(Card c) {
		if(inDeck.length() == MAX_CARDS) {
			throw new IndexOutOfBoundsException();
		}
		
		inDeck.prepend(c);
	}
	//Insert a card at the bottom of the deck
	public void insertBottom(Card c) {
		if(inDeck.length() == MAX_CARDS) {
			throw new IndexOutOfBoundsException();
		}
		
		inDeck.append(c);
	}
	//Insert a card randomly in the deck
	public void insertRand(Card c) {
		if(inDeck.length() == MAX_CARDS) {
			throw new IndexOutOfBoundsException();
		}
		int insertIdx = (int) (Math.random()*inDeck.length());
		inDeck.insertAfter(inDeck.get(insertIdx), c);
	}

	//Shuffle Deck
	public void shuffle() {
		CardList newDeck = new CardList();
		int size = inDeck.length();
		while(newDeck.length() < size) {
			int currSize = inDeck.length();
			int idx = (int) (Math.random()*currSize);
			Card randomCard = inDeck.get(idx);
			inDeck.delete(randomCard);
			newDeck.append(randomCard);
		}
		inDeck = newDeck;
		
	}
	//Sort deck
	/*
	public void sortDeck() {
		inDeck.sort();
	}
	*/
	//Reset deck
	public void resetDeck() {
		while(inDeck.get(0) != null) {
			inDeck.delete(inDeck.get(0));
		}
		
		for(int i = 0; i < ALL_CARDS.length(); i++) {
			this.inDeck.append(ALL_CARDS.get(i));
		}
	}
	//print in deck
	public void printInDeck() {
		System.out.println("CARDS IN DECK:");
		System.out.println(inDeck.toString());
	}
	
	//Print out of deck
	public void printOutOfDeck() {
		System.out.println("CARDS OUT OF DECK:");
		System.out.println(outOfDeck.toString());
	}
	//Print full deck
	public void printFullDeck() {
		System.out.println("ALL CARDS:");
		System.out.println(ALL_CARDS.toString());
	}
	
	
}
