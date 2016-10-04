package admin.faqboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminFAQBoardImgController {

	@RequestMapping(value="/admin_faq_img.do")
	public ModelAndView admin_qna_img(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		int num = ServletRequestUtils.getIntParameter(arg0, "num");
		String fileName = ServletRequestUtils.getStringParameter(arg0, "fileName");
		mav.addObject("fileName", fileName);
		mav.addObject("num", num);
		mav.addObject("result", true);
		mav.setViewName("admin_faqboard_content.do");
		return mav;
	}
	
	@RequestMapping(value="/admin_faq_imgOpen.do")
	public ModelAndView qna_imgOpen(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		String fileName = ServletRequestUtils.getStringParameter(arg0, "fileName");
		mav.addObject("fileName", fileName);
		mav.setViewName("admin/faqboard/admin_img.jsp");
		return mav;
	}
	
}
