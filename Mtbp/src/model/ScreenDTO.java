package model;

public class ScreenDTO {
    // ��ũ���� ��ȣ (�Ʒ��� ������ ������)
    private int screenId;
    // ������� Ȯ���ϴ� ��ũ�� ��ü
    private String screenNumber;
    
    // Getter, Setter
    
    public int getScreenId() {
        return screenId;
    }
    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }
    public String getScreenNumber() {
        return screenNumber;
    }
    public void setScreenNumber(String screenNumber) {
        this.screenNumber = screenNumber;
    }
    
    // equals() ScreenInfo
    public boolean equals(Object o) {
        if(o instanceof ScreenDTO) {
            ScreenDTO s = (ScreenDTO)o;
            if(screenId == s.screenId) {
                return true;
            }
        }        
        return false;
    }

}
