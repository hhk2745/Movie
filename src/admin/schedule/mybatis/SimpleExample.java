package admin.schedule.mybatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import admin.schedule.controller.ScheduleListController;
import admin.schedule.db.ScheduleDTO;
import com.ibatis.common.resources.Resources;

import java.io.Reader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.sql.SQLException;

public class SimpleExample {
private static SqlSessionFactory sqlMapper;

  static {
    try {
      Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
      sqlMapper = new SqlSessionFactoryBuilder().build(reader);
      reader.close(); 
    } catch (IOException e) {
      // Fail fast.
      throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
    }
  }

  public static List listSchedule(){
	  List list = null;
	  SqlSession session = sqlMapper.openSession();
	  list = session.selectList("listSchedule");
	  session.close();
	  return list;
  }
  public static List isNullList()
  {
	  List list = null;
	  SqlSession session = sqlMapper.openSession();
	  list = session.selectList("inNull");
	  session.close();
	  return list;
  }
  public static int insertSchedule(ScheduleDTO dto){	// (MultipartRequest mr) 
	  SqlSession session = sqlMapper.openSession();
	  int res = session.insert("insertSchedule", dto);
	  session.commit();
	  session.close();
	  return res;
  }
  
  public static ScheduleDTO getSchedule(ScheduleDTO ScheduleDTO){
	  SqlSession session = sqlMapper.openSession();
	  ScheduleDTO dto = (ScheduleDTO)session.selectOne("getSchedule", ScheduleDTO);
	  session.close();
	  return dto;
  }
  
  public static int updateSchedule(ScheduleDTO dto){
	  SqlSession session = sqlMapper.openSession();
	  int res = session.update("updateSchedule", dto);
	  session.commit();
	  session.close();
	  return res;
  }
  public static int updateCloseMovie(int num){
	  SqlSession session = sqlMapper.openSession();
	  int res = session.update("updateCloseMovie",num);
	  session.commit();
	  session.close();
	  return res;
  }
  //스케줄 최신화
  public static int deleteSchedule(){
	  SqlSession session = sqlMapper.openSession();
	  int res = session.delete("deleteSchedule");
	  session.commit();
	  session.close();
	  return res;
  }
  //스케줄 최신화
  public static int newSchedule(int maxTerm,int timeNum,String theater,int theaterNum){
	  SqlSession session = sqlMapper.openSession();
	  Map<String,Object> map = new HashMap();
	  map.put("maxTerm", maxTerm);
	  map.put("timeNum", timeNum);
	  map.put("theater", theater);
	  map.put("theaternum", theaterNum);
	  int res = session.insert("newSchedule", map);
	  session.commit();
	  session.close();
	  return res;
  }
  
  //스케줄 TIME
  public static List listScheduleTime(){
	  SqlSession session = sqlMapper.openSession();
	  List list = null;
	  list = session.selectList("listScheduleTime");
	  session.close();
	  return list;
  }
  public static String maxTerm(){
	  SqlSession session = sqlMapper.openSession();
	  
	  String res = session.selectOne("maxTerm");
	  return res;
  }
}
