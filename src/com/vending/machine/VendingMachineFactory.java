package com.vending.machine;

public class VendingMachineFactory {
	 public static VendingMachine createVendingMachine() {
	        return new VendingMachineImpl();
	    }
}
