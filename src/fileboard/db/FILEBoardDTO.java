package fileboard.db;

public class FILEBoardDTO {
	int num, likeCount;
	String id, content, reg_date, fileName;
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	@Override
	public String toString() {
		return "FILEBoardDTO [num=" + num + ", likeCount=" + likeCount + ", id=" + id + ", content=" + content
				+ ", reg_date=" + reg_date + ", fileName=" + fileName + "]";
	}
}	
