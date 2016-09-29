package admin.movie.db;

public class Movie_memberDTO {
	private int num;			// 영화 번호 받아온 것 				번호  |  감독   |  배우  
	private String director;	// 영화 감독					 1	  ABC    abc
	private String actor;		// 영화 배우					 1    ABC    def  ...
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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

}
