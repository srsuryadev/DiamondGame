package structures;

import java.util.ArrayList;
import java.util.List;

public class JokerPack extends Pack{

	public List<Card> generateCards(Integer numJoker){
		List<Card> lst = super.generateCards();
		while(numJoker!=0){
			lst.add(new Card(Suit.valueOf("JOKER"), Face.valueOf("JOKER")));
			numJoker--;
		}
		return lst;
	}	
	
	
	
}
