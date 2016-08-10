package structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pack {
	public List<Card> cards;
	
	public Pack(){	
		cards = new ArrayList<Card>();
	}
	
	public Integer size(){
		return cards.size();
	}
	
	public List<Card> generateCards(){
		Face[] faces = Face.values();
		Suit[] suits = Suit.values();
		for(int i = 0; i<suits.length-1; i++){
			for(int j =0; j<faces.length-1; j++){
				cards.add(new Card(suits[i], faces[j]));
			}
		}
		return cards;
	}
	
	public void shuffle(){
		Collections.shuffle(this.cards);
	}
}
