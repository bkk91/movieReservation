package controller;

import java.util.ArrayList;
import model.AllDTO;

public class AllController {

    ArrayList<AllDTO> allList;
    private int id;

    public AllController() {
        allList = new ArrayList<>();
        id = 1;

        AllDTO a1 = new AllDTO();
        a1.setTheater("서울 강남시네마");
        a1.setScreen("1관");
        a1.setMonth(4);
        a1.setDay(10);
        a1.setHour(15);
        a1.setMinute(30);
        allList.add(a1);
    }

    public void add(AllDTO a) {
        a.setId(id++);
        allList.add(a);
    }

    public void delete(AllDTO a) {
        allList.remove(a);
    }

    public AllDTO selectOne(int id) {
        for (AllDTO a : allList) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public ArrayList<AllDTO> printAll() {
        for (AllDTO a : allList) {

        }
        return allList;
    }
    

}
