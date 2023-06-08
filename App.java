package week06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws IOException, InterruptedException {

		Deck deck = new Deck();										//instantiate deck
		
		Scanner sc = new Scanner(System.in);						//declare scanner object
		
		System.out.println("Hello, and welcome to...");				//welcome message
		System.out.println("");
		warGraphic();
		System.out.println("");

		System.out.println("A game for two players.");
		
		System.out.println("Player one, please enter your name:");	//get player one name
		String playerOneName = sc.next();
		
		System.out.println("Hello, " + playerOneName + "!");			//welcome player one
		System.out.println("");
		
		System.out.println("Player two, please enter your name:");	//get player two name
		String playerTwoName = sc.next();
		
		//sc.close();													//every time I try to close the scanner I get errors
																		//but if I don't I get messages about memory leaks. :P
		
		System.out.println("Welcome, " + playerTwoName + "!");			//welcome player two
		System.out.println("");
		
		System.out.println("Let's begin! <shuffles deck>");
		System.out.println("");
		System.out.println("(bbbbbbbbbbbbbbbbbbbbbbbrrrrrrep!)");		//shuffle deck
		deck.shuffle();
		System.out.println("");

			
		System.out.println("Now let's deal these bad boys out! (press Enter to begin)");		//deal cards to hands
		
		System.in.read();
		
		System.out.println("(fwipfwipfwipfwipfwipfwipfwip)");
					
		System.out.println("");
		
		List<Card> playerOneHand = new ArrayList<Card>();
		List<Card> playerTwoHand = new ArrayList<Card>();

		
		for (int dealCount = 0; dealCount < 52; dealCount++) {			
			if(dealCount % 2 == 0) {									//if counter is even, deal to player one
				playerOneHand.add(deck.draw());
			} else {													//if counter is odd, deal to player two
				playerTwoHand.add(deck.draw());
			}
		}
		
		Player playerOne = new Player();								//Creating player one
			playerOne.setHand(playerOneHand);
			playerOne.setName(playerOneName);
			
		Player playerTwo = new Player();								//Creating player two
			playerTwo.setName(playerTwoName);
			playerTwo.setHand(playerTwoHand);
			
		System.out.println("Okay, let's introduce our two players: " + playerOne.name + " and " + playerTwo.name + "!");
		
		System.in.read();
		
		System.out.println("");
		
		playerOne.describe();
			
		System.in.read();
		
		System.out.println("");
		
		playerTwo.describe();
			
		System.in.read();
		
		System.out.println("");
		System.out.println("Let's begin.");
		
		for (int i = 0; i < 26; i ++) {
			System.out.println("Turn " + (i+1) + " of 26:");
			System.out.println("--------------------------------");
			Card oneCard = playerOne.flip();
				System.out.println(playerOne.name + " plays...");
				oneCard.describe();
				System.out.println("");
			Card twoCard = playerTwo.flip();
				System.out.println(playerTwo.name + " plays...");
				twoCard.describe();
				System.out.println("");
			if (oneCard.value > twoCard.value) {
				playerOne.incrementScore();
				System.out.println(playerOne.name + " wins the draw, gets one point!");
				System.out.println("Current standing: " + playerOne.name + " - " + playerOne.score);
				System.out.println("                  " + playerTwo.name + " - " + playerTwo.score);
				System.out.println("");
				System.in.read();
			} else if (twoCard.value > oneCard.value) {
				playerTwo.incrementScore();
				System.out.println(playerTwo.name + " wins the draw, gets one point!");
				System.out.println("Current standing: " + playerOne.name + " - " + playerOne.score);
				System.out.println("                  " + playerTwo.name + " - " + playerTwo.score);
				System.out.println("");
				System.in.read();
			} else {
				System.out.println("Both cards have equal value: no points awarded.");
				System.out.println("Current standing: " + playerOne.name + " - " + playerOne.score);
				System.out.println("                  " + playerTwo.name + " - " + playerTwo.score);
				System.in.read();
			}
			System.in.read();
		}
		
		System.out.println("Drum roll please...");
		System.out.println("");
		Thread.sleep(1000);
		System.out.println("(duhdadaduhdadaduhdadaduhdadaduh...)");
		System.out.println("");
		Thread.sleep(1800);
		System.out.println(playerOne.name + " has " + playerOne.score + " points...");
		System.out.println("");
		Thread.sleep(1200);
		System.out.println(playerTwo.name + " has " + playerTwo.score + " points.....");
		System.out.println("");
		System.out.println("");
		Thread.sleep(2000);
		
		if (playerOne.score > playerTwo.score) {
			System.out.println(playerOne.name.toUpperCase() + " WINS!  Great job, " + playerOne.name + "!!");
		} else if (playerOne.score < playerTwo.score) {
			System.out.println(playerTwo.name.toUpperCase() + " WINS!  Great job, " + playerTwo.name + "!!");
		} else {
			System.out.println("The scores are tied! Great job, " + playerOne.name + " and " + playerTwo.name + "!!");
		}
		Thread.sleep(2000);
		System.out.println("");
		System.out.println("Thank you for playing");
		System.out.println("<takes breath>");
		System.out.println("");
		warGraphic();
		System.exit(0);
		
	}

	public static void warGraphic() {
		System.out.println("XX        XX        XX      XX          XXXXXXXXX   (tm)  ");
		System.out.println(" XX      XXXX      XX      XXXX         XX      XX    ");
		System.out.println("  XX    XX  XX    XX      XX  XX        XX     XX     ");
		System.out.println("   XX  XX    XX  XX      XXXXXXXX       XXXXXXX       ");
		System.out.println("    XXXX      XXXX      XX      XX      XX    XX      ");
		System.out.println("     XX        XX      XX        XX     XX     XX     ");
		System.out.println("     XX        XX     XX          XX    XX      XX    ");
	}
}
