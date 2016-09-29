package member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import member.db.MemberDAO;

@Controller
public class AdminMemberDeleteController
{
	@Autowired
	private MemberDAO memberDAO;
	
	@RequestMapping(value = "/admin_member_delete.do", method = RequestMethod.GET)
	public ModelAndView admin_member_delete(HttpServletRequest req, HttpServletResponse resp)
	{
		System.out.println("AdminMemberDeleteController req.getparameter(num) : "+req.getParameter("num"));
		ModelAndView mav = new ModelAndView();
		boolean result = false;
		String url = "/admin_member.do";
		int res = 0;
		try
		{
			res = memberDAO.deleteMember(Integer.parseInt(req.getParameter("num")));
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (res != 0)
		{
			result = true;
		}
		mav.addObject("deleteResult", result);
		
		mav.setViewName(url);
		return mav;
	}

}
