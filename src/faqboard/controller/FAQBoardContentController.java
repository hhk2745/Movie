package faqboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import faqboard.db.FAQBoardDAO;
import faqboard.db.FAQBoardDTO;

@Controller
public class FAQBoardContentController {
	
	@Autowired
	private FAQBoardDAO faqBoardDAO;
	
	@RequestMapping(value="/faqboard_content.do")
	protected ModelAndView faq_client_content(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		int num = ServletRequestUtils.getIntParameter(arg0, "num");
		FAQBoardDTO dto = new FAQBoardDTO();
		String search = null;
		
		if(ServletRequestUtils.getStringParameter(arg0, "search") != null){
			search = ServletRequestUtils.getStringParameter(arg0, "search");
		}
		
		dto = faqBoardDAO.getBoard(num);
		
		mav.addObject("boardDTO", dto);
		mav.addObject("search", search);
		mav.setViewName("WEB-INF/customer/faqboard/content.jsp");
		return mav;
	}
}




