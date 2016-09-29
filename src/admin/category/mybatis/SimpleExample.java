package admin.category.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import admin.category.db.AdminCategoryDTO;

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
	
	public static List getCategory(){
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("cate_getCategory");
		session.close();
		return list;
	}

	public static List list(HashMap map) {
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("cate_list", map);
		session.close();
		return list;
	}

	public static void insert(String category_title) {
		SqlSession session = sqlMapper.openSession();
		session.insert("cate_insert", category_title);
		session.commit();
		session.close();
	}

	public static void delete(int category_num) {
		SqlSession session = sqlMapper.openSession();
		session.delete("cate_delete", category_num);
		session.commit();
		session.close();
	}

	public static int getCount() {
		SqlSession session = sqlMapper.openSession();
		int num = (int) session.selectOne("cate_getCount");
		session.close();
		return num;
	}

	public static void update(HashMap map) {
		SqlSession session = sqlMapper.openSession();
		session.update("cate_update", map);
		session.commit();
		session.close();
	}
	
	public static AdminCategoryDTO get(int category_num){
		SqlSession session = sqlMapper.openSession();
		AdminCategoryDTO dto = session.selectOne("cate_get", category_num);
		session.close();
		return dto;
	}

}
