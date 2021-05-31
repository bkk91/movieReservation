package view;

import java.util.ArrayList;
import java.util.Scanner;
import util.ScannerUtil;
import model.ReservationDTO;
import controller.ReservationController;

public class ReservationView {

	private Scanner scanner;
	private ReservationController reservationController;
	private PaymentView paymentView;
	private int row;
	private int column;
	private int reservationId;

	ReservationView() {
		scanner = new Scanner(System.in);
		reservationController = new ReservationController();
		paymentView = new PaymentView();
	}

	public ArrayList<String> prepareSeat(int height, int width) {
		ArrayList<String> seat = new ArrayList<>();

		for (int i = 0; i < height; i++) {
			String row = new String();
			System.out.println();
			for (int j = 0; j < width; j++) {
				row += "O";
			}
			seat.add(row);
		}
		return seat;
	}

	public void seatStatus() {

		row = 6;
		column = 6;
		ArrayList<String> seat = prepareSeat(row, column);
		for (ReservationDTO r : reservationController.selectList()) {
			int xPosition = r.getColumn() - 1;
			int yPosition = r.getRow() - 1;

			char[] seatChars = seat.get(yPosition).toCharArray();
			seatChars[xPosition] = 'X';
			seat.set(yPosition, String.copyValueOf(seatChars));
		}
		currentSeat(seat);
		reservationId++;
	}

	// 현재좌석을 "O"으로 보여주는 currentSeat 메소드

	public void currentSeat(ArrayList<String> seat) {
		System.out.println();
		System.out.println("Current Seat");
		System.out.println(" > O is empty");
		for (String s : seat) {
			System.out.println(s);
		}
	}

	// 선택할 좌석을 selectSeat() 메소드
	public void selectSeat() {
		ReservationDTO r = new ReservationDTO();
		String message;
		System.out.println();
        System.out.println("________________________");
        System.out.println();
		message = new String("Enter row number of seat(1~6)");
		r.setRow(ScannerUtil.nextInt(scanner, message, 1, 6));

		message = new String("Enter column number of seat (1~6)");
		r.setColumn(ScannerUtil.nextInt(scanner, message, 1, 6));

		while (reservationController.validateSeat(r)) {
			System.out.println("This seat is already booked");

			message = new String("Enter row number of seat(1~6)");
			r.setRow(ScannerUtil.nextInt(scanner, message, 1, 6));

			message = new String("Enter column number of seat (1~6)");
			r.setColumn(ScannerUtil.nextInt(scanner, message, 1, 6));
		}

		reservationController.reservationAdd(r);

	}

	public void showSeat() {
		seatStatus();
		selectSeat();
		seatStatus();
		reservation();
		print();
	}

	public void reservation() {
		String message;
		System.out.println();
        System.out.println("________________________");
        System.out.println();
		message = new String("Are you sure? y/n");
		String yesNo = ScannerUtil.nextLine(scanner, message);
		if (yesNo.equalsIgnoreCase("y")) {
			paymentView.pay();
		} else {
			System.out.println();
			System.out.println("Your reservation is canceled.\nBack to previous page");
			System.out.println();
		}
	}
	
	public void print() {
		ReservationDTO r = reservationController.reservationSelectOne(reservationId);
		System.out.println();
        System.out.println("________________________");
        System.out.println();
		System.out.printf("[ReservationId: %d]\n",reservationId);
		System.out.println("[You can check it in your userInformation option]");
		System.out.println();
        System.out.println("________________________");
        System.out.println();
	}

}