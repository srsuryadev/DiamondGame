package player;

import structures.Hand;
import structures.PointCards;

import java.util.List;

import strategy.Strategy;
import structures.Card;

public class Player {
	private Hand hand;
	private Strategy strategy; 
	private String playerId;
	
	
	public Player(Strategy s, String playerId){
		this.strategy = s;
		this.playerId = playerId;
	}
		
	public List<Card> getHand(){
		return (List<Card>) hand.cardsInHand();
	}
	
	public void allotHand(Hand h){
		this.hand = h;
	}
	
	public Card getBid(Card c){
		return startegy.getNextMove(c, hand){
	}
		
}
