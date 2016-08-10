package game;

import java.util.List;

import player.Player;
import structures.Hand;

public abstract class Game {

	public List<Player> players;
	
	public abstract int evaluate(Player p);
}
