package qnaboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QNABoardImgController {

	@RequestMapping(value="/qna_img.do")
	public ModelAndView qna_img(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		int num = ServletRequestUtils.getIntParameter(arg0, "num");
		String id = ServletRequestUtils.getStringParameter(arg0, "id");
		String fileName = ServletRequestUtils.getStringParameter(arg0, "fileName");
		mav.addObject("id", id);
		mav.addObject("fileName", fileName);
		mav.addObject("num", num);
		mav.addObject("result", true);
		mav.setViewName("qna_content.do");
		return mav;
	}
	
	@RequestMapping(value="/qna_imgOpen.do")
	public ModelAndView qna_imgOpen(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		String id = ServletRequestUtils.getStringParameter(arg0, "id");
		String fileName = ServletRequestUtils.getStringParameter(arg0, "fileName");
		mav.addObject("id", id);
		mav.addObject("fileName", fileName);
		mav.setViewName("WEB-INF/customer/qnaboard/img.jsp");
		return mav;
	}
	
}
