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
public class MemberSerchIDController
{
	@Autowired
	private MemberDAO memberDAO;

	@RequestMapping(value = "/member_SearchID.do", method = RequestMethod.GET)
	public ModelAndView memberJoinCheckForm(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception
	{
		// TODO Auto-generated method stub
		return new ModelAndView("WEB-INF/member/memberSerchIDForm.jsp");
	}

	@RequestMapping(value = "/member_SearchID.do", method = RequestMethod.POST)
	public ModelAndView memberJoinCheckPro(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		MemberDTO dto = memberDAO.serchID(name, email);

		if (dto != null)
		{//검색 성공, 로그인창에서 alert
			mav.setViewName("WEB-INF/member/memberLoginForm.jsp?mode=serchID");
			mav.addObject("serchID", dto);
		}else
		{//검색 실패, 로그인창에서 alert
			mav.setViewName("WEB-INF/member/memberLoginForm.jsp?mode=serchID");
		}
		return mav;
	}

}
