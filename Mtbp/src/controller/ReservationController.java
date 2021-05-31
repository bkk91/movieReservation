package controller;

import java.util.ArrayList;
import model.ReservationDTO;

public class ReservationController {

	ArrayList<ReservationDTO> reservationList;
	private int reservationId;

	public ReservationController() {

		reservationList = new ArrayList<>();
		reservationId = 1;

	}

	public void reservationAdd(ReservationDTO r) {
		r.setReservationId(reservationId++);
		reservationList.add(r);
	}

	public ReservationDTO reservationSelectOne(int reservationId) {
		for (ReservationDTO r : reservationList) {
			if (r.getReservationId() == reservationId) {
				return r;
			}
		}
		return null;
	}

	public ArrayList<ReservationDTO> selectList() {
		return reservationList;
	}

	public boolean validateSeat(ReservationDTO user) {
		for (ReservationDTO r : reservationList) {
			if (r.getRow()==(user.getRow()) 
				&& r.getColumn()==(user.getColumn())) {
				return true;
			}
		}
		
		return false;
	}

}
