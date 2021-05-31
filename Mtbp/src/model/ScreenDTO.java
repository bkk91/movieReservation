package model;

public class ScreenDTO {
    // 스크린의 번호 (아래의 정보를 저장할)
    private int screenId;
    // 몇관인지 확인하는 스크린 객체
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
