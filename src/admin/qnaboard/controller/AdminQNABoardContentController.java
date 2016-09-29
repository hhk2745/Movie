package admin.qnaboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import admin.qnaboard.db.AdminQNABoardDAO;
import admin.qnaboard.db.AdminQNABoardDTO;

@Controller
public class AdminQNABoardContentController {

	@Autowired
	private AdminQNABoardDAO adminQNABoardDAO;
	
	@RequestMapping(value="/admin_qna_content.do")
	protected ModelAndView qna_content(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int num = ServletRequestUtils.getIntParameter(arg0, "num");
		/*int re_step = ServletRequestUtils.getIntParameter(arg0, "re_step");
		int re_level = ServletRequestUtils.getIntParameter(arg0, "re_level");*/
		
		AdminQNABoardDTO dto = adminQNABoardDAO.admin_getBoard(num);
		/*dto.setRe_step(re_step);
		dto.setRe_level(re_level);*/
		
		mav.addObject("QNAboardDTO", dto);
		mav.setViewName("admin/qnaboard/admin_content.jsp");
		return mav;
	}
	
}
