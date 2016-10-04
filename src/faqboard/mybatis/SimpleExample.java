package faqboard.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import faqboard.db.FAQBoardDTO;

/**
 * This is not a best practices class.  It's just an example
 * to give you an idea of how iBATIS works.  For a more complete
 * example, see JPetStore 5.0 at http://www.ibatis.com.
 */
public class SimpleExample {

  /**
   * SqlMapClient instances are thread safe, so you only need one.
   * In this case, we'll use a static singleton.  So sue me.  ;-)
   */
  private static SqlSessionFactory sqlMapper;

  /**
   * It's not a good idea to put code that can fail in a class initializer,
   * but for sake of argument, here's how you configure an SQL Map.
   */
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
  
  public static List search(HashMap map){
	  SqlSession session = sqlMapper.openSession();
	  List list = session.selectList("FAQsearch", map);
	  session.close();
	  return list;
  }

  public static List listBoard(HashMap map){
	  SqlSession session = sqlMapper.openSession();
	  List list = session.selectList("FAQlistBoard", map);
	  session.close();
	  return list;

  }
  
  public static List allListBoard(HashMap map){
	  SqlSession session = sqlMapper.openSession();
	  List list = session.selectList("FAQallListBoard", map);
	  session.close();
	  return list;
  }

  public static FAQBoardDTO getBoard(int num){
	  SqlSession session = sqlMapper.openSession();
	  FAQBoardDTO dto = (FAQBoardDTO)session.selectOne("FAQgetBoard", num);
	  session.close();
	  return dto;

  }

  public static void insertBoard(HashMap map){
	  SqlSession session = sqlMapper.openSession();
	  session.insert("FAQinsertBoard", map);
	  session.commit();
	  session.close();
	 
  }

	public static void deleteBoard(int num) {
		SqlSession session = sqlMapper.openSession();
		  session.delete("FAQdeleteBoard", num);
		  session.commit();
		  session.close();
		
	}
	
	public static int searchGetCount(String search){
		SqlSession session = sqlMapper.openSession();
		int count = session.selectOne("FAQsearchGetCount", search);
		session.close();
		return count;
	}
	
	public static int allGetCount(){
		SqlSession session = sqlMapper.openSession();
		int count = session.selectOne("FAQallGetCount");
		session.close();
		return count;
	}
	
	public static int getCount(String mode) {
		SqlSession session = sqlMapper.openSession();
		int count = session.selectOne("FAQgetCount", mode);
		session.close();
		return count;
	}
	
	public static void readCountBoard(int num) {
		SqlSession session = sqlMapper.openSession();
		session.update("FAQreadCount", num);
		session.commit();
		session.close();
	}
	
	public static void updateBoard(FAQBoardDTO dto) {
		SqlSession session = sqlMapper.openSession();
		session.update("FAQupdateBoard", dto);
		session.commit();
		session.close();
		
	}
  
	public static void upCount(int num){
		SqlSession session = sqlMapper.openSession();
		session.update("FAQupCount", num);
		session.commit();
		session.close();
	}
	
	public static List getCategory(){
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("FAQgetCategory");
		session.close();
		return list;
	}
	
	public static void newStep(){
		SqlSession session = sqlMapper.openSession();
		session.update("FAQnewStep");
		session.commit();
		session.close();
	}
	
	public static void stepUpdate(){
		SqlSession session = sqlMapper.openSession();
		session.update("FAQstepUpdate");
		session.commit();
		session.close();
	}
}
