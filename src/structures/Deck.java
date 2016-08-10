package structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author ashish
 *
 */

public class Deck {

	private List<Card> cards;
	
	public Deck() {
		this.cards = new ArrayList<Card>();
	}
	
	
	public void addPack(Pack p){
		cards.addAll(p.cards);
	}
	
	public Integer size(){
		return cards.size();
	}
	
	public boolean add(Card card) {
		return this.cards.add(card);
	}
	
	public boolean remove(Card card) {
		int index = 0;
		for (Card c : this.cards) {
			if (c.equals(card)) {
				this.cards.remove(index);
				return true;
			}
			index++;
		}
		return false;
	}
	
	public void removeAll(Card card) {
		int index = 0;
		for (Card c : this.cards) {
			if (c.equals(card)) {
				this.cards.remove(index);
			}
			index++;
		}
	}
	
	public void shuffle() {
		Collections.shuffle(this.cards);
	}
	
	public List<Card> deal(int n) {
		ArrayList<Card> hand = new ArrayList<Card>();
		for (int i=0; i<n; i++) {
			Card card = this.cards.get(i);
			hand.add(card);
			this.remove(card);
		}
		return hand;
	}
	
	public int cardsLeft() {
		return this.cards.size();
	}
}
