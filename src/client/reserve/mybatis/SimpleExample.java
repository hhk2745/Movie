package client.reserve.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.*;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import client.reserve.db.TicketDTO;

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

	public static int insertTicket(List<TicketDTO> listDTO) {
		SqlSession session = sqlMapper.openSession();
		int res = 0;

		for (int i = 0; i < listDTO.size(); i++) {
			res = session.insert("insertTicket", listDTO.get(i));
		}
		session.commit();
		session.close();
		return res;
	}

	public static int deleteTicket(int num) {
		SqlSession session = sqlMapper.openSession();
		int res = 0;
		res = session.delete("deleteTicket", num);
		session.commit();
		session.close();
		return res;
	}

	public static List listTicket(String id) {
		SqlSession session = sqlMapper.openSession();
		List list = null;
		list = session.selectList("listTicket_id", id);
		session.close();
		return list;
	}
	public static List listTicketDelCant(String id) {
		SqlSession session = sqlMapper.openSession();
		List list = null;
		list = session.selectList("listTicket_idDelCant", id);
		session.close();
		return list;
	}
	public static TicketDTO getTicket(String num){
		SqlSession session = sqlMapper.openSession();
		TicketDTO dto = (TicketDTO)session.selectOne("getTicket",num);
		session.close();
		return dto;
	}

	/*
	 * public static List listTicket(String title, String day, int time) {
	 * SqlSession session = sqlMapper.openSession(); List list = null;
	 * HashMap<String, String> map = new HashMap<>(); map.put("title", title);
	 * map.put("day", day); map.put("time", time+""); list =
	 * session.selectList("listTicket_title", map); session.close(); return
	 * list; }
	 */
	public static List movieSelected(int num) {
		SqlSession session = sqlMapper.openSession();
		List list = null;
		list = session.selectList("movieSelected", num);
		session.close();
		return list;
	}

	public static List chkSitNum(String num, String day, String theaternum, String time) {
		SqlSession session = sqlMapper.openSession();
		HashMap<String, String> chkmap = new HashMap<>();
		chkmap.put("num", num);
		chkmap.put("day", day);
		chkmap.put("theaternum", theaternum);
		chkmap.put("time", time);

		List list = null;
		list = session.selectList("chkSitNum", chkmap);

		session.close();
		return list;
	}

	public static List allSitNum() {
		SqlSession session = sqlMapper.openSession();
		List list = null;
		list = session.selectList("allSitNum");
		session.close();
		return list;
	}

	public static TicketDTO chkTicket(String num, String day, String theaternum, String time) {
		SqlSession session = sqlMapper.openSession();
		HashMap<String, String> chkonemap = new HashMap<>();
		chkonemap.put("num", num);
		chkonemap.put("day", day);
		chkonemap.put("theaternum", theaternum);
		chkonemap.put("time", time);

		TicketDTO dto = session.selectOne("chkOne", chkonemap);

		session.close();
		return dto;
	}

	public static int watchCountUp(String num, String count) {
		/*
		 * Map<String, String>wcmap = new HashMap<String,String>();
		 * wcmap.put("num", num); wcmap.put("count", count);
		 * 
		 * System.out.println(wcmap.get("num"));
		 * System.out.println(wcmap.get("count"));
		 */

		SqlSession session = sqlMapper.openSession();
		HashMap<String, Integer> wcmap = new HashMap<String, Integer>();
		wcmap.put("num", Integer.valueOf(num));
		wcmap.put("count", Integer.valueOf(count));

		int res = session.update("WCUp", wcmap);
		session.commit();
		session.close();

		return res;
	}

	public static int downSpaceSit(String day, String time, String theaternum, String count) {
		SqlSession session = sqlMapper.openSession();
		HashMap<String, String> dss = new HashMap<>();
		dss.put("day", day);
		dss.put("time", time);
		dss.put("theaternum", theaternum);
		dss.put("count", count);

		int res = session.update("dss", dss);
		session.commit();
		session.close();
		return res;
	}

	public static Boolean chkSitNumOne(String num, String day, String theaternum, String time, String[] sitnum) {
		SqlSession session = sqlMapper.openSession();
		HashMap<String, String> chkonemap;
		Boolean chk = false;
		
		for (int i = 0; i < sitnum.length; i++) {
			String strOne = "";
			System.out.println("strOne" + strOne);
			chkonemap = new HashMap<>();
			chkonemap.put("num", num);
			chkonemap.put("day", day);
			chkonemap.put("theaternum", theaternum);
			chkonemap.put("time", time);
			chkonemap.put("sitnum", sitnum[i]);
			strOne = session.selectOne("chkoneticket", chkonemap);
			System.out.println("strOne2"+strOne );
			if(sitnum[i].equals(strOne)){
				chk=true;
				break;
			}
		}
		
		session.close();
		return chk;
	}
	
	
	public static int watchCountDown(String title) {
		SqlSession session = sqlMapper.openSession();
		
		int res = session.update("wcd",title);
		session.close();
		return res;
	}

	public static int upSpaceSit(String day, String time, String theaternum) {
		SqlSession session = sqlMapper.openSession();
		HashMap<String, String> uss = new HashMap<>();
		uss.put("day", day);
		uss.put("time", time);
		uss.put("theaternum", theaternum);
		
		int res = session.update("uss", uss);
		session.commit();
		session.close();
		
		return res;
	}
	
	public static int upMoney(String id, int pay) {
		SqlSession session = sqlMapper.openSession();
		HashMap<String, Object> up = new HashMap<>();
		
		up.put("id", id);
		up.put("pay", pay);
		int res = session.update("upMoney", up);
		session.commit();
		session.close();
		return res;
	}

	public static int downMoney(String id, int total) {
		SqlSession session = sqlMapper.openSession();
		HashMap<String, Object> down = new HashMap<>();
		down.put("id", id);
		down.put("total", total);
		System.out.println("simple  // id / pay  : "+down.get("id")+"/"+down.get("total"));
		int res = session.update("downMoney", down);
		session.commit();
		session.close();
		return res;
	}
	public static List getMovieList() {
		SqlSession session = sqlMapper.openSession();
		List list = null;
		list = session.selectList("getMovieList");
		session.close();
		return list;
	}

	
}
