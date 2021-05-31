package model;

public class ScreeningTimeDTO {

    // ��ȭ�� �󿵽ð��� ���������� ArrayList�� ����� ������ ������ ���� id;
    private int timeid;

    // ��ȭ�� �󿵽ð��� �Է��� ���� screenTime;
    // ó���� String Ÿ������ Getter, setter ������ ����
    // controller���� sdf�� ���� MM.dd hh:mm ��/�� �ð�/������ �Է¹޴´�
    // �Է¹��� month
    private int month;
    // �Է¹��� day
    private int day;
    // �Է¹��� �ð�
    private int hour;
    // �Է¹��� ��
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
