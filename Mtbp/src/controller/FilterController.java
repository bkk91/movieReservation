package controller;

import java.util.ArrayList;

import model.FilterDTO;

public class FilterController {

    ArrayList<FilterDTO> filterList;
    private int filterId;
    
    public FilterController() {
        filterList = new ArrayList<>();
        filterId = 1;
        
        FilterDTO f1 = new FilterDTO();
        f1.setMovie("괴물");
        f1.setTheater("서울 강남시네마");
        f1.setMonth(4);
        f1.setDay(10);
        f1.setHour(15);
        f1.setMinute(30);
        filterList.add(f1);        
    }
    
    public void add(FilterDTO f) {
        f.setfilterId(filterId++);
        filterList.add(f);
    }
    
    public void delete(FilterDTO f) {
        filterList.remove(f);
    }
    
    public FilterDTO selectOne(int filterId) {
        for (FilterDTO f : filterList) {
            if (f.getfilterId() == filterId) {
                return f;
            }
        }
        return null;
    }

    public ArrayList<FilterDTO> printAll() {
        for (FilterDTO a : filterList) {

        }
        return filterList;
    }
}
