package model;

public class FilterDTO {
    private int filterId;
    private String movie;
    private String theater;
    private int month;
    private int day;
    private int hour;
    private int minute;
    
    public int getFilterId() {
        return filterId;
    }
    public void setFilterId(int filterId) {
        this.filterId = filterId;
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
    public int getfilterId() {
        return filterId;
    }
    public void setfilterId(int filterId) {
        this.filterId = filterId;
    }
    public String getMovie() {
        return movie;
    }
    public void setMovie(String movie) {
        this.movie = movie;
    }
    public String getTheater() {
        return theater;
    }
    public void setTheater(String theater) {
        this.theater = theater;
    }
    
    public boolean equals(Object o) {
        if (o instanceof FilterDTO) {
            FilterDTO f = (FilterDTO) o;
            if (filterId == f.filterId) {
                return true;
            }
        }
        return false;
    }

}
