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
public class MemberInsertController
{
	@Autowired
	private MemberDAO memberDAO;


	@RequestMapping(value = "/member_Insert.do", method = RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		MemberDTO dto = new MemberDTO();

		
		System.out.println(req.getParameter("name"));
		System.out.println(req.getParameter("idr"));
		System.out.println(req.getParameter("pw"));
		System.out.println(req.getParameter("ssn"));
		System.out.println(req.getParameter("email"));
		System.out.println(req.getParameter("hp"));

		dto.setName(req.getParameter("name"));
		dto.setId(req.getParameter("idr"));
		dto.setPw(req.getParameter("pw"));
		dto.setSsn(req.getParameter("ssn"));
		dto.setEmail(req.getParameter("email"));
		dto.setHp(req.getParameter("hp"));
		
		
		System.out.println(dto);
		
		memberDAO.insertMember(dto);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("WEB-INF/member/memberLoginForm.jsp");
		mav.addObject("insertResult", true);
		return mav;
	}

}
