package week06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
	
	List<Card> hand = new ArrayList<Card>();
	int score = 0;
	String name;
	
	Random random = new Random();
	
	String[] movie = { "Bridge Over the River Kwai", "Charade", "Back to the Future Part III", 
			"Rambo: First Blood", "Trading Places", "Smokey and The Bandit", "My Stepmother is an Alien", "Send Me No Flowers",
			"Clue", "Hell Comes to Frogtown" };
	String[] food = { "pizza", "mashed potatoes", "baloney samwich", "lobster", "polish sausage", "spaghetti",
			"pork chop johns", "corned beef", "macaroni and cheese", "Lucky Charms" };
	
	public List<Card> getHand() {
		return hand;
	}
	
	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void describe() throws IOException {						//describe method including randomized
		int rand = random.nextInt(9);								//favorite movie and food
		int rand2 = random.nextInt(9);
		System.out.println("Player name: " + name + ".");
		System.out.println("Favorite movie: " + movie[rand]);
		System.out.println("Favorite food: " + food[rand2]);
		System.in.read();
		for (Card card : this.hand) {
			card.describe();
		}
	}
	
	public Card flip() {
		Card draw = this.hand.remove(0);
		return draw;
	}
	
	public void draw() {
		
	}
	
	public void incrementScore() {
		score += 1;
	}
}
