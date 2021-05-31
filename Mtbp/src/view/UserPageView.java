package view;

import java.util.Scanner;
import util.ScannerUtil;

public class UserPageView {

    private Scanner scanner;
    private MovieListView movieListView;
    private TheaterView theaterView;
    private ScreeningTimeView screeningTimeView;
    private FilterView filterView;
    private ReservationView reservationView;

    public UserPageView() {
        scanner = new Scanner(System.in);
        movieListView = new MovieListView();
        theaterView = new TheaterView();
        screeningTimeView = new ScreeningTimeView();
        filterView = new FilterView();
        reservationView = new ReservationView();
    }

    public void menu() {
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        System.out.println("        User Page       ");
        System.out.println();

        while (true) {
            String message;
            message = new String("1. Movie List\n2. Theater Location\n3. Screening Time\n4. Log out");
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 4);
            if (userChoice == 1) {
                movieListView.menu();
                filterView.filterMovie();
                reservationView.showSeat();
            } else if (userChoice == 2) {
                theaterView.menu();
                filterView.filterTheater();
                reservationView.showSeat();
            } else if (userChoice == 3) {
                screeningTimeView.userMenu();
                filterView.filterTime();
                reservationView.showSeat();
            } else if (userChoice == 4) {
                System.out.println();
                System.out.println("____________________");
                System.out.println("       Log Out      ");
                System.out.println();
                break;
            }
        }
    }
}
