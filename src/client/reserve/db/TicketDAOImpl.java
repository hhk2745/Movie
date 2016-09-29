package client.reserve.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import client.reserve.mybatis.SimpleExample;

public class TicketDAOImpl implements TicketDAO{

	@Override
	public int insertTicket(List<TicketDTO> listDTO) {
		// TODO Auto-generated method stub
		int res = SimpleExample.insertTicket(listDTO);
		return res;
	}

	@Override
	public int deleteTicket(int num) {
		// TODO Auto-generated method stub
		int res = SimpleExample.deleteTicket(num);
		return res;
	}

	@Override
	public List listTicket(String id) {
		// TODO Auto-generated method stub
		List list = SimpleExample.listTicket(id);
		return list;
	}


	@Override
	public List listTicketDelCant(String id) {
		// TODO Auto-generated method stub
		List list = SimpleExample.listTicketDelCant(id);
		return list;
	}
	public TicketDTO getTicket(String num){
		TicketDTO dto = (TicketDTO)SimpleExample.getTicket(num);
		return dto;
	}
/*	@Override
	public List listTicket(String title, String day, int time) {
		// TODO Auto-generated method stub
		List list = SimpleExample.listTicket(title, day, time);
		return list;
	}
*/
	@Override
	public List MovieSelected(int num) {
		// TODO Auto-generated method stub
		List list = SimpleExample.movieSelected(num);
		
		return list;
	}

	@Override
	public List chkSitNum(String num, String day, String theaternum, String time) {
		// TODO Auto-generated method stub
		List list = SimpleExample.chkSitNum(num, day, theaternum, time);
		return list;
	}

	@Override
	public List allSitNum() {
		// TODO Auto-generated method stub
		List list = SimpleExample.allSitNum();
		return list;
	}

	@Override
	public TicketDTO chkTicket(String num, String day, String theaternum, String time) {
		// TODO Auto-generated method stub
		TicketDTO dto = SimpleExample.chkTicket(num, day, theaternum, time);
		return dto;
	}

	@Override
	public int watchCountUp(String num , String count) {
		// TODO Auto-generated method stub
	
		int res = SimpleExample.watchCountUp(num, count);
		return res;
		
	}

	@Override
	public int downSpaceSit(String day, String time, String theaternum, String count) {
		// TODO Auto-generated method stub
		int res = SimpleExample.downSpaceSit(day,time,theaternum, count);
		return res;
	}

	@Override
	public Boolean chkSitNumOne(String num, String day, String theaternum, String time, String[] sitnum) {
		// TODO Auto-generated method stub
		Boolean chk = false;
		chk=SimpleExample.chkSitNumOne(num, day, theaternum, time, sitnum);
		System.out.println(chk);
		return chk;
	}

	
	
	@Override
	public int watchCountDown(String title) {
		// TODO Auto-generated method stub
		int res = SimpleExample.watchCountDown(title);
		return res;
	}

	@Override
	public int upSpaceSit(String day, String time, String theaternum) {
		// TODO Auto-generated method stub
		int res = SimpleExample.upSpaceSit(day,time,theaternum);
		return res;
	}

	@Override
	public int upMoney(String id, int pay) {
		// TODO Auto-generated method stub
		int res = SimpleExample.upMoney(id,pay);
		return res;
	}

	@Override
	public int downMoney(String id, int total) {
		// TODO Auto-generated method stub
		int res = SimpleExample.downMoney(id,total);
		return res;
	}

}
