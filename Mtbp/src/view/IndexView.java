package view;

import java.util.Scanner;
import util.ScannerUtil;

public class IndexView {
    
    private Scanner scanner;
    private UserView userView;
    private UserPageView userPageView;
    private AdminPageView adminPageView;
    
    public IndexView() {
        scanner = new Scanner(System.in);
        userView = new UserView();
        userPageView = new UserPageView();
        adminPageView = new AdminPageView();
    }
    
    public void showIndex() {
        System.out.println(" ___________________________");
        System.out.println("|                           |");
        System.out.println("|  BK Cinema Reservation    |");
        System.out.println("|___________________________|");
        System.out.println();
        
        while(true) {
            String message;
            message = new String("1. Register\n2. LogIn\n3. Quit");
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if(userChoice == 1) {
                userView.userRegister();
            }
            else if(userChoice == 2) {                
                int gradeType = userView.userLogIn();
                if(gradeType == 1) {
                    userPageView.menu();
                }else if(gradeType == 0) {
                    adminPageView.menu();
                }
            }
            else if(userChoice == 3) {
                System.out.println();
                System.out.println("*****************************************************");
                System.out.println("*                                                   *");
                System.out.println("* Thank you for using BK Cinema Reservation Program *");
                System.out.println("*                                                   *");
                System.out.println("*****************************************************");
                System.out.println();
                break;
            }
        }        
    }
}
