package model;

public class MovieTheaterDTO {
    // ��ȭ�� ��ȣ (�Ʒ��� ������ ������)
    private int theaterId;
    // ��ȭ�� ��ġ (����)
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
