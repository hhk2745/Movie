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
import member.db.MemberDTO;

@Controller
public class AdminMemberUpdateController
{
	@Autowired
	private MemberDAO memberDAO;

	@RequestMapping(value = "/admin_member_update.do", method = RequestMethod.GET)
	public ModelAndView admin_member_updateForm(HttpServletRequest req, HttpServletResponse resp)
	{
		System.out.println("AdminMemberController get");
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
		System.out.println("AdminMemberController" + dto);

		mav.addObject("dto", dto);

		mav.setViewName("admin/member/admin_member_updateForm.jsp");
		return mav;
	}

	@RequestMapping(value = "/admin_member_update.do", method = RequestMethod.POST)
	public ModelAndView admin_member_updatePro(HttpServletRequest req, HttpServletResponse resp)
	{
		System.out.println("AdminMemberController post");
		ModelAndView mav = new ModelAndView();
		MemberDTO dto = new MemberDTO();
		dto.setNum(Integer.parseInt(req.getParameter("num")));
		dto.setName(req.getParameter("name"));
		dto.setId(req.getParameter("id"));
		dto.setPw(req.getParameter("pw"));
		dto.setEmail(req.getParameter("email"));
		dto.setMoney(Integer.parseInt(req.getParameter("money")));
		dto.setPoint(Integer.parseInt(req.getParameter("point")));

		try
		{
			memberDAO.updateMember(dto);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mav.setViewName("admin_member.do");
		return mav;
	}

}
