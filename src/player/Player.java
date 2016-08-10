package player;

import structures.Hand;
import structures.PointCards;

import java.util.List;

import structures.Card;

public class Player {
	private Hand h;
	private PointCards pointCards;
	
	public Player(){
		h = new Hand();
		pointCards = new PointCards();
	}

	public boolean setHand(Hand h){
		return true;
	}
	
	public boolean addPointCards(List<Card> A){
		pointCards.add(A);
		return true;
	}
	
	public List<Card> getHand(){
		return (List<Card>) h;
	}
	
	public List<Card> getPointsCards(){
		return (List<Card>) pointCards;
	}
}
