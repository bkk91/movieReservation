package controller;

import java.util.ArrayList;

import model.MovieTheaterDTO;

public class MovieTheaterController {

    ArrayList<MovieTheaterDTO> theaterList;
    private int theaterId;

    public MovieTheaterController() {

        theaterList = new ArrayList<>();
        theaterId = 1;

        MovieTheaterDTO t1 = new MovieTheaterDTO();
        t1.setTheaterId(theaterId++);
        t1.setLocation("서울 강남시네마");
        theaterList.add(t1);

        MovieTheaterDTO t2 = new MovieTheaterDTO();
        t2.setTheaterId(theaterId++);
        t2.setLocation("서울 신촌시네마");
        theaterList.add(t2);

        MovieTheaterDTO t3 = new MovieTheaterDTO();
        t3.setTheaterId(theaterId++);
        t3.setLocation("서울 강변시네마");
        theaterList.add(t3);

        MovieTheaterDTO t4 = new MovieTheaterDTO();
        t4.setTheaterId(theaterId++);
        t4.setLocation("서울 영등포시네마");
        theaterList.add(t4);
    }
    
    
    // ��ȭ���� ��ġ�� add/update ��ɸ� �ִ�.
    // �����ڷκ��� ���ο� ��ȭ���� ����(��ġ)�� ����Ʈ�� �߰����ִ� add �޼ҵ�
    public void theaterAdd(MovieTheaterDTO t) {
        t.setTheaterId(theaterId++);
        theaterList.add(t);
    }
    
    // �����ڷκ��� �Է¹��� MovieTheaterDTO ��ü ��ȭ���� ����(��ġ)�� ����Ʈ�� �������ִ� update �޼ҵ�
    public void theaterUpdate(MovieTheaterDTO updated) {
        for(MovieTheaterDTO t: theaterList) {
            if(t.getTheaterId() == updated.getTheaterId()) {
                t.setLocation(updated.getLocation());
            }
        }
    }
    // �����ڷκ��� ��ȭ���� ��ȣ�� �Է½� ������ �������� selectOne �޼ҵ�
    public MovieTheaterDTO theaterSelectOne(int theaterId) {
        for(MovieTheaterDTO t: theaterList) {
            if(t.getTheaterId() == theaterId) {
                return t;
            }
        }
        return null;
    }
    // �󿵰��� ��ġ ��ü�� �����ִ� �޼ҵ�
    public ArrayList<MovieTheaterDTO> printAll() {
        for (MovieTheaterDTO t : theaterList) {

        }
        return theaterList;
    }

}
