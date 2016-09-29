package member.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import member.db.MemberDAO;
import member.db.MemberDTO;

@Controller
public class AdminMemberController
{

	@Autowired
	private MemberDAO memberDAO;
	// private TicketDAO or ReserveDAO;	

	@RequestMapping(value = "/admin_member.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView admin_member(HttpServletRequest req, HttpServletResponse resp) throws SQLException
	{
		ModelAndView mav = new ModelAndView();
		int pageSize = 10;
		int pageBlock = 3;
		
		String pageNum = req.getParameter("pageNum");
		
		if (pageNum == null)
		{
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		int startRow = pageSize * (currentPage - 1) + 1;
		int endRow = startRow + pageSize - 1;
		
		int count = 0;
		
		count = memberDAO.memberGetCount();
			
		if(endRow>count){
			endRow=count;
		}
		
		List list = memberDAO.listMember(startRow, endRow);
		
		
		mav.addObject("list", list);
		mav.addObject("pageSize", pageSize);
		mav.addObject("startPage", (currentPage-1)/ pageBlock*pageBlock+1);
		mav.addObject("pageBlock", pageBlock);
		mav.addObject("pageCount", count/pageSize+(count%pageSize==0 ? 0 : 1));
		
		mav.addObject("count", count);
		mav.addObject("currentPage", currentPage);

		mav.setViewName("admin/member/admin_member_list.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/admin_member_ticket.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView admin_member_ticket(HttpServletRequest req, HttpServletResponse resp) throws SQLException
	{
		ModelAndView mav = new ModelAndView();
		int pageSize = 10;
		int pageBlock = 3;
		
		String pageNum = req.getParameter("pageNum");
		
		if (pageNum == null)
		{
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		int startRow = pageSize * (currentPage - 1) + 1;
		int endRow = startRow + pageSize - 1;
		
		int count = 0;
		
		// ticket의 count를 구해야함
		// count = memberDAO.memberGetCount();
			
		if(endRow>count){
			endRow=count;
		}
		
		List list = memberDAO.listMember(startRow, endRow);
		
		
		mav.addObject("list", list);
		mav.addObject("pageSize", pageSize);
		mav.addObject("startPage", (currentPage-1)/ pageBlock*pageBlock+1);
		mav.addObject("pageBlock", pageBlock);
		mav.addObject("pageCount", count/pageSize+(count%pageSize==0 ? 0 : 1));
		
		mav.addObject("count", count);
		mav.addObject("currentPage", currentPage);

		mav.setViewName("admin/member/admin_member_ticket.jsp");
		return mav;
	}
	
	
	
	
		
		
	//not used
	@RequestMapping(value = "/admin_member_detail.do", method = RequestMethod.GET)
	public ModelAndView admin_member_detail(HttpServletRequest req, HttpServletResponse resp)
	{
		ModelAndView mav = new ModelAndView();

		MemberDTO dto = null;
		try
		{
			dto = memberDAO.getMemberAdmin(Integer.parseInt(req.getParameter("num")));
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mav.addObject("memberDTO", dto);
		mav.setViewName("/admin/member/admin_member_detail.jsp");
		return mav;
	}

	//not used
	@RequestMapping(value = "/admin_member_insert.do", method = RequestMethod.GET)
	public ModelAndView admin_member_insertForm(HttpServletRequest req, HttpServletResponse resp)
	{
		ModelAndView mav = new ModelAndView();

		mav.setViewName("/admin/member/admin_member_insert.jsp");
		return mav;
	}

}
