package fileboard.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import fileboard.db.FILEBoardDTO;

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

  public static List listBoard(HashMap map){
	  SqlSession session = sqlMapper.openSession();
	  List list = session.selectList("FILElistBoard",map);
	  session.close();
	  return list;
  }

  public static FILEBoardDTO getBoard(int num){
	  SqlSession session = sqlMapper.openSession();
	  FILEBoardDTO dto = (FILEBoardDTO)session.selectOne("FILEgetBoard", num);
	  session.close();
	  return dto;
  }

  public static void insertBoard(HashMap map){
	  SqlSession session = sqlMapper.openSession();
	  session.insert("FILEinsertBoard", map);
	  session.commit();
	  session.close();
	 
  }

	public static void deleteBoard(int num) {
		SqlSession session = sqlMapper.openSession();
		  session.delete("FILEdeleteBoard", num);
		  session.commit();
		  session.close();
		
	}
	
	public static int getCount() {
		SqlSession session = sqlMapper.openSession();
		int num = (int) session.selectOne("FILEgetCount");
		session.close();
		return num;
	}
	
	public static void readCountBoard(int num) {
		SqlSession session = sqlMapper.openSession();
		session.update("FILEreadCount", num);
		session.commit();
		session.close();
	}
	
	public static void updateBoard(HashMap map) {
		SqlSession session = sqlMapper.openSession();
		session.update("FILEupdateBoard", map);
		session.commit();
		session.close();
		
	}
	
	public static List searchBoard(String id){
		System.out.println(id);
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("FILEsearchBoard", id);
		if(list!=null){
			System.out.println("리스트 있어요!!");
		}
		session.close();
		return list;
	}
  
}
