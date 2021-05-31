package model;

public class MovieInfoDTO {
    // 영화번호 (아래의 정보를 저장할)
    private int movieId;
    // 영화제목
    private String movieName;
    // 영화 상영시간
    private String runningTime;
    // 영화 평점
    private String movieEvaluation;
    // 영화 줄거리
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
