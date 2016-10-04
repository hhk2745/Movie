package qnaboard.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import qnaboard.db.QNABoardDTO;
/**
 * This is not a best practices class. It's just an example to give you an idea
 * of how iBATIS works. For a more complete example, see JPetStore 5.0 at
 * http://www.ibatis.com.
 */
public class SimpleExample {

	/**
	 * SqlMapClient instances are thread safe, so you only need one. In this
	 * case, we'll use a static singleton. So sue me. ;-)
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
	
	public static void insertBoard(HashMap map){
		SqlSession session = sqlMapper.openSession();
		session.insert("QNAinsertBoard", map);
		session.commit();
		session.close();
	}

	public static int getCount(String id){
		SqlSession session = sqlMapper.openSession();
		int count = 0;
		
		count = session.selectOne("QNAgetCount", id);
		session.close();
		return count;
	}

	public static List listBoard(HashMap map) {
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("QNAlistBoard", map);
		session.close();
		return list;
	}
	
	public static QNABoardDTO getBoard(int num){
		SqlSession session = sqlMapper.openSession();
		QNABoardDTO dto = (QNABoardDTO) session.selectOne("QNAgetBoard", num);
		session.close();
		return dto;
	}
	
	public static void upCount(int num){
		SqlSession session = sqlMapper.openSession();
		session.update("QNAupCount", num);
		session.commit();
		session.close();
	}
	
	public static void deleteBoard(int num){
		SqlSession session = sqlMapper.openSession();
		session.delete("QNAdeleteBoard", num);
		session.commit();
		session.close();
	}
	
	public static void updateBoard(HashMap map){
		SqlSession session = sqlMapper.openSession();
		session.update("QNAupdateBoard", map);
		session.commit();
		session.close();
	}
	
	public static List getCategory(){
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("QNAgetCategory");
		session.close();
		return list;
	}
	
	public static void newStep(){
		SqlSession session = sqlMapper.openSession();
		session.update("newStep");
		session.commit();
		session.close();
	}

}
