package model;

public class MovieInfoDTO {
    // ��ȭ��ȣ (�Ʒ��� ������ ������)
    private int movieId;
    // ��ȭ����
    private String movieName;
    // ��ȭ �󿵽ð�
    private String runningTime;
    // ��ȭ ����
    private String movieEvaluation;
    // ��ȭ �ٰŸ�
    private String movieSummary;
    
    // Getter, Setter
    
    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public String getRunningTime() {
        return runningTime;
    }
    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }
    public String getMovieEvaluation() {
        return movieEvaluation;
    }
    public void setMovieEvaluation(String movieEvaluation) {
        this.movieEvaluation = movieEvaluation;
    }
    public String getMovieSummary() {
        return movieSummary;
    }
    public void setMovieSummary(String movieSummary) {
        this.movieSummary = movieSummary;
    }
    
    // equals() MovieInfo
    public boolean equals(Object o) {
        if(o instanceof MovieInfoDTO) {
            MovieInfoDTO m = (MovieInfoDTO)o;
            if(movieId == m.movieId) {
                return true;
            }
        }
        return false;
    }
    
}
