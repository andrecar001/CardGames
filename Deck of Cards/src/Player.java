
public class Player {
	private static int PlayerID = 1000;//Player id
	private CardList hand;			//List of cards in players hand
	private int handValue;//value of players hand
	
	public Player() {
		this.hand = new CardList();
		PlayerID++;
	}
	
	public Player(CardList hand) {
		this.hand = hand;
		PlayerID++;
		for(int i= 0;i < hand.length();i++) {
			handValue += hand.get(i).getValue();
		}
	}
	//get player id
	public int getID() {
		return PlayerID;
	}
	//get hand
	public CardList getHand() {
		return hand;
	}
	//draw card
	public void drawCard(Card c) {
		hand.append(c);
		handValue += c.getValue();
	}
	
	public Card playCard(Card c) {
		for(int i = 0; i < hand.length();i++) {
			if(hand.get(i).equals(c)) {
				hand.delete(c);
				handValue -= c.getValue();
				return c;
			}
				
		}
		throw new NullPointerException();
	}

	
}
