package com.parkinglot;

import java.util.Random;


public class MainApplication {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ParkingLot lot = new ParkingLot();
		Random rand = new Random();
		Vehicle vehicle = null;
		while (vehicle == null || lot.parkVehicle(vehicle)) {
			lot.print();
			int low = 0;
			int high = 10;
			int randomNo = rand.nextInt(high-low) + low;;
			if (randomNo < 2) {
				vehicle = new Bus();
			} else if (randomNo < 4) {
				vehicle = new Motorcycle();
			} else {
				vehicle = new Car();
			}
			System.out.print("\nParking a ");
			vehicle.print();
			System.out.println("");
		}
		System.out.println("Parking Failed. Final state: ");
		lot.print();
	}
}
