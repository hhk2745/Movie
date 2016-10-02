package client.reserve.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import admin.movie.db.MovieDAO;
import admin.movie.db.Movie_infoDTO;
import admin.schedule.db.ScheduleDAO;
import client.reserve.db.MovieSelectDTO;
import client.reserve.db.TicketDAO;
import client.reserve.db.TicketDTO;
import member.db.MemberDAO;
import member.db.MemberDTO;

@Controller
public class MovieReserveController {
	@Autowired
	private MovieDAO movieDAO;
	@Autowired
	private ScheduleDAO admin_scheduleDAO;
	@Autowired
	private TicketDAO ticketDAO;
	@Autowired
	private MemberDAO memberDAO;


	@RequestMapping(value = "/client_movieReserve.do")
	public ModelAndView movieReserve(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		
/*		  List list = movieDAO.getList("now"); 
		  ModelAndView mav = new ModelAndView(); 
		  
		  mav.addObject("movieList",list);
 */
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
  	  	SimpleDateFormat format2 = new SimpleDateFormat("20yy");
  	  
	//	List<Movie_infoDTO> list = movieDAO.getList("now");
  	  List<Movie_infoDTO> list = ticketDAO.getMovieList();
		 
		for(Iterator it = list.iterator();it.hasNext();){
			Movie_infoDTO dto = (Movie_infoDTO)it.next();
			String date = format2.format(format1.parse(dto.getOpendate()));
			  String str = dto.getTitle()+"("+date+")";
			  dto.setFile_directory(str);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("movieList",list);
//		mav.addObject("upPath",req.getSession().getServletContext().getRealPath("/poster/"));
		mav.setViewName("WEB-INF/reserve/movieChoice.jsp");

		return mav;

	}

	@RequestMapping(value = "/client_theaterReserve.do")
	public ModelAndView theaterReserve1(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// 현재 상영 지점은 하나이기 때문에 넘겨주기만 하면 됨
		String num = arg0.getParameter("num"); // 영화 num 값

		ModelAndView mav = new ModelAndView();
		// mav.setViewName("/client/reserve/theaterChoice.jsp?num="+num);

		mav.addObject("num", num);
		mav.setViewName("WEB-INF/reserve/theaterChoice.jsp");
		return mav;

	}

	@RequestMapping(value = "/client_ticketReserve.do")
	public ModelAndView ticketReserve(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// 영화 선택하고 ... 상영관 선택하고 ... (날짜 선택하고 ... 티켓수 설정하고) ... 좌석 선택하고 ... 좌석
		// 있는지 다시 확인하고 결제하기 하고 ....

		String numStr = arg0.getParameter("num"); // 영화 num
		String theater = arg0.getParameter("theater"); // 상영관 이름
		System.out.println();

		int num = Integer.parseInt(numStr);

		List<MovieSelectDTO> list = null;
		list = ticketDAO.MovieSelected(num);

		ModelAndView mav = new ModelAndView();
		
		if(list.size()==0){
			String msg="선택하신 영화는 현재 상영중이 아닙니다.";
			mav.addObject("msg",msg);
		}

		mav.addObject("scheduleList", list);
		
		mav.addObject("num", num);
		mav.addObject("theater", theater);

		mav.setViewName("WEB-INF/reserve/timeChoice.jsp");

		return mav;

	}

	@RequestMapping(value = "/client_chairReserve.do")
	public ModelAndView chairReserve(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String num = arg0.getParameter("num"); // 영화 넘버값
		String theater = arg0.getParameter("theater"); // 강남점
		String theaternum = arg0.getParameter("theaternum");
		String time = arg0.getParameter("time"); // 시간대 (schedule_time)
		String day = arg0.getParameter("day");

		List allSitNum = null;
		allSitNum = ticketDAO.allSitNum();

		List<String> chkSitNum = null;
		chkSitNum = ticketDAO.chkSitNum(num, day, theaternum, time);

		List<String> spaceSitNum = allSitNum;

		for (int i = 0; i < spaceSitNum.size(); i++) {
			for (int j = 0; j < chkSitNum.size(); j++) {
				if (spaceSitNum.get(i).equals(chkSitNum.get(j))) {
					spaceSitNum.remove(i);

				}
			}
		}

		TreeMap<String, Integer> sit = new TreeMap<>();

		for (int i = 0; i < spaceSitNum.size(); i++) {
			sit.put(spaceSitNum.get(i), 0);
		}
		for (int i = 0; i < chkSitNum.size(); i++) {
			sit.put(chkSitNum.get(i), 1);
		}

		HttpSession session = arg0.getSession();
		MemberDTO mdto = (MemberDTO) session.getAttribute("loginId"); 
		
		Calendar now = Calendar.getInstance();
		
		String ssn = mdto.getSsn();
		String yy = now.get(Calendar.YEAR)+"";
		int age = (100+Integer.parseInt(yy.substring(2, 4)))-Integer.parseInt(mdto.getSsn().substring(0,2));
		System.out.println(age);
		
		
		Movie_infoDTO movieDTO = movieDAO.getMovie(Integer.parseInt(num));
		System.out.println(movieDTO.getGrade());
		if(movieDTO.getGrade()>age){
			String msg = "연령 제한이 있는 영화입니다.";
			mav.addObject("msg", msg);
		}
		System.out.println(movieDTO.getGrade()>age);
		
		if(movieDTO.getGrade()>17){
			String adult="adult";
			mav.addObject("adult",adult);
		}
		
		mav.addObject("num", num);
		mav.addObject("theater", theater);
		mav.addObject("theaternum", theaternum);
		mav.addObject("time", time);
		mav.addObject("day", day);

		mav.addObject("sit", sit);
		mav.addObject("logIn",mdto);
		mav.addObject("upPath",arg0.getSession().getServletContext().getRealPath("/sitImg"));
		mav.setViewName("WEB-INF/reserve/sitChoice.jsp");

		return mav;

	}

	@RequestMapping(value = "/client_cashReserve.do")
	public ModelAndView cashReserve(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {

		String num = arg0.getParameter("num"); // 영화 넘버값
		String theater = arg0.getParameter("theater"); // 강남점
		String theaternum = arg0.getParameter("theaternum");
		String time = arg0.getParameter("time"); // 시간대 (schedule_time)
		String day = arg0.getParameter("day");
		String adultCount = arg0.getParameter("adultCount");
		String childCount = arg0.getParameter("childCount");
		String sit = arg0.getParameter("sit");

		int total = Integer.parseInt(adultCount) * 8000 + Integer.parseInt(childCount) * 7000;
		int count = Integer.parseInt(adultCount) + Integer.parseInt(childCount);
		ModelAndView mav = new ModelAndView();

		mav.addObject("total", total);

		TicketDTO dto = ticketDAO.chkTicket(num, day, theaternum, time);
		// TicketDTO dto = new TicketDTO();
		
		HttpSession session = arg0.getSession();
		MemberDTO mdto = (MemberDTO) session.getAttribute("loginId"); 
		
		dto.setId(mdto.getId()); // session에서 받아오기
		dto.setPrice(total);
		dto.setTime(time);
		dto.setSitnum(sit);

		mav.addObject("name" , mdto.getName());
		mav.addObject("num", num);
		mav.addObject("count", count);
		mav.addObject("adultCount", adultCount);
		mav.addObject("childCount", childCount);
		mav.addObject("ticketChkdto", dto);
		mav.setViewName("WEB-INF/reserve/cash.jsp");

		return mav;

	}

	@RequestMapping(value = "/client_reserve_success.do")
	public ModelAndView successReserve(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
	

		String num = arg0.getParameter("num");
		String title = arg0.getParameter("title"); // 영화 넘버값
		String theater = arg0.getParameter("theater"); // 강남점
		String theaternum = arg0.getParameter("theaternum");
		String time = arg0.getParameter("time"); // 시간대 (schedule_time)
		String day = arg0.getParameter("day");
		String count = arg0.getParameter("count");
		String adultCount = arg0.getParameter("adultCount");
		String childCount = arg0.getParameter("childCount");
		String sit = arg0.getParameter("sit");

		HttpSession session = arg0.getSession();
		MemberDTO mdto = (MemberDTO) session.getAttribute("loginId"); 

		String[] sitStr = sit.split("[,]");

		

		int totalcount = Integer.parseInt(count); // 5
		int acount = Integer.parseInt(adultCount); // 3 str[0 1 2]
		int ccount = Integer.parseInt(childCount); // 2 str[3 4]

		int pay = acount* 8000 +  ccount*7000;
		System.out.println(pay);
		Boolean ChkStr = false;
		ChkStr = ticketDAO.chkSitNumOne(num, day, theaternum, time, sitStr);
		
		System.out.println(ChkStr);
		
		if(ChkStr == false && mdto.getMoney()>=pay){
			System.out.println("추가하기");
			List<TicketDTO> listDTO = new ArrayList<>();
			TicketDTO dto;
			for (int i = 0; i < acount; i++) {	// 어른 표 
				dto = new TicketDTO();
				dto.setDay(day);
				dto.setId(mdto.getId());
				dto.setTheater("서울_강남");
				dto.setTheaternum(Integer.parseInt(theaternum));
				dto.setTime(time);// 타임 스케쥴타임으로 넘버값받아서 넣기
				dto.setTitle(title);
				dto.setPoint(0);
				dto.setChk("true");
				dto.setPrice(8000);
				dto.setPay(8000);
				dto.setSitnum(sitStr[i]);
				dto.setAge("20");
				listDTO.add(dto);
			}
			for (int i = 0; i < ccount; i++) {	// 청소년 표 
				dto = new TicketDTO();
				dto.setDay(day);
				dto.setId(mdto.getId());
				dto.setTheater("서울_강남");
				dto.setTheaternum(Integer.parseInt(theaternum));
				dto.setTime(time);// 타임 스케쥴타임으로 넘버값받아서 넣기
				dto.setTitle(title);
				dto.setPoint(0);
				dto.setChk("true");
				dto.setPrice(7000);
				dto.setPay(7000);
				dto.setSitnum(sitStr[acount + i]);
				dto.setAge("15");
				listDTO.add(dto);
			}
			
			System.out.println("돈 -- ");
			int res = ticketDAO.downMoney(mdto.getId(), pay);
			int pointRes=0;
			if(res>0){
				pointRes =  memberDAO.upPoint(mdto.getId(),Integer.parseInt(count));
			}
			
			if(pointRes>0){
				System.out.println("포인트 1000이 추가되었습니다.");
			}else{
				System.out.println("포인트 추가실패!!");
			}
			
			System.out.println("res" +res);
			System.out.println(mdto.getId()+ " / " + pay);
			ticketDAO.insertTicket(listDTO);
			
			String id = mdto.getId();
			String pw = mdto.getPw();
			MemberDTO memberDTO = null;
			try {
				memberDTO = memberDAO.getMember(id, pw);
				System.out.println(memberDTO.getId()+"/"+memberDTO.getMoney());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.removeAttribute("loginId");
			session.setAttribute("loginId", memberDTO);
			
			
			int res1 = ticketDAO.watchCountUp(num, count);
			int res2 = ticketDAO.downSpaceSit(day, time, theaternum, count); 
			System.out.println("추가완료");
			mav.setViewName("member_MyPage.do?mode=myTicket");
			
		}
		else if(mdto.getMoney()>=pay){
			System.out.println("ㅠㅠ");
			String msg = "이미 예약이 완료된 좌석을 선택하셨습니다. ";
			mav.addObject("msg",msg);
			mav.setViewName("index.jsp");
		}
		else if(ChkStr == false){
			System.out.println("ㅠㅠ");
			String msg = "잔액이 부족합니다 ";
			mav.addObject("msg",msg);
			mav.setViewName("index.jsp");
			
		}
		
		

		return mav;

	}
	@RequestMapping(value="/client_theater.do")
	   public ModelAndView client_theater(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception{
	      return new ModelAndView("/client/client_theater.jsp");
	   }
	
}
