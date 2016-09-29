package admin.sell.mybatis;

import com.ibatis.common.resources.Resources;

import java.io.Reader;
import java.io.IOException;

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

	public static int countingMonth(String date) {
		int count = 0;
		System.out.println("chk1");
		SqlSession session = sqlMapper.openSession();
		count = session.selectOne("countingMonth", date);
		session.close();
		System.out.println("count 1 : " + count);
		return count;
	}

	public static int countingYear(String date) {
		int count = 0;
		SqlSession session = sqlMapper.openSession();
		count = session.selectOne("countingYear", date);
		session.close();
		return count;
	}

	public static int countingMovies(String title) {
		int count = 0;
		SqlSession session = sqlMapper.openSession();
		count = session.selectOne("countingMovies", title);
		session.close();
		return count;
	}

}
