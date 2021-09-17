package dto;

public class MovieDTO {
	private String title,infomation,nation,director,actor,filmRate,MovieDate;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInfomation() {
		return infomation;
	}
	public void setInfomation(String infomation) {
		this.infomation = infomation;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getFilmRate() {
		return filmRate;
	}
	public void setFilmRate(String filmRate) {
		this.filmRate = filmRate;
	}
	public String getMovieDate() {
		return MovieDate;
	}
	public void setMovieDate(String movieDate) {
		MovieDate = movieDate;
	}
	public int getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}
	private int runningTime;
}
