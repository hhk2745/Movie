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
public class AdminQNABoardWriteController {

	@Autowired
	private AdminQNABoardDAO adminQNABoardDAO;
	
	@RequestMapping(value="/admin_qna_writeForm.do")
	public ModelAndView admin_qna_writeForm(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int num = ServletRequestUtils.getIntParameter(arg0, "num");
		int re_step = ServletRequestUtils.getIntParameter(arg0, "re_step");
		int re_level = ServletRequestUtils.getIntParameter(arg0, "re_level");
		String recipient = ServletRequestUtils.getStringParameter(arg0, "recipient");
		
		mav.addObject("num", num);
		mav.addObject("re_step", re_step);
		mav.addObject("re_level", re_level);
		mav.addObject("recipient", recipient);
		mav.setViewName("admin/qnaboard/admin_writeForm.jsp");
		return mav;
	}
	
	@RequestMapping(value="/admin_qnaboard_writePro.do")
	protected ModelAndView admin_qna_writePro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		int category = ServletRequestUtils.getIntParameter(arg0, "category");
		String content = ServletRequestUtils.getStringParameter(arg0, "content");
		String title = ServletRequestUtils.getStringParameter(arg0, "title");
		String id = ServletRequestUtils.getStringParameter(arg0, "id");
		int num = ServletRequestUtils.getIntParameter(arg0, "num");
		int re_step = ServletRequestUtils.getIntParameter(arg0, "re_step");
		int re_level = ServletRequestUtils.getIntParameter(arg0, "re_level");
		String recipient = ServletRequestUtils.getStringParameter(arg0, "recipient");
		
		ModelAndView mav = new ModelAndView();
		AdminQNABoardDTO dto = new AdminQNABoardDTO();
		dto.setCategory(category);
		dto.setContent(content);
		dto.setTitle(title);
		dto.setId(id);
		dto.setRe_step(re_step);
		dto.setRe_level(re_level);
		dto.setRecipient(recipient);
		adminQNABoardDAO.admin_insertBoard(dto);
		mav.setViewName("redirect:admin_qnaboard_list.do");
		
		return mav;
	}
	
}
