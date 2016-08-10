package strategy;

import structures.Card;
import structures.Face;
import structures.Hand;
import structures.Suit;

public class MediumComplexityStrategy implements Strategy{
	
	 @Override
	   public Card getNextMove(Hand handOfCards,Card bidOn) {
		 Suit suit = handOfCards.cardsInHand().get(0).getSuit();
		 Face face = bidOn.getFace();
	     return new Card(suit,face);
	   }
}