package structures;

import java.util.Comparator;

/**
 * 
 * @author ashish
 *
 */
public class Card {
	private Suit suit;
	private Face face;
	
	/**
	 * Constructor for Card class.
	 * @param suit Suit of the card.
	 * @param face Face value of the card.
	 */
	public Card(Suit suit, Face face) {
		this.suit = suit;
		this.face = face;
	}
	
	/**
	 * Get suit of the card.
	 * @return suit of the card
	 */
	public final Suit getSuit() {
		return this.suit;
	}
	
	/**
	 * Get face value of the card.
	 * @return face value of the card
	 */
	public final Face getFace() {
		return this.face;
	}
	
	public boolean equals(Card other) {
		return (this.suit == other.suit) 
				&& (this.face == other.face); 
	}
}
class CardComparator implements Comparator<Card>
{

    @Override
    public int compare(Card o1, Card o2) 
    {
         if (o1.getSuit().ordinal() == o2.getSuit().ordinal() && o1.getFace().ordinal() == o2.getFace().ordinal()) 
         {
             return 0;
         }
         else if (o1.getSuit().ordinal() ==o2.getSuit().ordinal()) 
         {
             if (o1.getFace().ordinal() > o2.getFace().ordinal())
                 return 1;                 
             else                  
                 return -1;                
         }
         else
             return -1;    
    }

}
