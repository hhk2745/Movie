package admin.faqboard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import admin.faqboard.db.AdminFAQBoardDAO;
import admin.faqboard.db.AdminFAQBoardDTO;

@Controller
public class AdminFAQBoardContentController {
	
	@Autowired
	private AdminFAQBoardDAO adminFAQBoardDAO;
	
	@RequestMapping(value="/admin_faqboard_content.do")
	protected ModelAndView faq_client_content(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		int num = ServletRequestUtils.getIntParameter(arg0, "num");
		
		AdminFAQBoardDTO dto = adminFAQBoardDAO.getBoard(num);
		mav.addObject("boardDTO", dto);
		mav.setViewName("admin/faqboard/admin_content.jsp");
		
		return mav;
	}
	
	@RequestMapping(value="/admin_faqboard_updateForm.do")
	public ModelAndView faq_updateForm(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		int num = ServletRequestUtils.getIntParameter(arg0, "num");
		AdminFAQBoardDTO dto = adminFAQBoardDAO.getBoard(num);
		List categoryList = adminFAQBoardDAO.getCategory();
		
		mav.addObject("categoryList", categoryList);
		mav.addObject("num", num);
		mav.addObject("dto", dto);
		mav.setViewName("admin/faqboard/admin_updateForm.jsp");
		
		return mav;
	}
	
	@RequestMapping(value="/admin_faqboard_updatePro.do")
	protected ModelAndView faq_updatePro(HttpServletRequest arg0, HttpServletResponse arg1)throws Exception {
		int category = ServletRequestUtils.getIntParameter(arg0, "category");
		String content = ServletRequestUtils.getStringParameter(arg0, "content");
		String title = ServletRequestUtils.getStringParameter(arg0, "title");
		String id = ServletRequestUtils.getStringParameter(arg0, "id");
		int num = ServletRequestUtils.getIntParameter(arg0, "num");
		
		AdminFAQBoardDTO dto = new AdminFAQBoardDTO();
		dto.setNum(num);
		dto.setCategory(category);
		dto.setContent(content);
		dto.setTitle(title);
		dto.setId(id);
		adminFAQBoardDAO.updateBoard(dto);
		
		return new ModelAndView("redirect:admin_faqboard_list.do");
	}
	
	@RequestMapping(value="/admin_faqboard_delete.do")
	protected ModelAndView faq_delete(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		AdminFAQBoardDTO dto = new AdminFAQBoardDTO();
		int num = ServletRequestUtils.getIntParameter(arg0, "num");
		adminFAQBoardDAO.deleteBoard(num);
		return new ModelAndView("redirect:admin_faqboard_list.do");
	}
}




