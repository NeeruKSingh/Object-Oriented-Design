package com.snake.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApplicaion {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ënter no of snakes");
		int noOfSnakes = scanner.nextInt();
		List<Snake> snakes = new ArrayList<Snake>();
		for (int i = 0; i < noOfSnakes; i++) {
			snakes.add(new Snake(scanner.nextInt(), scanner.nextInt()));
		}

		System.out.println("Ënter no of ladders");
		int noOfLadders = scanner.nextInt();
		List<Ladder> ladders = new ArrayList<Ladder>();
		for (int i = 0; i < noOfLadders; i++) {
			ladders.add(new Ladder(scanner.nextInt(), scanner.nextInt()));
		}

		System.out.println("Ënter no of players");
		int noOfPlayers = scanner.nextInt();
		List<Player> players = new ArrayList<Player>();
		for (int i = 0; i < noOfPlayers; i++) {
			players.add(new Player(scanner.next()));
		}

		SnakeAndLadderServiceManager snakeAndLadderService = new SnakeAndLadderServiceManager();
		snakeAndLadderService.setPlayers(players);
		snakeAndLadderService.setSnakes(snakes);
		snakeAndLadderService.setLadders(ladders);
		snakeAndLadderService.setShouldGameContinueTillLastPlayer(true);
		snakeAndLadderService.startGame();
		scanner.close();
	}

}
