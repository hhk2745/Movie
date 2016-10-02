package admin.fileboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminFILEBoardImgController {

	@RequestMapping(value="/admin_img.do")
	public ModelAndView admin_file_img(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		String id = ServletRequestUtils.getStringParameter(arg0, "id");
		String fileName = ServletRequestUtils.getStringParameter(arg0, "fileName");
		mav.addObject("id", id);
		mav.addObject("fileName", fileName);
		mav.addObject("result", true);
		mav.setViewName("admin_fileboard_list.do");
		return mav;
	}
	
	@RequestMapping(value="/admin_imgOpen.do")
	public ModelAndView file_imgOpen(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		String id = ServletRequestUtils.getStringParameter(arg0, "id");
		String fileName = ServletRequestUtils.getStringParameter(arg0, "fileName");
		mav.addObject("id", id);
		mav.addObject("fileName", fileName);
		mav.setViewName("admin/fileboard/admin_img.jsp");
		return mav;
	}
	
}
