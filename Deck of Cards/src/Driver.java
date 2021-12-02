import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) throws FileNotFoundException {
		/*
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
		 * 
		 */
		File cardFile = new File("C:\\Users\\crdan\\git\\CardGames\\Deck of Cards\\Cards.txt.txt");
		CardList allCards = new CardList();
		readFile(cardFile,allCards);
		Deck deck = new Deck(allCards);
		deck.shuffle();
		
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

	public static void runBlackjack(Deck deck) {
		Scanner scan = new Scanner(System.in);
		int playerCount;
		ArrayList<CardList> allHands = new ArrayList<>();
		System.out.println("Shuffling Deck...");
		deck.shuffle();
		System.out.print("How many people are playing: ");
		playerCount = scan.nextInt();
		
		for(int i = 0; i < playerCount; i++) {
			CardList startHand = new CardList();
			startHand = new CardList();
			//Everyone starts with two cards
			startHand.append(deck.grabCard());
			startHand.append(deck.grabCard());
			allHands.add(startHand);
		}
		
		boolean keepGoing = true;
		
		while(keepGoing) {
			System.out.println("Hit or Pass(H/P)");
			String input = scan.next();
			if(input.toLowerCase().equals("p") || input.toLowerCase().equals("pass")) {
				System.out.println("Continuing to next player");
				break;
			}
			
			
		}
		
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
	
	
}
