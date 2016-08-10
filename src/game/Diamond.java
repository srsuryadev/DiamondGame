package game;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import player.Player;
import strategy.MediumComplexityStrategy;
import strategy.SimpleStrategy;
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
	private HashMap<String, Integer> hm;
	
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
		p1 = new Player(new SimpleStrategy(), PLAYER1);
		p2 = new Player(new MediumComplexityStrategy(), PLAYER2);
		hm = new HashMap<String, Integer>();
		hm.put(PLAYER1, 0);
		hm.put(PLAYER2, 0);
	}
	
	public void gameInit(){	
		p.generateCards();
		d.addPack(p);
		diamondStack = d.pickSuit(Suit.DIAMONDS);
		Collections.shuffle(diamondStack);
		p1.allotHand(new Hand(d.pickSuit(Suit.SPADES)));
		p2.allotHand(new Hand(d.pickSuit(Suit.CLUBS)));
	}
	
	public boolean removeBidOn(){
		return diamondStack.remove(0)!=null;
	}
	
	public boolean updateScore(Card bidCard, Card playerCard1, Card playerCard2){
		if(playerCard1.getFace().ordinal()>playerCard2.getFace().ordinal()){
			this.hm.put(PLAYER1, this.hm.get(PLAYER1)+bidCard.getFace().ordinal()+2);
		}
		else if(playerCard1.getFace().ordinal()<playerCard2.getFace().ordinal()){
			this.hm.put(PLAYER2, this.hm.get(PLAYER2)+bidCard.getFace().ordinal()+2);
		}
		else{
			this.hm.put(PLAYER1, this.hm.get(PLAYER1)+(bidCard.getFace().ordinal()+2)/2);
			this.hm.put(PLAYER2, this.hm.get(PLAYER2)+(bidCard.getFace().ordinal()+2)/2);
		}
		return true;
	}
	
	
	
	public void game(){
		while(!diamondStack.isEmpty()){
			Card bidOn = this.getBidOn();
			Card playerBid1 = p1.getBid(bidOn);
			Card playerBid2 = p2.getBid(bidOn);
			updateScore(bidOn, playerBid1, playerBid2);
			System.out.println("-------------------------------");
			System.out.println("BIDCARD :"+bidOn.getFace()+ " OF "+bidOn.getSuit());
			System.out.println("PLAYER 1 :"+playerBid1.getFace()+ " OF "+playerBid1.getSuit());
			System.out.println("PLAYER 2 :"+playerBid2.getFace()+ " OF "+playerBid2.getSuit());
			System.out.println("-------------------------------");
			System.out.println("PLAYER 1 SCORE: "+hm.get(PLAYER1)+ ":::"+"PLAYER 2 SCORE: "+hm.get(PLAYER2));
			removeBidOn();
		}
	}
	
	public static void debug(){
		
		Diamond d = new Diamond();
		d.gameInit();
		d.game();
	}
	
	
	public static void main(String[] args){
		
		debug();
	}

}
