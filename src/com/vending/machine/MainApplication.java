package com.vending.machine;

import java.util.List;
import java.util.Scanner;

public class MainApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		VendingMachine machine = new VendingMachineImpl();
		System.out.println("hey welcome!!  ");

		System.out.println("Select a item from list");

		for (Item item : Item.values()) {
			System.out.println(item.getId() + " =" + item);

		}
		int selection = sc.nextInt();
		Item item = Item.getItemById(selection);
		long price = machine.selectItemAndGetPrice(item);
		System.out.println("Price of " + item.getName() + " :" + price);
		System.out.println("Insert coins:  ");
		for (Coin coin : Coin.values()) {
			System.out.println(coin.getId() + " =" + coin.getDenomination());
		}
		int optionCoin = 0;
		while (true) {
			System.out.println("Select a coin :  ");
			optionCoin = sc.nextInt();
			if (optionCoin == 5) {
				break;
			}
			Coin coin = Coin.getCoinById(optionCoin);
			machine.insertCoin(coin);
			System.out.println("Now You paid total:  " + machine.getTotalPaid());
			System.out.println((price > machine.getTotalPaid()) ? (" amount left : " + (price - machine.getTotalPaid()))
					: "you paid more : " + (machine.getTotalPaid() - price));

		}
		Bucket<Item, List<Coin>> bucket = machine.collectItemAndChange();
		System.out.println(
				"congratulations !! you bought:  " + bucket.getFirst() + " returned coins:  " + bucket.getSecond());
		System.out.println("If you want refund, please enter 1");
		int refundInt = sc.nextInt();
		if (refundInt == 1) {
			List<Coin> coins = machine.refund();
			System.out.println("Refund successfull: " + coins);
		}
		sc.close();
		machine.printStats();
		machine.reset();

	}
}
