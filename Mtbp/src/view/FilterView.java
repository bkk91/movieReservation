package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ScreeningTimeController;
import controller.AllController;
import controller.MovieInfoController;
import controller.MovieTheaterController;
import model.AllDTO;
import model.FilterDTO;
import model.MovieInfoDTO;
import model.MovieTheaterDTO;
import model.ScreeningTimeDTO;
import util.ScannerUtil;

public class FilterView {

	private Scanner scanner;
	private ScreeningTimeController screeningTimeController;
	private AllInfoInputView allInfoInputView;
	private AllController allController;
	private MovieInfoController movieInfoController;
	private MovieTheaterController movieTheaterController;

	public FilterView() {
		scanner = new Scanner(System.in);
		allInfoInputView = new AllInfoInputView();
		movieInfoController = new MovieInfoController();
		movieTheaterController = new MovieTheaterController();
		allController = new AllController();
		screeningTimeController = new ScreeningTimeController();
	}

	public void filterMovie() {
		System.out.println();
		System.out.println("________________________");
		System.out.println();
		ArrayList<AllDTO> allList = allController.printAll();

		ArrayList<MovieInfoDTO> list = movieInfoController.printAll();

		for (MovieInfoDTO m : list) {
			FilterDTO f = new FilterDTO();
			if (m.getMovieName().equals(f.getMovie())) {
				for (AllDTO a : allList) {
					System.out.printf("[Location: %s]\n", a.getTheater());
					System.out.printf("[ScreenNumber: %s]\n", a.getScreen());
					System.out.printf("[Time: %02d-%02d %02d:%02d]\n", a.getMonth(), a.getDay(), a.getHour(),
							a.getMinute());
				}
			}
		}
	}

	public void filterTheater() {
		System.out.println();
		System.out.println("________________________");
		System.out.println();

		ArrayList<AllDTO> allList = allController.printAll();

		ArrayList<MovieTheaterDTO> theaterList = movieTheaterController.printAll();

		for (MovieTheaterDTO t : theaterList) {
			FilterDTO f = new FilterDTO();
			if (t.getLocation().equals(f.getTheater())) {
				for (AllDTO a : allList) {
					System.out.printf("[Location: %s]\n", a.getTheater());
					System.out.printf("[ScreenNumber: %s]\n", a.getScreen());
					System.out.printf("[Time: %02d-%02d %02d:%02d]\n", a.getMonth(), a.getDay(), a.getHour(),
							a.getMinute());
				}
			}
		}
	}

	public void filterTime() {
		System.out.println();
		System.out.println("________________________");
		System.out.println();
		ArrayList<AllDTO> allList = allController.printAll();
		
		ArrayList<ScreeningTimeDTO> timelist = screeningTimeController.printAll();
		for (ScreeningTimeDTO st : timelist) {
			FilterDTO f = new FilterDTO();
			if (st.getMonth() == f.getMonth() && st.getDay() == f.getDay() && st.getHour() == f.getHour()
					&& st.getMinute() == f.getMinute()) {

				for (AllDTO a : allList) {
					System.out.printf("[Location: %s]\n", a.getTheater());
					System.out.printf("[ScreenNumber: %s]\n", a.getScreen());
					System.out.printf("[Time: %02d-%02d %02d:%02d]\n", a.getMonth(), a.getDay(), a.getHour(),
							a.getMinute());
				}
			}
		}

	}

}
