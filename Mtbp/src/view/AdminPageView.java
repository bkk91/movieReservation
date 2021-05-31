package view;

import java.util.Scanner;

import util.ScannerUtil;

public class AdminPageView {
    
    private Scanner scanner;
    private MovieInfoView movieInfoView;
    private UserInfoView userInfoView;
    private ScreeningTimeView screeningTimeView;
    private AllInfoInputView allInfoInputView;
    
    public AdminPageView(){
        scanner = new Scanner(System.in);
        movieInfoView = new MovieInfoView();
        userInfoView = new UserInfoView();
        screeningTimeView = new ScreeningTimeView();
        allInfoInputView = new AllInfoInputView();
        
    }
    
    public void menu() {
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        System.out.println("      Admin Page        ");
        System.out.println();
        
        while(true) {
            String message;
            message = new String("1. Manage - Movie Information\n2. Manage - Reservation List\n3. Manage - User List\n4. Log out");
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 4);
            if(userChoice == 1) {
                movieInfoView.menu();
            }
            else if(userChoice == 2) {
                allInfoInputView.menu();
            }
            else if(userChoice == 3) {
                userInfoView.menu();
            }
            else if(userChoice == 4) {
                System.out.println();
                System.out.println("____________________");
                System.out.println("       Log Out      ");
                System.out.println();
                break;
            }
        }
    }

}
