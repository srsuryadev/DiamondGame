package strategy;

import java.util.Random;

import structures.Card;
import structures.Face;
import structures.Hand;
import structures.Suit;

public class SimpleStrategy implements Strategy {

	@Override
	public Card getNextMove(Hand handOfCards, Card bidOn) {

		Random randomGenerator = null;

		int index = randomGenerator.nextInt(handOfCards.cardsInHand().size());

		Suit suit = handOfCards.cardsInHand().get(index).getSuit();
		Face face = handOfCards.cardsInHand().get(index).getFace();

		Card card = new Card(suit, face);

		return card;

	}
	
}