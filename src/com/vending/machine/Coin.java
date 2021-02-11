package com.vending.machine;

public enum Coin {
	PENNY(1, 1), NICKLE(2, 5), DIME(3, 10), QUARTER(4, 25),NONE(5,0);

	private int id;
	private int denomination;

	private Coin(int id, int denomination) {
		this.id = id;
		this.denomination = denomination;
	}

	public int getId() {
		return id;
	}


	public int getDenomination() {
		return denomination;
	}

	public static Coin getCoinById(int id) {
		for (Coin coin : Coin.values()) {
			if (id == coin.id) {
				return coin;
			}
		}
		return null;
	}
}
