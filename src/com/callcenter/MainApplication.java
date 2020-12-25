package com.callcenter;

import java.util.Scanner;

public class MainApplication {
	static CallManager callManager = null;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isContinue = true;
		while (isContinue) {

			System.out.println("Enter no for your role >>>   1- customer   2-Admin ");
			int roleNo = sc.nextInt();
			if (roleNo == 1) {
				if (callManager == null) {
					System.out.println("Please enter first admin details");
				}
				System.out.println("Enter Customer details- name");
				String name = sc.next();
				Call call = new Call(0, new Customer(name));
				callManager.callHandler(call);

			} else if (roleNo == 2) {
				System.out.println("Enter no of respondents");
				int noOfRespondents = sc.nextInt();
				System.out.println("Enter no of managers");
				int noOfMangers = sc.nextInt();

				callManager = new CallManager(noOfRespondents, noOfMangers);
			}
			System.out.println(" ");
			System.out.println("do you want to exit >>>   1- yes   2- No ");
			int isExit = sc.nextInt();
			if (isExit == 1) {
				isContinue = false;
			}

		}
		sc.close();

	}

}
