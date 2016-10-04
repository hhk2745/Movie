package client.reserve.db;

import java.util.List;

public interface TicketDAO
{
	public int insertTicket(List<TicketDTO> listDTO); // 예매하기 했을 때

	public int deleteTicket(int num); // 예매 취소시

	public List listTicket(String id); // 회원아이디로 예매리스트

	public List listTicketDelCant(String id);

	public TicketDTO getTicket(String num);

	// public List listTicket(String title, String day, int time); // 영화제목, 날짜 ,
	// 시간대 로 예매 리스트
	public List MovieSelected(int num);

	public List chkSitNum(String num, String day, String theaternum, String time);

	public Boolean chkSitNumOne(String num, String day, String theaternum, String time, String[] sitnum);

	public List allSitNum();

	public TicketDTO chkTicket(String num, String day, String theaternum, String time);

	public int watchCountUp(String num, String count);

	public int downSpaceSit(String day, String time, String theaternum, String count);

	public int watchCountDown(String title);

	public int upSpaceSit(String day, String time, String theaternum);

	public int upMoney(String id, int pay);

	public int downMoney(String id, int total);

	public List getMovieList();
}
