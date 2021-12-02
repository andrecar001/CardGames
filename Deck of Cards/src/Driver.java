import java.io.File;
import java.io.FileNotFoundException;
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
		deck.shuffleDeck();
		
		//System.out.println(deck.toString());
		deck.printInDeck();
		Card hand = deck.grabCard();
		deck.printInDeck();
		System.out.println("\n" + hand.toString() + "\n");
		deck.getDeck().sort();
		System.out.println("SORTING DECK \n ----------------------------");
		deck.printInDeck();
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

}
