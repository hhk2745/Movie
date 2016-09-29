package admin.faqboard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import admin.faqboard.db.AdminFAQBoardDAO;
import admin.faqboard.db.AdminFAQBoardDTO;

@Controller
public class AdminFAQBoardWriteController{
	
	@Autowired
	private AdminFAQBoardDAO adminFAQBoardDAO;
	
	@RequestMapping(value="/admin_faq_writeForm.do")
	protected ModelAndView faq_writeForm(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		List categoryList = adminFAQBoardDAO.getCategory();
		mav.addObject("categoryList", categoryList);
		mav.setViewName("admin/faqboard/admin_writeForm.jsp");
		
		return mav;
	}
	
	@RequestMapping(value="/admin_faqboard_writePro.do", method=RequestMethod.POST)
	protected ModelAndView faq_writePro (HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		int category = ServletRequestUtils.getIntParameter(arg0, "category");
		String content = ServletRequestUtils.getStringParameter(arg0, "content");
		String title = ServletRequestUtils.getStringParameter(arg0, "title");
		String id = ServletRequestUtils.getStringParameter(arg0, "id");
		
		ModelAndView mav = new ModelAndView();
		AdminFAQBoardDTO dto = new AdminFAQBoardDTO();
		dto.setCategory(category);
		dto.setContent(content);
		dto.setTitle(title);
		dto.setId(id);
		
		adminFAQBoardDAO.insertBoard(dto);
		return new ModelAndView("redirect:admin_faqboard_list.do");
	}
}