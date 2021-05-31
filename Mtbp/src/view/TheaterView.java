package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.FilterController;
import controller.MovieTheaterController;
import model.FilterDTO;
import model.MovieTheaterDTO;
import util.ScannerUtil;

public class TheaterView {

    private Scanner scanner;
    private MovieTheaterController movieTheaterController;
    private FilterController filterController;
    private int theaterId;

    public TheaterView() {

        scanner = new Scanner(System.in);
        movieTheaterController = new MovieTheaterController();
        filterController = new FilterController();

    }

    public void menu() {
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        System.out.println("     Theater Location   ");

        list();
        select();
        
    }
    
    public void admin() {
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
        theaterId = ScannerUtil.nextInt(scanner, message);
        
        
        
    }

    public void list() {
        ArrayList<MovieTheaterDTO> theaterList = movieTheaterController.printAll();

        theaterList = movieTheaterController.printAll();

        System.out.println();
        System.out.println("________________________");
        System.out.println();

        for (MovieTheaterDTO t : theaterList) {
            System.out.printf("Id: %d Location: %s\n", t.getTheaterId(), t.getLocation());
        }
        System.out.println();
    }

    public void select() {
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        String message;
        message = new String("Choose Location, then put \"Id\" number");
        theaterId = ScannerUtil.nextInt(scanner, message);
        
        MovieTheaterDTO t = movieTheaterController.theaterSelectOne(theaterId);
        
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        System.out.println("     Selected Theater    ");
        System.out.println();
        System.out.printf("Location: %s",t.getLocation());
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        
        ArrayList<FilterDTO> filterList = filterController.printAll();
        FilterDTO f = new FilterDTO();
        f.setTheater(t.getLocation());
    }
}





