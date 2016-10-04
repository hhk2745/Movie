package admin.movie.db;

import java.util.List;

import admin.movie.mybatis.SimpleExample;

public class MovieDAOImpl implements MovieDAO {
	@Override
	public List movieList_admin(int start, int end){
		// TODO Auto-generated method stub
		List list = null;
		list = SimpleExample.listMovie(start, end);
		
		return list;
	}
	// 영화 
	@Override
	public int movieGetCount() {
		int res = 0;
		res = SimpleExample.movieGetCount();
		return res;
	};
	// 리스트 뽑기 
	@Override
	public List getList(String mode) {
		// TODO Auto-generated method stub
		List list = null;
		list = SimpleExample.getList(mode);
		
		return list;
	}
	
	@Override
	public List DayToList(String date) { //
		// TODO Auto-generated method stub
		List list = null;
		list = SimpleExample.DayToList(date);
		
		return list;
	}

	@Override
	public Movie_infoDTO getMovie(int num) {
		// TODO Auto-generated method stub
		Movie_infoDTO dto = null;
		dto = SimpleExample.getMovie(num);
		
		return dto;
	}
	@Override
	public List nowMonthMovie(String date) {
		// TODO Auto-generated method stub
		return SimpleExample.nowMonthMovie(date);
	}
	@Override
	public int insertMovie(Movie_infoDTO dto) {
		// TODO Auto-generated method stub
		int res = 0;
		res = SimpleExample.insertMovie(dto);
		return res;
		
	}

	@Override
	public int updateMovie(Movie_infoDTO dto) {
		// TODO Auto-generated method stub
		int res = 0;
		res = SimpleExample.updateMovie(dto);
		return res;
	}

	@Override
	public int updateLike_num(int num) {
		// TODO Auto-generated method stub
		int res = 0;
		res = SimpleExample.updateLike_num(num);
		return res;
	}

	@Override
	public List searchMovie(String search, String searchStr) {
		// TODO Auto-generated method stub
		return SimpleExample.searchMovie(search, searchStr);
	}

	@Override
	public int insertStillcut(Movie_urlDTO dto) {
		// TODO Auto-generated method stub
		int res = 0 ;
		res = SimpleExample.insertStillcut(dto);
		return res;
		
	}

	@Override
	public List getStillcut(int num) {
		// TODO Auto-generated method stub
		return SimpleExample.getStillcut(num);
	}

	@Override
	public void upCount(int num) {
		// TODO Auto-generated method stub
		SimpleExample.upCount(num);
	}

	@Override
	public void downCount(int num) {
		// TODO Auto-generated method stub
		SimpleExample.downCount(num);
	}

	@Override
	public int updateClose(int num) {
		// TODO Auto-generated method stub
		return SimpleExample.updateClose(num);
	}
	//영화 한줄평
	
	@Override
	public List listReply(int num,int startRow,int endRow) {
		// TODO Auto-generated method stub
		return SimpleExample.listReply(num,startRow,endRow);
	}
	@Override
	public int deleteReply(int num) {
		// TODO Auto-generated method stub
		return SimpleExample.deleteReply(num);
	}
	
	@Override
	public int replyGetCount() {
		// TODO Auto-generated method stub
		return SimpleExample.replyGetCount();
	}
	@Override
	public List listReply(int movieNum) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	   public List allReply() {
	      // TODO Auto-generated method stub
	      return SimpleExample.allReply();
	 }
	@Override
	   public int insertReply(Movie_info_replyDTO dto) {
	      // TODO Auto-generated method stub
	      int res=0;
	      res=SimpleExample.insertReply(dto);
	      return res;
	 }
	@Override
	public List nowSchedule(String day) {
		// TODO Auto-generated method stub
		return SimpleExample.nowSchedule(day);
	}
	
}

