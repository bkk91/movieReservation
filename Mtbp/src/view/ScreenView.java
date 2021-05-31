package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ScreenController;
import model.ScreenDTO;
import util.ScannerUtil;

public class ScreenView {
    
    private Scanner scanner;
    private ScreenController screenController;
    private int screenId;
    
    public ScreenView() {
        
        scanner = new Scanner(System.in);
        screenController = new ScreenController();
        
    }
    
    public void list() {
        ArrayList<ScreenDTO> screenList = screenController.printAll();
        
        screenList = screenController.printAll();        
        
        for(ScreenDTO s : screenList) {
            System.out.printf("[%d] Location: %s\n",s.getScreenId(),s.getScreenNumber());
        }
        System.out.println();
    }
    
    public void select() {
        String message;
        message = new String("Choose Location, then put \"Id\" number");
        screenId = ScannerUtil.nextInt(scanner, message);
        
        ScreenDTO s = screenController.screenSelectOne(screenId);
        
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        System.out.println("     Selected Theater    ");
        System.out.println();
        System.out.printf("[%d] Location: %s\n",s.getScreenId(),s.getScreenNumber());
        System.out.println();
        System.out.println("________________________");
        System.out.println();
    }
    
    public void admin() {
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        System.out.println("     Theater Location   ");
        System.out.println();

        list();
        select();
    }
    
}
