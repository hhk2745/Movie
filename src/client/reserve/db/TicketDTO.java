package client.reserve.db;

public class TicketDTO {
	private int num;
	private String day;	
	private String id;	
	private String theater;	
	private int theaternum;	
	private String time;	
	private String title;	
	private String age;		
	private String sitnum;	
	private int price;		
	private int point;
	private int pay;
	private String chk;
	
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSitnum() {
		return sitnum;
	}
	public void setSitnum(String sitnum) {
		this.sitnum = sitnum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public String getChk() {
		return chk;
	}
	public void setChk(String chk) {
		this.chk = chk;
	}
	@Override
	public String toString() {
		return "TicketDTO [num=" + num + ", day=" + day + ", id=" + id + ", theater=" + theater + ", theaternum="
				+ theaternum + ", time=" + time + ", title=" + title + ", age=" + age + ", sitnum=" + sitnum
				+ ", price=" + price + ", point=" + point + ", pay=" + pay + ", chk=" + chk + "]";
	}
	
	
	
	

}
