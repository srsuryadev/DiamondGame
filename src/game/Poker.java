package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import player.Player;
import structures.Card;
import structures.Deck;
import structures.Face;
import structures.Hand;
import structures.Pack;
import structures.Suit;

public class Poker extends Game {

	
	public HashMap<Suit, List<Face> > hmSuitFace;
	public HashMap<Face, List<Suit> > hmFaceSuit;
	
	public Poker(){
		hmSuitFace = new HashMap<Suit, List<Face> >();
		hmFaceSuit = new HashMap<Face, List<Suit> >();
	}
	
	
	public Integer classify(List<Card> lst){
		this.populateHashFS(lst);
		this.populateHashSF(lst);
		System.out.println(hmSuitFace.size()+" "+hmFaceSuit.size());

		if(this.isFourOfKind(lst)){
			System.out.println("FOUR OF KIND");
			return 0;
		}
		else if (this.isPair(lst)){
			System.out.println("PAIR");
			return 1;
		}
		else if (this.isTwoPair(lst)){
			System.out.println("TWO PAIR");
			return 2;
		}
		else if (this.isRoyalFlush(lst)){
			System.out.println("ROYAL FLUSH");
		}
		else if(this.isThreeOfKind(lst)){
			System.out.println("THREE OF KIND");
		}
		
		return 0;
	}
	
	
	public boolean populateHashSF(List<Card> cards){
		for(Card c: cards){
			List<Face> f = new ArrayList<Face>();
			if(hmSuitFace.containsKey(c.getSuit())){
				f = hmSuitFace.get(c.getSuit());
			}
			f.add(c.getFace());
			hmSuitFace.put(c.getSuit(), f);
		}
		return true;
	}
	
	public boolean populateHashFS(List<Card> cards){
		for(Card c: cards){
			List<Suit> s = new ArrayList<Suit>();
			if(hmFaceSuit.containsKey(c.getFace())){
				s = hmFaceSuit.get(c.getFace());
			}
			s.add(c.getSuit());
			hmFaceSuit.put(c.getFace(), s);
		}
		return true;
	}
	
	public boolean isRoyalFlush(List<Card> cards){
		Suit s = cards.get(0).getSuit();
		int prev = Face.NINE.ordinal();
		int num =0;
		for(int i = 0; i< cards.size(); i++){
			Card card = cards.get(i);
			if((s != card.getSuit()|| card.getFace().ordinal()!=prev+1)){
				return false;
			}
			prev = card.getFace().ordinal();
		}
		return true;
	}
	
	public boolean isStraightFlush(List<Card> cards){
		Suit s = cards.get(0).getSuit();
		int prev = Face.FOUR.ordinal();
		int num =0;
		for(int i = 0; i< cards.size(); i++){
			Card card = cards.get(i);
			if((s != card.getSuit()|| card.getFace().ordinal()!=prev+1)){
				return false;
			}
			prev = card.getFace().ordinal();
		}
		return true;
	}
	
	public boolean isStraight(List<Card> cards){
		int prev = Face.NINE.ordinal();
		int num =0;
		for(int i = 0; i< cards.size(); i++){
			Card card = cards.get(i);
			if(card.getFace().ordinal()!=prev+1){
				return false;
			}
			prev = card.getFace().ordinal();
		}
		return true;
	}
	
	public boolean isFourOfKind(List<Card> c){
		for (Map.Entry<Face, List<Suit> > entry : hmFaceSuit.entrySet()) {
			if(entry.getValue().size() == 4){
				return true;
			}
		}
		return false;
	}
	
	public boolean isTwoOfKind(List<Card> c){
		for (Map.Entry<Face, List<Suit> > entry : hmFaceSuit.entrySet()) {
			if(entry.getValue().size() == 2){
				return true;
			}
		}
		return false;
	}
	
	
	public boolean isPair(List<Card> c){
		for (Map.Entry<Suit, List<Face> > entry : hmSuitFace.entrySet()) {
			if(entry.getValue().size() == 2){
				return true;
			}
		}
		return false;
	}
	
	public boolean isTwoPair(List<Card> c){
		int count = 0;
		for (Map.Entry<Suit, List<Face> > entry : hmSuitFace.entrySet()) {
			if(entry.getValue().size() == 2){
				count++;
			}
		}
		if(count == 2){ 
			return true;
		}
		return false;
	}
	
	public boolean isThreeOfKind(List<Card> c){
		for (Map.Entry<Face, List<Suit> > entry : hmFaceSuit.entrySet()) {
			if(entry.getValue().size() == 3){
				return true;
			}
		}
		return false;
	}
	
	public boolean isFullHouse(List<Card> c){
		if(isTwoOfKind(c)&&isThreeOfKind(c)){
			return true;
		}
		return false;
	}
	
	public boolean  isFlush(List<Card> c){
		for (Map.Entry<Suit, List<Face> > entry : hmSuitFace.entrySet()) {
			if(entry.getValue().size() == 5){
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public int evaluate(Player p) {
		// TODO Auto-generated method stub
		// 
		
		
		
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
		List<Card> lst = d.pick(5);
		Hand h = new Hand();
		for(int i =0; i< lst.size(); i++){
			h.addCard(lst.get(i));
			System.out.println(lst.get(i).getFace()+" of "+lst.get(i).getSuit());
		}
		System.out.println("SORTED ARRAY:::");
		h.sortByFace();
		lst = h.cardsInHand();
		for(int i =0;i<lst.size();i++){
			System.out.println(lst.get(i).getFace()+" of "+lst.get(i).getSuit());
		}
		/*Poker p = new Poker();
		
		System.out.println(p.classify(lst));
		System.out.println(p.hmFaceSuit.toString());
		System.out.println(p.hmSuitFace.toString());
		*/
	}
	
	public static void main(String[] args){
		debug();
	}

}