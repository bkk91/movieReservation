package model;

public class ReservationDTO {
    private int reservationId;
    private int row;
    private int column;
    private int Total;
    
    // Getter, Setter
    
    public int getReservationId() {
        return reservationId;
    }
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getColumn() {
        return column;
    }
    public void setColumn(int column) {
        this.column = column;
    }
    public int getTotal() {
        return Total;
    }
    public void setTotal(int total) {
        Total = total;
    }
    
    // equals() ScreenInfo
    public boolean equals(Object o) {
        if(o instanceof ReservationDTO) {
            ReservationDTO r = (ReservationDTO)o;
            if(reservationId == r.reservationId) {
                return true;
            }
        }        
        return false;
    }
    
    
    
}
