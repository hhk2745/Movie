package admin.movie.mybatis;


import admin.movie.db.Movie_infoDTO;
import admin.movie.db.Movie_info_replyDTO;
import admin.movie.db.Movie_urlDTO;

import java.io.Reader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class SimpleExample {

	private static SqlSessionFactory sqlMapper;
  static {
    try {
      Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
      	sqlMapper = new SqlSessionFactoryBuilder().build(reader);
      reader.close(); 
    } catch (IOException e) {
      throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
    }
  }

  public static List listMovie(int startRow,int endRow){
	  List list = null;
	  SqlSession session = sqlMapper.openSession();
	  Map<String,Integer> map = new HashMap<String,Integer>();
	  map.put("start", startRow);
	  map.put("end", endRow);
	  list = session.selectList("listMovie",map);
	  session.close();
	  return list;
  }
  public static List getList(String mode){
	  List list = null;
	  SqlSession session = sqlMapper.openSession();
	  list = session.selectList(mode);
	  session.close();
	  return list;
  }
  public static List DayToList(String date){
	  List list = null;
	  SqlSession session = sqlMapper.openSession();
	  list = session.selectList("DayToList",date);
	  session.close();
	  return list;
  }
  public static List nowSchedule(String day){
	  List list = null;
	  SqlSession session = sqlMapper.openSession();
	  list = session.selectList("nowSchedule",day);
	  session.close();
	  return list;
  }
  public static List nowMonthMovie(String date){
	  List list = null;
	  SqlSession session = sqlMapper.openSession();
	  list = session.selectList("nowMonthMovie",date);
	  session.close();
	  return list;
  }
  public static Movie_infoDTO getMovie(int num){
	  SqlSession session = sqlMapper.openSession();
	  Movie_infoDTO dto = new Movie_infoDTO();
	  dto = (Movie_infoDTO)session.selectOne("getMovie",num);
	  session.close();
	  return dto;
  }
  public static int insertMovie(Movie_infoDTO dto){
	  SqlSession session = sqlMapper.openSession();
	  int res = 0;
	  res = session.insert("insertMovie",dto);
	  session.commit();
	  session.close();
	  return res;
  }
  public static int updateMovie(Movie_infoDTO dto){
	  SqlSession session = sqlMapper.openSession();
	  int res = 0;
	  res = session.update("updateMovie",dto);
	  session.commit();
	  session.close();
	  return res;
  }
  
  public static int updateLike_num(int num){
	  SqlSession session = sqlMapper.openSession();
	  int res = 0;
	  res = session.update("updateLike_num",num);
	  session.commit();
	  session.close();
	  return res;
  }
  
  
  public static int deleteMovie(int num) {
	  SqlSession session = sqlMapper.openSession();
	  int res =0;
	  res = session.delete("deleteMovie",num);
	  session.commit();
	  session.close();
	  return res;
  }
  
  public static List searchMovie(String search, String searchStr){
	  List list = null;
	  SqlSession session = sqlMapper.openSession();
	  HashMap<String,String> map = new HashMap();
	  map.put("search", search);
	  map.put("searchStr", searchStr);
	  list = session.selectList("searchMovie",map);
	  session.close();
	  return list;
  }

  public static int insertStillcut(Movie_urlDTO dto){
	  int res = 0 ;
	  SqlSession session = sqlMapper.openSession();
	  res = session.insert("insertStillcut",dto);
	  session.commit();
	  session.close();
	  return res;
  }
  
  public static List getStillcut(int num){
	  List list = null;
	  SqlSession session = sqlMapper.openSession();
	  list = session.selectList("getStillcut",num);
	  session.close();
	  return list;
	  
  }
  
	public static void upCount(int num) {
		SqlSession session = sqlMapper.openSession();
		session.update("upCount",num);
		session.commit();
		session.close();
	}

	public static void downCount(int num) {
		SqlSession session = sqlMapper.openSession();
		session.update("downCount",num);
		session.commit();
		session.close();
	}

	public static int updateClose(int num) {
		SqlSession session = sqlMapper.openSession();
		int res = 0;
		res = session.update("updateClose",num);
		session.commit();
		session.close();
		return res;
	}
	public static int movieGetCount(){
		SqlSession session = sqlMapper.openSession();
		int res = 0;
		res = session.selectOne("getCount");
		session.close();
		return res;
	}
	
	//영화 한줄평
	public static List listReply(int movieNum,int startRow,int endRow){
		SqlSession session = sqlMapper.openSession();
		Map<String,Integer> map = new HashMap();
		
		map.put("movieNum", movieNum);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		List list = session.selectList("listReply", map);
		session.close();
		return list;
	}
	public static int replyGetCount(){
		SqlSession session = sqlMapper.openSession();
		
		int res = session.selectOne("replyGetCount");
		session.close();
		return res;
	}
	public static int deleteReply(int num){
		SqlSession session = sqlMapper.openSession();
		
		int res = session.delete("deleteReply", num);
		session.commit();
		session.close();
		return res;
	}
	 //영화 한줄평 등록
   public static int insertReply(Movie_info_replyDTO dto) {
      SqlSession session = sqlMapper.openSession();
      int res = 0;
      res = session.insert("insertReply", dto);
      session.commit();
      session.close();
      return res;
   }
   public static List allReply(){
      SqlSession session = sqlMapper.openSession();

      List list = session.selectList("allReply");
      session.close();
      return list;
      
   }

}
