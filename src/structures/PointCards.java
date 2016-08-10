package structures;

import java.util.ArrayList;
import java.util.List;

public class PointCards {
	public List<Card> cards;
	public PointCards(){
		cards = new ArrayList<Card>();
	}
	
	public Integer size(){
		return cards.size();
	}
	
	public boolean add(List<Card> lst){
		return true;
	}
}
