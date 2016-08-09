package game;

import java.util.List;
import structures.Hand;

public abstract class Game {

	public List<Hand> players;
	
	public abstract int evaluate();
}
