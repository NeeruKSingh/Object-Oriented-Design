package com.snake.ladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeAndLadderBoard {
	private int size;
	private List<Snake> snakes; // The board also contains some snakes and ladders.
	private List<Ladder> ladders;
	private Map<Player, Integer> playerPieces;

	public SnakeAndLadderBoard(int size) {
		this.size = size;
		this.snakes = new ArrayList<Snake>();
		this.ladders = new ArrayList<Ladder>();
		this.playerPieces = new HashMap<Player, Integer>();
	}

	public int getSize() {
		return size;
	}

	public List<Snake> getSnakes() {
		return snakes;
	}

	public void setSnakes(List<Snake> snakes) {
		this.snakes = snakes;
	}

	public List<Ladder> getLadders() {
		return ladders;
	}

	public void setLadders(List<Ladder> ladders) {
		this.ladders = ladders;
	}

	public Map<Player, Integer> getPlayerPieces() {
		return playerPieces;
	}

	public void setPlayerPieces(Map<Player, Integer> playerPieces) {
		this.playerPieces = playerPieces;
	}

}
