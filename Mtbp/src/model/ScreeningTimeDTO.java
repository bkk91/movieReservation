package model;

public class ScreeningTimeDTO {

    // 영화의 상영시간을 순차적으로 ArrayList에 등록할 정보를 저장할 변수 id;
    private int timeid;

    // 영화의 상영시간을 입력할 변수 screenTime;
    // 처음에 String 타입으로 Getter, setter 정보를 저장
    // controller에서 sdf를 통해 MM.dd hh:mm 월/일 시간/분으로 입력받는다
    // 입력받을 month
    private int month;
    // 입력받을 day
    private int day;
    // 입력받을 시간
    private int hour;
    // 입력받을 분
    private int minute;

    public int getTimeid() {
        return timeid;
    }

    public void setTimeid(int timeid) {
        this.timeid = timeid;
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
        if (o instanceof ScreeningTimeDTO) {
            ScreeningTimeDTO st = (ScreeningTimeDTO) o;
            if (timeid == st.timeid) {
                return true;
            }
        }
        return false;
    }

}
