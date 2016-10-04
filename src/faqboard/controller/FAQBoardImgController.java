package faqboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FAQBoardImgController {
	
	@RequestMapping(value="/faq_img.do")
	public ModelAndView faq_img(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		int num = ServletRequestUtils.getIntParameter(arg0, "num");
//		String id = ServletRequestUtils.getStringParameter(arg0, "id");
		String fileName = ServletRequestUtils.getStringParameter(arg0, "fileName");
//		mav.addObject("id", id);
		mav.addObject("fileName", fileName);
		mav.addObject("num", num);
		mav.addObject("result", true);
		mav.setViewName("faqboard_content.do");
//		mav.setViewName("WEB-INF/customer/faqboard/content.jsp");
		return mav;
	}
	
	@RequestMapping(value="/faq_imgOpen.do")
	public ModelAndView faq_imgOpen(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
//		String id = ServletRequestUtils.getStringParameter(arg0, "id");
		String fileName = ServletRequestUtils.getStringParameter(arg0, "fileName");
//		mav.addObject("id", id);
		mav.addObject("fileName", fileName);
		mav.setViewName("WEB-INF/customer/faqboard/img.jsp");
		return mav;
	}

}
