package game;

import java.util.Collections;
import java.util.List;

import player.Player;
import structures.Card;
import structures.Deck;
import structures.Hand;
import structures.Pack;
import structures.Suit;

public class Diamond extends Game {

	
	private Deck d;
	private Pack p;
	private Player p1, p2;
	public final static String PLAYER1 = "COMPUTER";
	public final static String PLAYER2 = "HUMAN";
	private List<Card> diamondStack;
	
	@Override
	public int evaluate(Player p) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Card getBidOn(){
		return diamondStack.get(0);
	}
	
	public Diamond(){
		p = new Pack();
		d = new Deck();
		p1 = new Player(new Strategy(). PLAYER1);
		p2 = new Player(new Strategy(), PLAYER2);
	}
	
	public void gameInit(){	
		p.generateCards();
		d.addPack(p);
		diamondStack = d.pickSuit(Suit.DIAMONDS);
		Collections.shuffle(diamondStack);
		p1.allotHand(new Hand(d.pickSuit(Suit.SPADES)));
		p1.allotHand(new Hand(d.pickSuit(Suit.CLUBS)));
		
	}
	
	public boolean removeBidOn(){
		return diamondStack.remove(0)!=null;
	}
	
	public boolean updateScore(Card bidCard, Card playerCard1, Card playerCard2){
		
		return true;
	}
	
	public void game(){
		while(!diamondStack.isEmpty()){
			Card bidOn = this.getBidOn();
			Card playerBid1 = p1.getBid(bidOn);
			Card playerBid2 = p2.getBid(bidOn);
			updateScore(bidOn, playerBid1, playerBid2);
			removeBidOn();
		}
	}
	
	public void debug(){
		
	
	}
	
	
	public static void main(String[] args){
		
	}

}
