package strategy;

import game.Game;
import player.Player;

public class Benchmark{
	
	static int numGames=5;
	static float totalScore = 0;
	 
	public static void computeBenchmark(int player1_score, int player2_score){
		totalScore += (float)(player2_score-player1_score)/numGames;
	}
	
	public static float returnBenchmark() {
		return totalScore;
	}
	
}