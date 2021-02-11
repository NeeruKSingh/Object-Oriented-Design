package com.snake.ladder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SnakeAndLadderServiceManager {
	private SnakeAndLadderBoard snakeAndLadderBoard;
	private int initialNumberOfPlayers;
	private Queue<Player> players;
	private boolean shouldGameContinueTillLastPlayer;
	private static final int DEFAULT_BOARD_SIZE = 100;

	public SnakeAndLadderServiceManager(int boardSize) {
		this.snakeAndLadderBoard = new SnakeAndLadderBoard(boardSize);
		this.players = new LinkedList<Player>();
	}

	public SnakeAndLadderServiceManager() {
		this(SnakeAndLadderServiceManager.DEFAULT_BOARD_SIZE);
	}

	public void setShouldGameContinueTillLastPlayer(boolean shouldGameContinueTillLastPlayer) {
		this.shouldGameContinueTillLastPlayer = shouldGameContinueTillLastPlayer;
	}

	/**
	 * ==================Initialize board==================
	 */

	public void setPlayers(List<Player> players) {
		this.players = new LinkedList<Player>();
		this.initialNumberOfPlayers = players.size();
		Map<Player, Integer> playerPieces = new HashMap<Player, Integer>();
		for (Player player : players) {
			this.players.add(player);
			playerPieces.put(player, 0);
		}
		snakeAndLadderBoard.setPlayerPieces(playerPieces);
	}

	public void setSnakes(List<Snake> snakes) {
		snakeAndLadderBoard.setSnakes(snakes);
	}

	public void setLadders(List<Ladder> ladders) {
		snakeAndLadderBoard.setLadders(ladders);
	}

	private int getNewPosition(int newPosition) {
		int previousPosition;

		do {
			previousPosition = newPosition;
			for (Snake snake : snakeAndLadderBoard.getSnakes()) {
				if (snake.getStart() == newPosition) {
					newPosition = snake.getEnd(); // Whenever a piece ends up at a position with the head of the snake,
													// the piece should go down to the position of the tail of that
													// snake.
				}
			}

			for (Ladder ladder : snakeAndLadderBoard.getLadders()) {
				if (ladder.getStart() == newPosition) {
					newPosition = ladder.getEnd(); // Whenever a piece ends up at a position with the start of the
													// ladder, the piece should go up to the position of the end of that
													// ladder.
				}
			}
		} while (newPosition != previousPosition); // There could be another snake/ladder at the tail of the snake or
													// the end position of the ladder and the piece should go up/down
													// accordingly.
		return newPosition;
	}

	private void movePlayer(Player player, int positions) {
		int oldPosition = snakeAndLadderBoard.getPlayerPieces().get(player);
		int newPosition = oldPosition + positions;

		int boardSize = snakeAndLadderBoard.getSize();

		if (newPosition > boardSize) {
			newPosition = boardSize; // This player wins the game
		} else {
			newPosition = getNewPosition(newPosition);
		}

		snakeAndLadderBoard.getPlayerPieces().put(player, newPosition);

		System.out.println(
				player.getName() + " rolled a " + positions + " and moved from " + oldPosition + " to " + newPosition);
	}

	private boolean hasPlayerWon(Player player) {

		int playerPosition = snakeAndLadderBoard.getPlayerPieces().get(player);
		int winningPosition = snakeAndLadderBoard.getSize();
		return playerPosition == winningPosition;
	}

	private boolean isGameCompleted() {
		if (shouldGameContinueTillLastPlayer) {
			return players.size() < 2;
		}
		int currentNumberOfPlayers = players.size();
		return currentNumberOfPlayers < initialNumberOfPlayers;
	}

	public void startGame() {
		while (!isGameCompleted()) {
			int diceRollNum = Dice.roll();
			Player currentPlayer = players.poll();
			movePlayer(currentPlayer, diceRollNum);
			if (hasPlayerWon(currentPlayer)) {
				System.out.println(currentPlayer.getName() + " wins the game");
				snakeAndLadderBoard.getPlayerPieces().remove(currentPlayer);
			} else {
				players.add(currentPlayer);
			}
		}
		throw new GameAlreadyEndException("Game Already ended");
	}

	/**
	 * =======================================================
	 */
}
