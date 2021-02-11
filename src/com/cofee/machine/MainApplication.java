package com.cofee.machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApplication {
	public static void main(String[] args) throws IOException {
		DrinkMachine machine = new DrinkMachine();
		machine.ingredientInventory.restock();

		System.out.println("Choose Menu: ");
		Drink[] drinks = machine.menu();
		int counter = 1;
		for (Drink drink : drinks) {
			System.out.println(counter + ".) " + drink.name()+ "  $"+ drink.getPrice());
			counter++;

		}

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String cmd = "";
		while (true) {

			cmd = reader.readLine().toLowerCase();

			if (cmd.isEmpty()) {
				continue;
			} else if ("q".equals(cmd)) {
				break;
			} else if ("r".equals(cmd)) {
				machine.ingredientInventory.restock();
			} else
				try {
					int selection = Integer.parseInt(cmd);
					Drink order = machine.menu()[selection - 1];
					machine.make(order);
					System.out.printf("Dispensing: %s\n", order);
				} catch (ArrayIndexOutOfBoundsException | NumberFormatException invalid) {
					System.out.printf("Invalid input: %s\n", invalid);
					continue;
				} catch (OutOfStockException outOfStock) {
					System.out.printf("Out of stock: %s\n", outOfStock.getMessage());
					continue;
				}
			System.out.printf("%s\n", machine);
		}
	}

	

}
