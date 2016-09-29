package member.controller;

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
public class MemberIdCheckController
{

	@Autowired
	MemberDAO memberDAO;

	@RequestMapping(value = "/memberIdCheck.do", method =
	{ RequestMethod.GET, RequestMethod.POST })
	public ModelAndView memberIdCheck(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		String name = req.getParameter("name");
		String ssn = req.getParameter("ssn");
		String hp = req.getParameter("hp");
		ModelAndView mav = new ModelAndView();

		MemberDTO dto = memberDAO.idCheck(req.getParameter("id"));
		mav.setViewName("WEB-INF/member/memberJoinForm.jsp");
		
		System.out.println(req.getParameter("id"));
		
		if (dto == null)
		{// 등록가능
			mav.addObject("memberIdCheckResult", true);
		} else
		{// 등록실패
			mav.addObject("memberIdCheckResult", false);
		}
		mav.addObject("id", req.getParameter("id"));
		mav.addObject("name", name);
		mav.addObject("ssn", ssn);
		mav.addObject("hp", hp);
		
		return mav;
	}

}
