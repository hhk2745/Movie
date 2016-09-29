package member.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.db.MemberDTO;

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
			// Fail fast.
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}

	/* Client */
	public static MemberDTO checkMember(String name, String ssn, String hp)
	{
		SqlSession session = sqlMapper.openSession();
		HashMap<String, String> map = new HashMap<>();

		map.put("name", name);
		map.put("ssn", ssn);
		map.put("hp", hp);
		MemberDTO dto = (MemberDTO) session.selectOne("checkMember", map);
		session.close();
		return dto;
	}

	public static void insertMember(MemberDTO dto)
	{
		SqlSession session = sqlMapper.openSession();
		session.insert("insertMember", dto);
		session.commit();
		session.close();
	}

	public static MemberDTO getMember(String id, String pw)
	{
		SqlSession session = sqlMapper.openSession();
		HashMap<String, String> map = new HashMap<>();

		map.put("id", id);
		map.put("pw", pw);

		MemberDTO dto = (MemberDTO) session.selectOne("getMember", map);
		return dto;
	}

	/* Admin */

	public static int memberGetCount()
	{
		int res = 0;
		SqlSession session = sqlMapper.openSession();
		res = session.selectOne("memberGetCount");
		session.close();

		return res;
	}

	public static List listMember(int startRow, int endRow) throws SQLException
	{
		List list = null;
		SqlSession session = sqlMapper.openSession();
		HashMap<String, Integer> map = new HashMap();
		map.put("start", startRow);
		map.put("end", endRow);

		list = session.selectList("listMember", map);
		session.close();

		return list;
	}

	public static MemberDTO getMemberAdmin(int num) throws SQLException
	{
		MemberDTO dto = null;
		SqlSession session = sqlMapper.openSession();
		
		System.out.println("SimpleExample num : "+ num);
		dto = (MemberDTO) session.selectOne("getMemberAdmin", num);
		session.close();

		return dto;
	}

	public static int updateMember(MemberDTO dto) throws SQLException
	{
		int res = 0;
		SqlSession session = sqlMapper.openSession();
		res = session.update("updateMember", dto);

		session.commit();
		session.close();

		return res;
	}

	public static int deleteMember(int num) throws SQLException
	{
		int res = 0;
		SqlSession session = sqlMapper.openSession();
		res = session.delete("deleteMember", num);
		
		session.commit();
		session.close();
		
		return res;
	}
	
	
	public static MemberDTO serchID(String name, String email) throws SQLException
	{
		
		SqlSession session = sqlMapper.openSession();
		HashMap<String, String> map = new HashMap<>();
		map.put("name", name);
		map.put("email", email);
		
		MemberDTO dto = (MemberDTO) session.selectOne("serchID", map);
		session.close();
		return dto;
	}
	
	public static MemberDTO serchPW(String name, String id, String email) throws SQLException
	{
		SqlSession session = sqlMapper.openSession();
		HashMap<String, String> map = new HashMap<>();
		
		map.put("name", name);
		map.put("id", id);
		map.put("email", email);
		
		MemberDTO dto = (MemberDTO) session.selectOne("serchPW", map);
		
		session.close();
		return dto;
	}
	
	
	public static int approve(String id) throws SQLException
	{
		System.out.println("simpleExample id  : "+id);
		int res = -1;
		SqlSession session = sqlMapper.openSession();
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("approve", "ok");
		res = session.update("approve", map);
		session.commit();
		session.close();
		
		
		System.out.println("simpleExample res  : "+res);
		
		return res;
	}
	
	public static void insertMoney(MemberDTO dto){
		SqlSession session = sqlMapper.openSession();
		session.insert("insertMoney",dto);
		session.commit();
		session.close();
	}
	
	public static int updateNickname(String id, String nickname){
		SqlSession session = sqlMapper.openSession();
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("nickname", nickname);
		
		int res = -1;
		res = session.update("updateNickname", map);
		session.commit();
		session.close();
		return res;
	}
	
	public static int updateProfile_img(String id, String profile_img){
		SqlSession session = sqlMapper.openSession();
		
		Map<String, String>map = new HashMap<String, String>();
		map.put("id", id);
		map.put("profile_img", profile_img);
		
		int res=-1;
		res = session.update("updateProfile_img",map);
		session.commit();
		session.close();
		
		return res;
	}
	
	public static MemberDTO idCheck(String id){
		SqlSession session = sqlMapper.openSession();
		
		MemberDTO dto = (MemberDTO) session.selectOne("idCheck", id);
		
		return dto;
	}
	

}
