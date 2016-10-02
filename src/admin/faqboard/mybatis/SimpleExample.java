package admin.faqboard.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import admin.faqboard.db.AdminFAQBoardDTO;

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
  
  public static List admin_allListBoard(HashMap map){
	  SqlSession session = sqlMapper.openSession();
	  List list = session.selectList("admin_FAQallListBoard",map);
	  session.close();
	  return list;
  }

  public static List admin_listBoard(HashMap map){
	  SqlSession session = sqlMapper.openSession();
	  List list = session.selectList("admin_FAQlistBoard",map);
	  session.close();
	  return list;

  }

  public static AdminFAQBoardDTO admin_getBoard(int num){
	  SqlSession session = sqlMapper.openSession();
	  AdminFAQBoardDTO dto = (AdminFAQBoardDTO)session.selectOne("admin_FAQgetBoard", num);
	  session.close();
	  return dto;

  }

  public static void admin_insertBoard(HashMap map){
	  SqlSession session = sqlMapper.openSession();
	  session.insert("admin_FAQinsertBoard", map);
	  session.commit();
	  session.close();
	 
  }

	public static void admin_deleteBoard(int num) {
		SqlSession session = sqlMapper.openSession();
		  session.delete("admin_FAQdeleteBoard", num);
		  session.commit();
		  session.close();
		
	}
	
	public static int admin_getCount() {
		SqlSession session = sqlMapper.openSession();
		int count = 0;
		count = session.selectOne("admin_FAQgetCount");
		session.close();
		return count;
	}
	
	public static void admin_readCountBoard(int num) {
		SqlSession session = sqlMapper.openSession();
		session.update("admin_FAQreadCount", num);
		session.commit();
		session.close();
	}
	
	public static void admin_updateBoard(AdminFAQBoardDTO dto) {
		SqlSession session = sqlMapper.openSession();
		session.update("admin_FAQupdateBoard", dto);
		session.commit();
		session.close();
		
	}
  
	public static void admin_upCount(int num){
		SqlSession session = sqlMapper.openSession();
		session.update("admin_FAQupCount", num);
		session.commit();
		session.close();
	}
	
	public static List admin_getCategory(){
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("admin_FAQgetCategory");
		session.close();
		return list;
	}
	
	public static void admin_newStep(){
		SqlSession session = sqlMapper.openSession();
		session.update("admin_FAQnewStep");
		session.commit();
		session.close();
	}
	
	public static void admin_stepUpdate(int re_step){
		SqlSession session = sqlMapper.openSession();
		session.update("admin_FAQstepUpdate", re_step);
		session.commit();
		session.close();
	}
}
