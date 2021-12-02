import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File cardFile = new File("C:\\Users\\crdan\\git\\CardGames\\Deck of Cards\\Cards.txt.txt");
		CardList allCards = new CardList();
		readFile(cardFile,allCards);
		Deck deck = new Deck(allCards);
		//deck.shuffle();
		runBlackJack(deck);
		/*System.out.println(deck.toString());
		deck.printInDeck();
		Card hand = deck.grabCard();
		deck.printInDeck();
		System.out.println("\n" + hand.toString() + "\n");
		deck.getDeck().sort();
		System.out.println("SORTING DECK \n ----------------------------");
		deck.printInDeck();
		*/
	}
	
	public static void readFile(File f, CardList cList) throws FileNotFoundException {
		Scanner read = new Scanner(f);
		String currLine, currSuit, currRank;
		int currID;
		Card currCard;
		while(read.hasNextLine()) {
			currLine = read.nextLine();
			
			currRank = currLine.split("%")[1];
			
			currSuit = currLine.split("%")[0];
			
			currID = Integer.parseInt(currLine.split("%")[2]);
			currCard = new Card(currSuit, currRank, currID);
			cList.append(currCard);
		}
		read.close();
	}

	public static void runBlackJack(Deck deck) {
		Scanner scan = new Scanner(System.in);
	
		
		
	}
	
	public static int getValue(Card c) {
		switch(c.getRank()) {
			case "ACE":
				return 1;
			case "TWO":
				return 2;
			case "THREE":
				return 3;
			case "FOUR":
				return 4;
			case "FIVE":
				return 5;
			case "SIX":
				return 6;
			case "SEVEN":
				return 7;
			case "EIGHT":
				return 8;
			case "NINE":
				return 9;
			case "TEN":
				return 10;
			case "JACK":
				return 10;
			case "QUEEN":
				return 10;
			case "KING":
				return 10;
		}
		return -1;
	}
	
	public static int handTotal(CardList hand) {
		int total = 0;
		for(int i = 0; i < hand.length(); i++) {
			total = total + getValue(hand.get(i));
		}
		return total;
	}
}
