package model;

public class AllDTO {
    private int id;
    private String theater;
    private String screen;
    private int month;
    private int day;
    private int hour;
    private int minute;

    // Getter, setter
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
    
    // equals() ScreenTime

    public boolean equals(Object o) {
        if (o instanceof AllDTO) {
            AllDTO a = (AllDTO) o;
            if (id == a.id) {
                return true;
            }
        }
        return false;
    }

}
