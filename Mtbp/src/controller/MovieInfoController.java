package controller;

import java.util.ArrayList;
import model.MovieInfoDTO;

public class MovieInfoController {

	ArrayList<MovieInfoDTO> movieList;
	private int movieId;

	public MovieInfoController() {

		movieList = new ArrayList<>();
		movieId = 1;

		MovieInfoDTO m1 = new MovieInfoDTO();
		m1.setMovieId(movieId++);
		m1.setMovieName("괴물");
		m1.setMovieEvaluation("4.6점\n");
		m1.setRunningTime("102분");
		m1.setMovieSummary("어느 날, 한강에 괴상한 괴물이 나타나 딸을 잡아간다." + "\n 딸과 조카를 구하기 위해 가족끼리 모인 사투극");
		movieList.add(m1);

		MovieInfoDTO m2 = new MovieInfoDTO();
		m2.setMovieId(movieId++);
		m2.setMovieName("베테랑");
		m2.setMovieEvaluation("4.8점\n");
		m2.setRunningTime("115분");
		m2.setMovieSummary("한 번 꽂힌 것은 무조건 끝을 보는 행동파 ‘서도철’(황정민),20년 경력의 승부사 ‘오팀장’(오달수), 위장 전문 홍일점 ‘미스봉’(장윤주)\n, "
				+ "육체파 ‘왕형사’(오대환), 막내 ‘윤형사’(김시후)까지 겁 없고, 못 잡는 것 없고, 봐주는 것 없는 특수 강력사건 담당 광역수사대.\n"
				+ "오랫동안 쫓던 대형 범죄를 해결한 후 숨을 돌리려는 찰나, 서도철은 재벌 3세 ‘조태오’(유아인)를 만나게 된다.\n "
				+ "세상 무서울 것 없는 안하무인의 조태오와 언제나 그의 곁을 지키는 오른팔 ‘최상무’(유해진).\n "
				+ "서도철은 의문의 사건을 쫓던 중 그들이 사건의 배후에 있음을 직감한다.\n "
				+ "건들면 다친다는 충고에도 불구하고 포기하지 않는 서도철의 집념에판은 걷잡을 수 없이 커져가고\n "
				+ "조태오는 이를 비웃기라도 하듯 유유히 포위망을 빠져 나가는데… \n베테랑 광역수사대 VS 유아독존 재벌 3세2015년 여름, \n" + "자존심을 건 한판 대결이 시작된다!");
		movieList.add(m2);

		MovieInfoDTO m3 = new MovieInfoDTO();
		m3.setMovieId(movieId++);
		m3.setMovieName("곤지암");
		m3.setMovieEvaluation("3.8점\n");
		m3.setRunningTime("103분");
		m3.setMovieSummary("1979년 환자 42명의 집단 자살과 병원장의 실종 이후,\n"
				+ "섬뜩한 괴담으로 둘러싸인 곤지암 정신병원으로공포체험을 떠난 7명의 멤버들원장실, 집단 치료실, 실험실, 열리지 않는 402호…\n"
				+ "괴담의 실체를 담아내기 위해병원 내부를 촬영하기 시작하던 멤버들에게상상도 못한 기이하고 공포스러운 일들이실제로 벌어지기 시작 하는데…\n"
				+ "가지 말라는 곳에는 반드시 이유가 있다.소름 끼치는 ‘곤지암 정신병원’ 의 실체를 체험하라!");
		movieList.add(m3);

		MovieInfoDTO m4 = new MovieInfoDTO();
		m4.setMovieId(movieId++);
		m4.setMovieName("아저씨");
		m4.setMovieEvaluation("4.1점\n");
		m4.setRunningTime("103분");
		m4.setMovieSummary("불행한 사건으로 아내를 잃고 세상을 등진 채 전당포를 운영하며 외롭게 살아가는 전직 특수요원 태식. \n"
				+ "태식은 소미를 구하기 위해 범죄조직과 거래를 하게 되고, 이로 인해 경찰마저 태식을 추격하게 된다.\n"
				+ " 한 걸음씩 한 걸음씩 범죄조직의 중심에 다가서면서 베일에 싸여있던 태식의 비밀스런 과거도 함께 드러나게 되는데… ");
		movieList.add(m4);
	}

	// ����ڷκ��� �Է¹��� MovieInfoDTO ��ü (��ȭ���)�� ����Ʈ�� �߰����ִ� add �޼ҵ�
	public void movieAdd(MovieInfoDTO m) {
		m.setMovieId(movieId++);

		movieList.add(m);
	}

	// ����ڷκ��� �Է¹��� MovieDTO ��ü (��ȭ���)�� ����Ʈ�� �������ִ� update �޼ҵ�
	public void movieUpdate(MovieInfoDTO updated) {
		for (MovieInfoDTO m : movieList) {
			if (m.getMovieId() == updated.getMovieId()) {
				m.setMovieName(updated.getMovieName());
				m.setRunningTime(updated.getRunningTime());
				m.setMovieSummary(updated.getMovieSummary());
			}
		}
	}

	// ����ڷκ��� �Է¹��� MovieDTO ��ü (��ȭ���)�� ����Ʈ���� �����ϴ� delete �޼ҵ�
	public void movieDelete(MovieInfoDTO m) {
		movieList.remove(m);
	}

	// ��ȭ��Ͽ��� ��ȭ ��ȣ �Է½� ������ �������� selectOne �޼ҵ�
	public MovieInfoDTO movieSelectOne(int movieId) {
		for (MovieInfoDTO m : movieList) {
			if (m.getMovieId() == movieId) {
				return m;
			}
		}
		return null;
	}

	// ��ȭ ��ü����� �����ִ� �޼ҵ�
	public ArrayList<MovieInfoDTO> printAll() {
		for (MovieInfoDTO m : movieList) {

		}
		return movieList;
	}

}
