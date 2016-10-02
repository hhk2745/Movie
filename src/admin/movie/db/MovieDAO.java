package admin.movie.db;

import java.util.List;

public interface MovieDAO {
	public List movieList_admin(int start,int end);
	public int movieGetCount();
	public List getList(String mode);		// 1. 전체  2. 상영중인 영화  3. 상영예정 영화  4. 상영종료 영화  5. 박스오피스  
	public List DayToList(String date);		// 해당날짜에 대한 영화 리스트(예매할때 필요)
	public List nowSchedule(String day);
	public Movie_infoDTO getMovie(int num);		// num으로 영화 정보 불러오기
	public int insertMovie(Movie_infoDTO dto);	// 영화 추가
	public int updateMovie(Movie_infoDTO dto);	// 영화 수정
	public int updateLike_num(int num);	// 추천 누르면 num 으로 영화 정보 불러와서  update  like_num  +1 
	public List searchMovie(String search, String searchStr); // search는 영화 제목
	public List nowMonthMovie(String date);
	///////////////////////////////////////////기본 영화 table/////////////////////////////////////
	
	public int insertStillcut(Movie_urlDTO dto); // 스틸컷 경로 추가
	public List getStillcut(int num); //  영화번호로 select 한 stillcut 경로가 담긴 리스트 

	/////////////////////////////////////////// 스틸컷 경로 ////////////////////////////////////////
	
	public void upCount(int num);	// 영화 번호를 받아서 예매 할 때  카운트 +1 
	public void downCount(int num);	// 영화 번호를 받아서 예매 취소 시 카운트 -1
	
	public int updateClose(int num);	// 영화 번호를 받아서 update  closedate :sysdate 
	public List listReply(int movieNum,int startRow,int endRow);
	public int deleteReply(int num);
	public int replyGetCount();
	public int insertReply(Movie_info_replyDTO dto);
	public List listReply(int movieNum);
	public List allReply();
}
