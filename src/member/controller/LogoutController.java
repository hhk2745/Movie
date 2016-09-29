package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController
{

	@RequestMapping(value = "/member_Logout.do", method = RequestMethod.GET)
	public ModelAndView memberLoginForm(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		return new ModelAndView("WEB-INF/member/memberLoginForm.jsp");
	}

}
