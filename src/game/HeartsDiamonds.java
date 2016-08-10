package game;

import java.util.List;

import player.Player;
import structures.Card;
import structures.Deck;
import structures.Face;
import structures.Hand;
import structures.Pack;
import structures.Suit;

public class HeartsDiamonds extends Game{

	public HeartsDiamonds(){	
	}
	
	@Override
	public int evaluate(Player p) {
		// TODO Auto-generated method stub
		int answer = 0;
		List<Card> pointsCards = p.getPointsCards();
		for(Card c : pointsCards){
			if(c.getSuit() == Suit.HEARTS ){
				answer += 1;
			}
			else if(c.getSuit() == Suit.SPADES && c.getFace() == Face.QUEEN){
				answer += 13;
			}
		}
		return 0;
	}
	
	public static void debug(){
		Deck d = new Deck();
		Pack p1 = new Pack();
		Pack p2 = new Pack();
		p1.generateCards();
		p2.generateCards();
		d = new Deck();
		d.addPack(p1);
		d.addPack(p2);
		d.shuffle();
		System.out.println(p1.size());
		System.out.println(p2.size());
		System.out.println(d.size());
		List<Card> lst = d.deal(10);
		for(int i =0; i< lst.size(); i++){
			System.out.println(lst.get(i).getFace()+" of "+lst.get(i).getSuit());
		}
	}
	
	public static void main(String[] args){
		debug();
	}
}
