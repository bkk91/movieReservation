package model;

public class MovieTheaterDTO {
    // 영화관 번호 (아래의 정보를 저장할)
    private int theaterId;
    // 영화관 위치 (지역)
    private String location;
    
    // Getter / Setter
    
    public int getTheaterId() {
        return theaterId;
    }
    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    
    // equals() MovieTheater Info
    public boolean equals(Object o) {
        if(o instanceof MovieTheaterDTO) {
            MovieTheaterDTO t = (MovieTheaterDTO)o;
            if(theaterId == t.theaterId) {
                return true;
            }
        }
        return false;
    }
}
