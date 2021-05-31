package view;

import java.util.ArrayList;
import java.util.Scanner;
import util.ScannerUtil;
import model.FilterDTO;
import model.MovieInfoDTO;
import controller.MovieInfoController;
import controller.FilterController;

public class MovieInfoView {
    
    private Scanner scanner;
    private MovieInfoController movieInfoController;
    private FilterController filterController;
    private ArrayList<MovieInfoDTO> movieList;
    private int movieId;
    
    public MovieInfoView() {
        
        scanner = new Scanner(System.in);
        movieInfoController = new MovieInfoController();
        filterController = new FilterController();
        movieList = new ArrayList<>();
        
    }
    
    public void menu() {
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        String message;
        while(true) {
            message = new String("1. list\n2. create\n3. update\n4. delete\n5. back to Admin Page");
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 5);
            if(userChoice == 1) {
                list();
                select();
            }
            else if(userChoice == 2) {
                create();
            }
            else if(userChoice == 3) {
                update();
            }
            else if(userChoice == 4) {
                delete();
            }
            else if(userChoice == 5) {
                System.out.println();
                System.out.println("________________________");
                System.out.println();
                System.out.println("  back to previous page ");
                System.out.println();
                break;
            }
        }
    }
    
    public void list() {
        ArrayList<MovieInfoDTO> list = movieInfoController.printAll();
        
        movieList = movieInfoController.printAll();
        
        if(list.isEmpty()) {
            System.out.println();
            System.out.println("________________________");
            System.out.println();
            System.out.println("There is any information on the list");
            System.out.println();
            System.out.println("________________________");
            System.out.println();
        }
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        for(MovieInfoDTO m : movieList) {
            System.out.printf("Id: %d  Title: %s\n",m.getMovieId(),m.getMovieName());
        }
    }
    
    public void select() {
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        String message;
        message = new String("Choose movie, then put \"id\" number");
        movieId = ScannerUtil.nextInt(scanner, message);
        
        MovieInfoDTO m = movieInfoController.movieSelectOne(movieId);
        
        ArrayList<FilterDTO> filterList = filterController.printAll();
        FilterDTO f = new FilterDTO();
        f.setMovie(m.getMovieName());
        
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        System.out.println("     Selected Movie     ");
        System.out.println();
        System.out.printf("Title: %s\nRunning time: %s\nEvaluation: %sSummary: %s\n",
                m.getMovieName(), m.getRunningTime(), m.getMovieEvaluation(),m.getMovieSummary()); 
        System.out.println();
        System.out.println("________________________");
        System.out.println();
    }
    
     
    
    public void create() {
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        System.out.println("Create new movie-information-set");
        System.out.println();
        
        MovieInfoDTO m = new MovieInfoDTO();        
        String message;
        message = new String("Title: ");
        m.setMovieName(ScannerUtil.nextLine(scanner, message));
        
        message = new String("Running time: ");
        m.setRunningTime(ScannerUtil.nextLine(scanner, message));
        
        message = new String("Evaluation: ");
        m.setMovieEvaluation(ScannerUtil.nextLine(scanner, message));
        
        message = new String("Summary: ");
        m.setMovieSummary(ScannerUtil.nextLine(scanner, message));
        
        movieInfoController.movieAdd(m);  
        }    
    
    public void update() {
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        System.out.println("Update selected movie");
        System.out.println();
        
        list();
        select();        
        MovieInfoDTO m = movieInfoController.movieSelectOne(movieId);
        
        String message;
        message = new String("Title: ");
        m.setMovieName(ScannerUtil.nextLine(scanner, message));
        
        message = new String("Running time: ");
        m.setRunningTime(ScannerUtil.nextLine(scanner, message));
        
        message = new String("Evaluation: ");
        m.setMovieEvaluation(ScannerUtil.nextLine(scanner, message));
        
        message = new String("Summary: ");
        m.setMovieSummary(ScannerUtil.nextLine(scanner, message));
        
        movieInfoController.movieUpdate(m);  
        
    }
    
    public void delete() {
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        System.out.println("Delete selected movie");
        System.out.println();
        list();
        select();
        
        MovieInfoDTO m = movieInfoController.movieSelectOne(movieId);
   
        String message;        
        message = new String("Are you sure to delete selected one? (y/n)");
        String yesNo = ScannerUtil.nextLine(scanner, message);
        if(yesNo.equalsIgnoreCase("y")) {
            System.out.println("The Selected infomation is deleted");
            movieInfoController.movieDelete(m);
        }
        
    }
    
    

}
