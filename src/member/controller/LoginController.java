package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import member.db.MemberDAO;
import member.db.MemberDTO;

@Controller
public class LoginController
{
	@Autowired
	private MemberDAO memberDAO;

	@RequestMapping(value = "/member_Login.do", method = RequestMethod.GET)
	public ModelAndView memberLoginForm(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception
	{
		// System.out.println("MemberCheckController.java, GET");
		return new ModelAndView("WEB-INF/member/memberLoginForm.jsp");
	}

	@RequestMapping(value = "/member_Login.do", method = RequestMethod.POST)
	public ModelAndView memberLoginPro(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		System.out.println(req.getParameter("id"));
		System.out.println(req.getParameter("pw"));

		MemberDTO dto = memberDAO.getMember(req.getParameter("id"), req.getParameter("pw"));
		
		if (dto == null)
		{// 로그인 실패
			mav.setViewName("WEB-INF/member/memberLoginForm.jsp");
			mav.addObject("isLoginComp", false);

			return mav;
		} else
		{// 로그인 성공
			if (dto.getId().equals("admin"))
			{//관리자
				mav.setViewName("admin/admin_main.jsp");
				HttpSession session = req.getSession();
				session.setAttribute("loginId", dto);
				session.setAttribute("id", "admin");
			}
			else{
			mav.setViewName("back.jsp");
			HttpSession session = req.getSession();
			session.setAttribute("loginId", dto);
}
		}
		return mav;
	}

}
