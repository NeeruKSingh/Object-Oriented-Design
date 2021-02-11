package com.vending.machine;

public enum Item {
	COKE(1, "Coke", 25), PEPSI(2, "Pepsi", 35), SODA(3, "Soda", 45);

	private int id;
	private String name;
	private int price;

	private Item(int id,String name, int price) {
		this.id=id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getPrice() {
		return price;
	}

	public static Item getItemById(int id) {
		for (Item item : Item.values()) {
            if(id==item.id) {
            	return item;
            }
		}
		return null;
	}
}
