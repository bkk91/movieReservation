package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.UserController;
import model.UserDTO;
import util.ScannerUtil;

public class UserInfoView {

    private Scanner scanner;
    private ArrayList<UserDTO> userList;
    private int userId;
    private UserController userController;

    public UserInfoView() {

        scanner = new Scanner(System.in);
        userController = new UserController();
        userList = new ArrayList<>();

    }

    public void menu() {
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        String message;
        while (true) {
            message = new String("1. list\n2. update\n3. delete\n4. back to Admin Page");
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 4);
            if (userChoice == 1) {
                list();
            } else if (userChoice == 2) {
                update();
            } else if (userChoice == 3) {
                delete();
            } else if (userChoice == 4) {
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
        ArrayList<UserDTO> userList = userController.printAll();
        userList = userController.printAll();

        if (userList.isEmpty()) {
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
        for (UserDTO u : userList) {
            System.out.printf("Id: %d UserName: %s\n", u.getUserId(),u.getUserName());
        }
    }

    public void select() {
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        String message;
        message = new String("Choose User, then put \"id\" number");
        userId = ScannerUtil.nextInt(scanner, message);

        UserDTO u = userController.selectOne(userId);

        System.out.println();
        System.out.println("________________________");
        System.out.println();
        System.out.println("     Selected User     ");
        System.out.println();
        System.out.printf("Username: %s\nPassword: %s\nUserNickname: %s\nUserAddress: %s\nUserPhoneNumber: ",
                u.getUserName(), u.getUserPassword(), u.getUserNickname(), u.getUserAddress(), u.getUserPhonenumber());
        System.out.println();
        System.out.println("________________________");
        System.out.println();

    }

    public void update() {
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        System.out.println("Update user information");
        System.out.println();

        list();
        select();
        UserDTO u = userController.selectOne(userId);

        String message;
        message = new String("Password: ");
        u.setUserPassword(ScannerUtil.nextLine(scanner, message));

        message = new String("Nickname: ");
        u.setUserNickname(ScannerUtil.nextLine(scanner, message));

        message = new String("Address: ");
        u.setUserAddress(ScannerUtil.nextLine(scanner, message));

        message = new String("PhoneNumber: ");
        u.setUserPhonenumber(ScannerUtil.nextLine(scanner, message));

        userController.update(u);

    }

    public void delete() {
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        System.out.println("Delete user information");
        System.out.println();

        list();
        select();
        UserDTO u = userController.selectOne(userId);

        String message;
        message = new String("Are you sure to delete selected one? (y/n)");
        String yesNo = ScannerUtil.nextLine(scanner, message);
        if (yesNo.equalsIgnoreCase("y")) {
            System.out.println("The Selected infomation is deleted");
            userController.delete(u);
        }
    }
    
    

}
