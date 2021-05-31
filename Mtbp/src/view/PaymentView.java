package view;

import java.util.Scanner;
import util.ScannerUtil;

public class PaymentView {

	private Scanner scanner;

	public PaymentView() {
		scanner = new Scanner(System.in);
	}

	public void pay() {
		String message;
		System.out.println();
		System.out.println("_______________________________________________________");
        System.out.println();
		message = new String("The price is $9.5. (taxes not included, tax is $0.57)");
		System.out.println(message);
		message = new String("Do you want to purchase the ticket? (y/n)");
		System.out.println();
		String yesNo = ScannerUtil.nextLine(scanner, message);
		if (yesNo.equalsIgnoreCase("y")) {
			System.out.println();
			System.out.println("________________________________________________");
	        System.out.println();
			System.out.println("The payment is completed");
			System.out.println();
		} else {
			System.out.println();
	        System.out.println("________________________________________________");
	        System.out.println();
			System.out.println("The payment is canceled\n Back to previous page");
			System.out.println();
		}
	}
	

}
