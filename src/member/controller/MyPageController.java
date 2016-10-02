package member.controller;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import client.reserve.db.TicketDAO;
import client.reserve.db.TicketDTO;
import member.db.MemberDAO;
import member.db.MemberDTO;

@Controller
public class MyPageController
{
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private TicketDAO ticketDAO;

	ModelAndView mav = null;

	@RequestMapping(value = "/member_MyPage.do", method = RequestMethod.GET)
	public ModelAndView memberMyPageForm(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		return getCommandFactory(req, resp);
	}

	@RequestMapping(value = "/member_MyPage.do", method = RequestMethod.POST)
	public ModelAndView memberMyPagePro(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		return postCommandFactory(req, resp);
	}

	/* ==========================Get CommandFactory========================== */
	public ModelAndView getCommandFactory(HttpServletRequest req, HttpServletResponse resp)
	{
		if (req.getParameter("mode").equals("myPageMain"))
		{
			mav = myPageMain(req, resp);
		} else if (req.getParameter("mode").equals("myTicket"))
		{
			mav = myTicket(req, resp);
		} else if (req.getParameter("mode").equals("myPoint"))
		{
			mav = myPoint(req, resp);
		} else if (req.getParameter("mode").equals("myMoney"))
		{
			mav = myMoney(req, resp);
		} else if (req.getParameter("mode").equals("myInfo"))
		{
			mav = myInfo(req, resp);
		} else if (req.getParameter("mode").equals("myProfile"))
		{
			mav = myProfile(req, resp);
		} else if (req.getParameter("mode").equals("myQuestion"))
		{
			mav = myQuestion(req, resp);
		} else if (req.getParameter("mode").equals("dropOut"))
		{
			mav = myDropOut(req, resp);
		}

		Calendar cal = Calendar.getInstance();
		mav.addObject("year", cal.get(Calendar.YEAR));

		return mav;
	}

	/*
	 * ==========================Post CommandFactory==========================
	 */
	public ModelAndView postCommandFactory(HttpServletRequest req, HttpServletResponse resp)
			throws NumberFormatException, SQLException
	{

		if (req.getParameter("mode").equals("myPageMain"))
		{
			mav = myPageMainPro(req, resp);
		} else if (req.getParameter("mode").equals("myTicket"))
		{
			mav = myTicketPro(req, resp);
		} else if (req.getParameter("mode").equals("myPoint"))
		{
			mav = myPointPro(req, resp);
		} else if (req.getParameter("mode").equals("myMoney"))
		{
			mav = myMoneyPro(req, resp);
		} else if (req.getParameter("mode").equals("myInfoPwCheck"))
		{// 개인정보 변경 전 패스워드
			mav = myInfoPwCheck(req, resp);
		} else if (req.getParameter("mode").equals("myInfo"))
		{// 개인정보 변경
			mav = myInfoPro(req, resp);
		} else if (req.getParameter("mode").equals("myProfile"))
		{
			mav = myProfilePro(req, resp);
		} else if (req.getParameter("mode").equals("myQuestion"))
		{
			mav = myQuestionPro(req, resp);
		} else if (req.getParameter("mode").equals("dropOut"))
		{
			mav = myDropOutPro(req, resp);
		}

		Calendar cal = Calendar.getInstance();
		mav.addObject("year", cal.get(Calendar.YEAR));

		return mav;
	}

	/* ==========================Get Method========================== */

	public ModelAndView myPageMain(HttpServletRequest req, HttpServletResponse resp)
	{

		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyPage.jsp");
		String upPath = req.getServletContext().getRealPath("/profile_img/"); // 프로필사진
		mav.addObject("upPath", upPath);
		return mav;

	}

	public ModelAndView myTicket(HttpServletRequest req, HttpServletResponse resp)
	{
		HttpSession session = req.getSession();
		MemberDTO mdto = (MemberDTO) session.getAttribute("loginId"); 
		List<TicketDTO> list = ticketDAO.listTicket(mdto.getId());
		List<TicketDTO> listDC = ticketDAO.listTicketDelCant(mdto.getId());
		
		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyTicket.jsp");
		mav.addObject("listTicket",list);
		mav.addObject("listTicketDC",listDC);
		return mav;

	}


@RequestMapping(value = "/myTicketDelete.do")
	public ModelAndView TicketDelete(HttpServletRequest req, HttpServletResponse resp)
	{
	String num = req.getParameter("num");
	TicketDTO dto = ticketDAO.getTicket(num);
	
	
	HttpSession session = req.getSession();
	MemberDTO dto1 = (MemberDTO)session.getAttribute("loginId");
	String pw = dto1.getPw();
	String id = dto1.getId();
			
	int res = ticketDAO.watchCountDown(dto.getTitle());
	int res1 = ticketDAO.upSpaceSit(dto.getDay(), dto.getTime(), dto.getTheaternum()+""); 
	ticketDAO.upMoney(dto.getId(),dto.getPay());
	ticketDAO.deleteTicket(Integer.parseInt(num));

	MemberDTO memberDTO = null;
	try {
		memberDTO = memberDAO.getMember(id, pw);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	session.setAttribute("loginId", memberDTO);
	ModelAndView mav = new ModelAndView("member_MyPage.do?mode=myTicket");
	return mav;

	}
	public ModelAndView myPoint(HttpServletRequest req, HttpServletResponse resp)
	{

		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyPoint.jsp");
		String upPath = req.getServletContext().getRealPath("/profile_img/"); // 프로필사진
		mav.addObject("upPath", upPath);
		return mav;

	}

	public ModelAndView myMoney(HttpServletRequest req, HttpServletResponse resp)
	{

		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyMoney.jsp");
		String upPath = req.getServletContext().getRealPath("/profile_img/"); // 프로필사진
		mav.addObject("upPath", upPath);
		return mav;

	}

	public ModelAndView myInfo(HttpServletRequest req, HttpServletResponse resp)
	{

		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyInfo.jsp");
		String upPath = req.getServletContext().getRealPath("/profile_img/"); // 프로필사진
		mav.addObject("upPath", upPath);
		return mav;

	}

	public ModelAndView myProfile(HttpServletRequest req, HttpServletResponse resp)
	{

		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyProfile.jsp");
		String upPath = req.getServletContext().getRealPath("/profile_img/"); // 프로필사진
		mav.addObject("upPath", upPath);
		return mav;

	}

	public ModelAndView myQuestion(HttpServletRequest req, HttpServletResponse resp)
	{

		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyQuestion.jsp");
		String upPath = req.getServletContext().getRealPath("/profile_img/"); // 프로필사진
		mav.addObject("upPath", upPath);
		return mav;

	}

	public ModelAndView myDropOut(HttpServletRequest req, HttpServletResponse resp)
	{
		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyDropOut.jsp");

		return mav;
	}

	/* ==========================Post Method========================== */

	public ModelAndView myPageMainPro(HttpServletRequest req, HttpServletResponse resp)
	{

		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyPage.jsp");

		return mav;

	}

	public ModelAndView myTicketPro(HttpServletRequest req, HttpServletResponse resp)
	{

		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyPage.jsp");

		return mav;

	}

	public ModelAndView myPointPro(HttpServletRequest req, HttpServletResponse resp)
	{

		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyPage.jsp");

		return mav;

	}

	public ModelAndView myMoneyPro(HttpServletRequest req, HttpServletResponse resp)
	{

		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyPage.jsp");

		return mav;

	}

	public ModelAndView myInfoPwCheck(HttpServletRequest req, HttpServletResponse resp)
			throws NumberFormatException, SQLException
	{
		// 개인정보 변경 전 PwCheck
		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyInfoUpdateForm.jsp");
		MemberDTO dto = memberDAO.getMemberAdmin(Integer.parseInt(req.getParameter("memberNum")));
		mav.addObject("dto", dto);
		return mav;
	}

	public ModelAndView myInfoPro(HttpServletRequest req, HttpServletResponse resp)
			throws NumberFormatException, SQLException
	{
		// 개인정보 변경 controller
		// mail. pw, name
		String email = req.getParameter("email");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyPage.jsp");
		MemberDTO dto = memberDAO.getMemberAdmin(Integer.parseInt(req.getParameter("memberNum")));
		dto.setEmail(email);
		dto.setPw(pw);
		dto.setName(name);
		int res = memberDAO.updateMember(dto);
		if (res > 0)
		{//성공
			mav.setViewName("index.jsp");
			mav.addObject("memberInfoUpdateResult", true);
			HttpSession session = req.getSession();
			session.invalidate();
		}

		return mav;

	}

	public ModelAndView myProfilePro(HttpServletRequest req, HttpServletResponse resp)
	{

		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyPage.jsp");
		// 처리해
		return mav;

	}

	public ModelAndView myQuestionPro(HttpServletRequest req, HttpServletResponse resp)
	{

		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyPage.jsp");

		return mav;

	}

	public ModelAndView myDropOutPro(HttpServletRequest req, HttpServletResponse resp)
			throws NumberFormatException, SQLException
	{

		ModelAndView mav = new ModelAndView();
		String initPw = req.getParameter("initPw");

		int res = memberDAO.deleteMember(Integer.parseInt(req.getParameter("memberNum")));

		if (res > 0)
		{
			mav.addObject("dropOutResult", true);
			HttpSession session = req.getSession();
			session.invalidate();
			mav.setViewName("index.jsp");
		} else
		{
			mav.addObject("dropOutResult", false);
			mav.setViewName("redirect:member_MyPage.do");
		}
		return mav;
	}
}
