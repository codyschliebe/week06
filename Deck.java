package week06;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Deck {

	List<Card> cards = new ArrayList<Card>();

	Deck() {

	String[] numbers = { "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace" };
	String[] suits = { "hearts", "diamonds", "clubs", "spades" };

		for (String suit : suits) {
			int count = 2;
			for (String numberName : numbers) {
				cards.add(new Card(numberName, suit, count));				
				count++;
			}
		}

	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public void describe() {
		for (Card card : this.cards) {
			card.describe();
		}
	}

	public void shuffle() {
		Collections.shuffle(this.cards);
	}

	public Card draw() {
		Card draw = this.cards.remove(0);
		return draw;
	}	

}