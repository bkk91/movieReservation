package view;

import java.util.Scanner;

public class MovieListView {

    private Scanner scanner;
    private MovieInfoView movieInfoView;
    
    public MovieListView(){
        
        scanner = new Scanner(System.in);
        movieInfoView = new MovieInfoView();
        
    }
    
    public void menu() {
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        System.out.println("       Movie List       ");
        movieInfoView.list();
        movieInfoView.select();
        // reservationView.reserve(); 예약하는 기능
    }
    
    
    
}
