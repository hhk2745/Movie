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

import member.db.MemberDAO;
import member.db.MemberDTO;

@Controller
public class MemberUpdateNicknameController
{
	@Autowired
	MemberDAO memberDAO;
	
	
	@RequestMapping(value = "/updateNickname.do", method = RequestMethod.POST)
	public ModelAndView memberConfirm2(HttpServletRequest req, HttpServletResponse resp) throws SQLException
	{
		ModelAndView mav = new ModelAndView();
		
		
		String id = req.getParameter("id");
		System.out.println("req id" + req.getParameter("id"));
		String nickname = req.getParameter("nickname");
		
		
		int res = memberDAO.updateNickname(id, nickname);
		
		if(res>0){
			mav.addObject("updateNickname", true);
		}else
		{
			mav.addObject("updateNickname", false);
		}
		HttpSession session = req.getSession();
		
		MemberDTO dto = (MemberDTO)session.getAttribute("loginId");
		
		dto = memberDAO.getMemberAdmin((int) dto.getNum());
		
		session.setAttribute("loginId", dto);
	
		mav.setViewName("WEB-INF/member/memberMyProfile.jsp");
		return mav;
	}

}
