package admin.movie.db;

public class Movie_urlDTO {
	private int num; // 영화 번호
	private String stillcut; // 스틸컷 이미지 경로
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getStillcut() {
		return stillcut;
	}
	public void setStillcut(String stillcut) {
		this.stillcut = stillcut;
	}

}
