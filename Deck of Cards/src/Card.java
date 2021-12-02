
public class Card {
	//Base Variables
	private String rank;
	private String suit;
	private int cardID;
	
	public Card(String rank, String suit, int cardID) {
		this.rank = rank;
		this.suit = suit;
		this.cardID = cardID;
	}
	
	public String getRank() {
		return this.rank;
	}
	
	public String getSuit() {
		return this.suit;
	}

	public int getID() {
		return this.cardID;
	}
	
	@Override
	public String toString() {
		return "RANK: " + this.rank + " | SUIT: " + this.suit + " | ID: " + this.cardID;
	}
	
	public boolean equals(Card c) {
		if(this.cardID == c.getID()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int compareTo(Card c) {
		return this.cardID - c.getID();
	}
	

}
