package event.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import event.db.EventDTO;

public class SimpleExample
{

	private static SqlSessionFactory sqlMapper;
	static
	{
		try
		{
			Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException e)
		{
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}

	public static int insertEvent(EventDTO dto)
	{
		SqlSession session = sqlMapper.openSession();
		int res = session.insert("insertEvent", dto);
		session.commit();
		session.close();
		return res;
	}
	public static int deleteEvent(int num){
		SqlSession session = sqlMapper.openSession();
		int res = session.delete("deleteEvent",num);
		session.commit();
		session.close();
		
		return res;
	}
	public static int updateEvent(EventDTO dto){
		SqlSession session = sqlMapper.openSession();
		int res = session.update("updateEvent",dto);
		session.commit();
		session.close();
		
		return res;
	}
	
	public static List<EventDTO> getEvents()
	{
		SqlSession session = sqlMapper.openSession();
		List<EventDTO> list =  session.selectList("getEvents");
		session.close();
		return list;
	}
	
	public static EventDTO getEvent(int num){
		SqlSession session = sqlMapper.openSession();
		EventDTO dto = (EventDTO) session.selectOne("getEvent",num);
		session.close();
		return dto;
	}
	
	public static int getSeqCurrVal(){
		SqlSession session = sqlMapper.openSession();
		
		int res = session.selectOne("getSeqCurrVal");
		session.close();
		return res;
		
	}
	



}
