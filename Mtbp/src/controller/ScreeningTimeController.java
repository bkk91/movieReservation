package controller;

import java.util.ArrayList;

import model.ScreeningTimeDTO;

public class ScreeningTimeController {

    ArrayList<ScreeningTimeDTO> timeList;
    private int timeId;

    public ScreeningTimeController() {

        timeList = new ArrayList<>();
        timeId = 1;

        ScreeningTimeDTO st1 = new ScreeningTimeDTO();

        st1.setTimeid(timeId++);
        st1.setMonth(4);
        st1.setDay(10);
        st1.setHour(8);
        st1.setMinute(15);
        timeList.add(st1);

        ScreeningTimeDTO st2 = new ScreeningTimeDTO();

        st2.setTimeid(timeId++);
        st2.setMonth(4);
        st2.setDay(1);
        st2.setHour(20);
        st2.setMinute(50);
        timeList.add(st2);
        

    }

    public void add(ScreeningTimeDTO st) {
        st.setTimeid(timeId++);
        timeList.add(st);
    }

    public ScreeningTimeDTO selectOne(int timeId) {
        for (ScreeningTimeDTO st : timeList) {
            if (st.getTimeid() == timeId) {
                return st;
            }
        }
        return null;
    }
    
    public ArrayList<ScreeningTimeDTO> printAll(){
        for(ScreeningTimeDTO st : timeList) {
            
        }
        return timeList;
    }

    public void update(ScreeningTimeDTO updated) {
        for(ScreeningTimeDTO st: timeList) {
            if(st.getTimeid() == updated.getTimeid()) {
                st.setMonth(updated.getMonth());
                st.setDay(updated.getDay());
                st.setHour(updated.getHour());
                st.setMinute(updated.getMinute());
            }
        }        
    }
    
    public void delete(ScreeningTimeDTO st) {
        timeList.remove(st);
    }
    

}