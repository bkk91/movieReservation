package view;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

import util.ScannerUtil;
import model.FilterDTO;
import model.ScreeningTimeDTO;
import controller.ScreeningTimeController;
import controller.FilterController;

public class ScreeningTimeView {

    private Scanner scanner;
    private ScreeningTimeController screeningTimeController;
    private FilterController filterController;
    private ArrayList<ScreeningTimeDTO> timeList;
    private int timeId;

    ScreeningTimeView() {

        scanner = new Scanner(System.in);
        screeningTimeController = new ScreeningTimeController();
        filterController = new FilterController();
        timeList = new ArrayList<>();

    }

    public void admin() {
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        System.out.println("     Screening Time     ");
        System.out.println("________________________");
        System.out.println();
        while(true) {
            String message;
            message = new String("1. Screentime List\n2. Screentime Manage\n3. back");
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if(userChoice == 1) {
                list();
            }
            else if(userChoice == 2) {
                timeRegister();
            }
            else if(userChoice == 3) {
                System.out.println();
                System.out.println("_____________________");
                System.out.println("back to previous page");
                System.out.println();
                break;
            }
        }
    }

    public void userMenu() {
    	System.out.println();
        System.out.println("________________________");
        System.out.println();
        System.out.println("     Screening Time     ");
        System.out.println();
        list();
        compare();
        select();
        System.out.println();
        System.out.println("________________________");
        System.out.println();

    }

    // ���ϴ� �󿵽ð��� SimpleDateFormat�� ���߾� �Է��ϴ� ����ϴ� �޼ҵ�

    public void timeRegister() {
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        System.out.println("      Screening Time    ");
        System.out.println();
        System.out.println(" ex) format: 03-20 12:00");

        ScreeningTimeDTO st = new ScreeningTimeDTO();
        String message;

        message = new String("Input Month");
        st.setMonth(ScannerUtil.nextInt(scanner, message, 1, 12));

        message = new String("Input day");
        st.setDay(ScannerUtil.nextInt(scanner, message, 1, 31));

        message = new String("Input Hour");
        st.setHour(ScannerUtil.nextInt(scanner, message, 0, 24));

        message = new String("Input Minute");
        st.setMinute(ScannerUtil.nextInt(scanner, message, 0, 60));

        screeningTimeController.add(st);
    }

    // �󿵽ð��� SimpleDateFormat�� ���߾� ����ϴ� �޼ҵ�
    public void list() {
    	System.out.println();
        System.out.println("________________________");
        System.out.println();
        ArrayList<ScreeningTimeDTO> timelist = screeningTimeController.printAll();

        timeList = screeningTimeController.printAll();
        

        for (ScreeningTimeDTO st : timeList) {
            System.out.printf("[%d] Time: %02d-%02d %02d:%02d\n", st.getTimeid(), st.getMonth(), st.getDay(),
                    st.getHour(), st.getMinute());
            
            ArrayList<FilterDTO> filterList = filterController.printAll();
            FilterDTO f = new FilterDTO();
            f.setMonth(st.getMonth());
            f.setDay(st.getDay());
            f.setHour(st.getHour());
            f.setMinute(st.getMinute());
            
        }
        
        
    }

    // ��ϵ� �󿵽ð��� ����ð��� �����ִ� �޼ҵ�
    public boolean compare() {
        for (ScreeningTimeDTO st : screeningTimeController.printAll()) {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd hh:mm");
            String compare = sdf.format(cal.getTime());

            int tempMonth = Integer.parseInt(compare.substring(0, 2));
            int tempDay = Integer.parseInt(compare.substring(3, 5));
            int tempHour = Integer.parseInt(compare.substring(6, 8));
            int tempMinute = Integer.parseInt(compare.substring(9, 11));
            if (st.getMonth() >= tempMonth) {
                if (st.getDay() >= tempDay) {
                    if (st.getHour() >= tempHour) {
                        if (st.getMinute() >= tempMinute) {

                            return true;
                        }
                    }
                }

            }

        }
        return false;
    }

    public void select() {
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        String message;
        message = new String("Choose screening time, then put number");
        timeId = ScannerUtil.nextInt(scanner, message);
        ScreeningTimeDTO st = screeningTimeController.selectOne(timeId);
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        System.out.printf("%d. time: %s-%s %s:%s\n", st.getTimeid(), st.getMonth(), st.getDay(), st.getHour(),
                st.getMinute());
        System.out.println();
    }

    public void timeupdate() {
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        System.out.println("  Update Screening Time ");
        System.out.println();

        list();
        select();
        ScreeningTimeDTO st = screeningTimeController.selectOne(timeId);

        String message;
        message = new String("Insert screening time by subsequent format, below\n" + "ex)03-20 12:00, MM-dd hh:mm ����");
        System.out.printf("%d. time: %s-%s %s:%s\n", st.getTimeid(), st.getMonth(), st.getDay(), st.getHour(),
                st.getMinute());

        screeningTimeController.update(st);
    }

    public void delete() {
        System.out.println();
        System.out.println("________________________");
        System.out.println();
        System.out.println("  Delete selected time  ");
        System.out.println();
        list();
        select();
        ScreeningTimeDTO st = screeningTimeController.selectOne(timeId);

        String message;
        message = new String("Are you sure to delete selected one? (y/n)");
        String yesNo = ScannerUtil.nextLine(scanner, message);
        if (yesNo.equalsIgnoreCase("y")) {
            System.out.println("The Selected information is deleted");
            screeningTimeController.delete(st);
        }
    }

}
