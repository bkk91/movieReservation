package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.AllController;
import controller.MovieTheaterController;
import controller.ScreenController;
import controller.ScreeningTimeController;
import controller.MovieInfoController;
import model.AllDTO;
import model.MovieInfoDTO;
import model.MovieTheaterDTO;
import model.ScreenDTO;
import model.ScreeningTimeDTO;
import view.ScreeningTimeView;
import util.ScannerUtil;

public class AllInfoInputView {

    private Scanner scanner;
    private ArrayList<ScreeningTimeDTO> timeList;
    private ArrayList<MovieInfoDTO> movieList;
    private ScreeningTimeController screeningTimeController;
    private AllController allController;
    private MovieInfoController movieInfoController;
    private MovieTheaterController movieTheaterController;
    private ScreenController screenController;
    private ScreeningTimeView screeningTimeView;
    private int theaterid;
    private int screenid;
    private int id;

    public AllInfoInputView() {

        scanner = new Scanner(System.in);

        allController = new AllController();
        movieTheaterController = new MovieTheaterController();
        movieInfoController = new MovieInfoController();
        screenController = new ScreenController();
        screeningTimeController = new ScreeningTimeController();
        screeningTimeView = new ScreeningTimeView();
        timeList = new ArrayList<>();
        movieList = new ArrayList<>();

    }

    public void menu() {
        theater();
        screen();
        time();
    }

    public void theater() {

        ArrayList<MovieTheaterDTO> theaterList = movieTheaterController.printAll();

        theaterList = movieTheaterController.printAll();

        System.out.println();
        System.out.println("________________________");
        System.out.println();

        for (MovieTheaterDTO t : theaterList) {
            System.out.printf("[%d] Location: %s\n", t.getTheaterId(), t.getLocation());
        }
        System.out.println();
        String message = new String("Choose Location, then put \"Id\" number");
        theaterid = ScannerUtil.nextInt(scanner, message);
        MovieTheaterDTO t = movieTheaterController.theaterSelectOne(theaterid);
        System.out.printf("[Location: %s]\n", t.getLocation());

    }

    public void screen() {
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        System.out.println("     Theater Location   ");
        System.out.println();
        ArrayList<ScreenDTO> screenList = screenController.printAll();

        screenList = screenController.printAll();

        for (ScreenDTO s : screenList) {
            System.out.printf("[%d] Location: %s\n", s.getScreenId(), s.getScreenNumber());
        }
        System.out.println();
        String message = new String("Choose Location, then put \"Id\" number");
        screenid = ScannerUtil.nextInt(scanner, message);
        ScreenDTO s = screenController.screenSelectOne(screenid);
        System.out.printf("[Location: %s]\n", s.getScreenNumber());

    }

    public void time() {
        System.out.println();
        while (true) {
            System.out.println();
            System.out.println("________________________");
            System.out.println();
            String message;
            message = new String("1. Screening Time List\n2. Input Screening Time\n3. back");
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if (userChoice == 1) {
                ArrayList<ScreeningTimeDTO> timelist = screeningTimeController.printAll();

                timeList = screeningTimeController.printAll();
                System.out.println();

                for (ScreeningTimeDTO st : timeList) {
                    screeningTimeView.compare();
                    System.out.printf("[%d] Time: %02d-%02d %02d:%02d\n", st.getTimeid(), st.getMonth(), st.getDay(),
                            st.getHour(), st.getMinute());
                }
                System.out.println();
                System.out.println("________________________");
                System.out.println();
                message = new String("Choose Time, then put \"Id\" number");
                id = ScannerUtil.nextInt(scanner, message);

                ScreeningTimeDTO st = screeningTimeController.selectOne(id);
                System.out.printf("Time: %02d-%02d %02d:%02d\n", st.getMonth(), st.getDay(), st.getHour(),
                        st.getMinute());
                System.out.println();
                ArrayList<MovieInfoDTO> list = movieInfoController.printAll();
                movieList = movieInfoController.printAll();

                for (MovieInfoDTO m : movieList) {
                    System.out.printf("[%d] Title: %s\n", m.getMovieId(), m.getMovieName());
                }
                System.out.println();
                message = new String("If you want register movie on selected Time\nChoose movie, then put \"number\"");
                id = ScannerUtil.nextInt(scanner, message);

                System.out.println();
                MovieTheaterDTO t = movieTheaterController.theaterSelectOne(theaterid);
                
                System.out.printf("[Location: %s]\n", t.getLocation());
                ScreenDTO s = screenController.screenSelectOne(screenid);
                
                System.out.printf("[ScreenNumber: %s]\n", s.getScreenNumber());
                System.out.printf("[Time: %02d-%02d %02d:%02d]\n", st.getMonth(), st.getDay(), st.getHour(),
                        st.getMinute());
                
                MovieInfoDTO m = movieInfoController.movieSelectOne(id);
                System.out.printf("[ID: %d Title: %s]", m.getMovieId(), m.getMovieName());

                ArrayList<AllDTO> allList = allController.printAll();
                AllDTO a = new AllDTO();
                a.setTheater(t.getLocation());
                a.setScreen(s.getScreenNumber());
                a.setMonth(st.getMonth());
                a.setDay(st.getDay());
                a.setHour(st.getHour());
                a.setMinute(st.getMinute());
                allList.add(a);
              

            } else if (userChoice == 2) {

                System.out.println();
                System.out.println("________________________");
                System.out.println();
                System.out.println("      Screening Time    ");
                System.out.println();
                System.out.println(" ex) format: 03-20 12:00");

                ScreeningTimeDTO st = new ScreeningTimeDTO();

                message = new String("Input Month");
                st.setMonth(ScannerUtil.nextInt(scanner, message, 1, 12));

                message = new String("Input day");
                st.setDay(ScannerUtil.nextInt(scanner, message, 1, 31));

                message = new String("Input Hour");
                st.setHour(ScannerUtil.nextInt(scanner, message, 0, 24));

                message = new String("Input Minute");
                st.setMinute(ScannerUtil.nextInt(scanner, message, 0, 60));

                screeningTimeController.add(st);

            } else if (userChoice == 3) {
                System.out.println();
                System.out.println("_____________________");
                System.out.println("back to previous page");
                System.out.println();  
                break;
            }
        }
    }


}
