package admin.schedule.db;

public class ScheduleDTO {
	private String day;
	private int time;
	private String theater;
	private int theaternum;
	private String title;
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getTheater() {
		return theater;
	}
	public void setTheater(String theater) {
		this.theater = theater;
	}
	public int getTheaternum() {
		return theaternum;
	}
	public void setTheaternum(int theaternum) {
		this.theaternum = theaternum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "ScheduleDTO [day=" + day + ", time=" + time + ", theater=" + theater + ", theaternum=" + theaternum
				+ ", title=" + title + "]";
	}
	
	

}
