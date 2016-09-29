package member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import member.db.Gmail;
import member.db.MemberDAO;
import member.db.MemberDTO;

@Controller
public class MemberConfirmController
{
	@Autowired
	private Gmail gmail;
	
	@Autowired
	private MemberDAO memberDAO;

	// [인증하기] 버튼 클릭-> windows.open("confirm.do") 인증번호를 받을 수 있는 창을 띄운다.
	// confirm.do에서는 클라이언트의 메일주소를 받고, 난수를 발생하여 메일을 전송한다.
	// 인증번호를 받을 수 있는 창으로 인증번호를 전송하고 번호가 맞다면 windows close 틀리면 경고창
	
	// 인증번호를 받을 수 있는 창에서 인증 성공하면 confirmOk.do 로 이동.
	// confirmOk.do에서는 인증완료된 ID를 hidden으로 넘겨받게되고  approve(String id)를 실행한다.
	

	@RequestMapping(value = "/confirm.do", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView memberConfirm(HttpServletRequest req, HttpServletResponse resp)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/member/memberConfirmForm.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/confirm2.do", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView memberConfirm2(HttpServletRequest req, HttpServletResponse resp)
	{
		ModelAndView mav = new ModelAndView();
		String clientEmail = "";
		if(req.getParameter("clientEmail")!=null)
			clientEmail = req.getParameter("clientEmail");

		String confirmNumber = makeRandomNumber();

		gmail.sendMail(clientEmail, confirmNumber);

		mav.addObject("confirmNumber", confirmNumber);
		HttpSession session = req.getSession();
		
		mav.addObject("loginId", session.getAttribute("loginId"));
		mav.addObject("clientEmail", clientEmail);
		
		mav.setViewName("WEB-INF/member/memberConfirmForm.jsp");
		return mav;
	}
	
	
	
	@RequestMapping(value="/confirmOk.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView memberConfirmOk(HttpServletRequest req, HttpServletResponse resp) throws SQLException
	{
		System.out.println("Controller in req id : "+req.getParameter("loginId"));
		ModelAndView mav = new ModelAndView();
		
		String id = req.getParameter("loginId");
		
		int res = memberDAO.approve(id);
		
		
		if(res>0){
			mav.addObject("confirmResult", true);
		}else{
			mav.addObject("confirmResult", false);
		}
		mav.setViewName("WEB-INF/member/memberConfirmForm.jsp");
		
		return mav;
	}

	private String makeRandomNumber()
	{
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < 6; i++)
		{
			int n = (int) (Math.random() * 10);
			buffer.append(n);
		}
		return buffer.toString();
	}

}
