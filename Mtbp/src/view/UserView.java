package view;

import java.util.Scanner;
import util.ScannerUtil;

import model.UserDTO;
import controller.UserController;

public class UserView {

    private Scanner scanner;
    private UserController userController;
    private UserDTO logIn;

    public UserView() {
        scanner = new Scanner(System.in);
        userController = new UserController();
    }

    public void userRegister() {
        System.out.println();
        System.out.println("Set up your personal information, below");
        System.out.println();

        UserDTO u = new UserDTO();
        String message;

        message = new String("Id: ");
        u.setUserName(ScannerUtil.nextLine(scanner, message));
        while (userController.validateUsername(u)) {
            System.out.println("Warning!");
            System.out.println("This Id name is already registered");
            message = new String("ID: ");
            u.setUserName(ScannerUtil.nextLine(scanner, message));
        }

        message = new String("Password: ");
        u.setUserPassword(ScannerUtil.nextLine(scanner, message));

        message = new String("NickName: ");
        u.setUserNickname(ScannerUtil.nextLine(scanner, message));

        message = new String("Address: ");
        u.setUserAddress(ScannerUtil.nextLine(scanner, message));

        message = new String("PhoneNumber: ");
        u.setUserPhonenumber(ScannerUtil.nextLine(scanner, message));

        userController.add(u);
    }

    public int userLogIn() {

        UserDTO usertemp = new UserDTO();
        System.out.println();
        System.out.println("________________________");
        System.out.println();

        String message = new String("1. ID/PW\n2. Back to main menu");
        int userChoice = ScannerUtil.nextInt(scanner, message);

        if (userChoice == 1) {
            message = new String("ID: ");
            usertemp.setUserName(ScannerUtil.nextLine(scanner, message));

            message = new String("Password: ");
            usertemp.setUserPassword(ScannerUtil.nextLine(scanner, message));

            UserDTO result = userController.auth(usertemp);

            while (result == null) {
                System.out.println("Warning!");
                System.out.println("Wrong information");
                message = new String("Try Again? y/n");

                String agree = ScannerUtil.nextLine(scanner, message);
                if (agree.equalsIgnoreCase("n")) {
                    return -1;
                }

                message = new String("ID: ");
                usertemp.setUserName(ScannerUtil.nextLine(scanner, message));

                message = new String("Password: ");
                usertemp.setUserPassword(ScannerUtil.nextLine(scanner, message));

                result = userController.auth(usertemp);
            }
            logIn = result;
            return result.getGrade();
        } else if (userChoice == 2) {
            System.out.println();
            System.out.println("________________________");
            System.out.println();
            System.out.println("back to main menu");
            System.out.println();

        }
        return userChoice;

    }

}
