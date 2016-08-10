package structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hand {
	private List<Card> cards;
	
	public Hand(){
		this.cards = new ArrayList<Card>();
	}
	
	public Hand(List<Card> cards){
		this.cards = cards;
	}
	/**
	 * Adds a card to the Hand
	 * @param num Position of the card.
	 * @return returns a success
	 */
	public boolean addCard(Card c){	
		return cards.add(c);
	}
	
	
	
	public Integer size(){
		return cards.size();
	}
	/**
	 * removes a card from the Hand
	 * @param num Position of the card.
	 * @return returns a success
	 */
	public boolean removeCard(Card c){
		return cards.remove(c);
	}
	
	/**
	 * sorts the cards in the hand
	 * @return returns the shuffled list of cards
	 */
	public void sortBySuit(){
		this.cards.sort(new Comparator<Card>(){
			  @Override
			    public int compare(Card o1, Card o2) 
			    {
			          return o1.getSuit().ordinal() - o2.getSuit().ordinal();
			    }

		});
	}
	
	public void sortByFace(){
		this.cards.sort(new Comparator<Card>(){
			  @Override
			    public int compare(Card o1, Card o2) 
			    {
			          return o1.getFace().ordinal() - o2.getFace().ordinal();
			    }

		});
	}

	/*
	 *  @return returns the card in the hand
	 */
	public List<Card> cardsInHand(){
		return cards;
	}
}
