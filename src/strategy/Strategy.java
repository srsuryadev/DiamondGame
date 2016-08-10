package strategy;

import structures.Card;
import structures.Hand;

public interface Strategy {

	 public Card getNextMove(Hand handOfCards,Card bidOn);
}
