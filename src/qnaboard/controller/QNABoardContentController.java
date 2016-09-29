package qnaboard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import qnaboard.db.QNABoardDAO;
import qnaboard.db.QNABoardDTO;

@Controller
public class QNABoardContentController {

	@Autowired
	private QNABoardDAO qnaBoardDAO;
	
	@RequestMapping(value="/qna_content.do")
	protected ModelAndView qna_content(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int num = ServletRequestUtils.getIntParameter(arg0, "num");
//		int re_step = ServletRequestUtils.getIntParameter(arg0, "re_step");
//		int re_level = ServletRequestUtils.getIntParameter(arg0, "re_level");
		String recipient = ServletRequestUtils.getStringParameter(arg0, "recipient");
		
		QNABoardDTO dto = qnaBoardDAO.getBoard(num);
//		dto.setRe_step(re_step);
//		dto.setRe_level(re_level);
		dto.setRecipient(recipient);
		
		mav.addObject("QNAboardDTO", dto);
		mav.setViewName("WEB-INF/customer/qnaboard/content.jsp");
		return mav;
	}
	
	@RequestMapping(value="/qnaboard_delete.do")
	protected ModelAndView qna_delete(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		int num = ServletRequestUtils.getIntParameter(arg0, "num");
		qnaBoardDAO.deleteBoard(num);
		
		return new ModelAndView("redirect:qnaboard_list.do");
	}
	
	@RequestMapping(value="/qnaboard_updateForm.do")
	public ModelAndView qna_updateForm(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		int num = ServletRequestUtils.getIntParameter(arg0, "num");
		QNABoardDTO dto = qnaBoardDAO.getBoard(num);
		List categoryList = qnaBoardDAO.getCategory();
		
		mav.addObject("categoryList", categoryList);
		mav.addObject("num", num);
		mav.addObject("dto", dto);
		mav.setViewName("WEB-INF/customer/qnaboard/updateForm.jsp");
		
		return mav;
	}
	
	@RequestMapping(value="/qnaboard_updatePro.do")
	protected ModelAndView qna_updatePro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {

		int num = ServletRequestUtils.getIntParameter(arg0, "num");
		int category = ServletRequestUtils.getIntParameter(arg0, "category");
		String id = ServletRequestUtils.getStringParameter(arg0, "id");
		String title = ServletRequestUtils.getStringParameter(arg0, "title");
		String content = ServletRequestUtils.getStringParameter(arg0, "content");
		String fileName = ServletRequestUtils.getStringParameter(arg0, "fileName");
		
		QNABoardDTO dto = new QNABoardDTO();
		dto.setCategory(category);
		dto.setId(id);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setFileName(fileName);
		
		qnaBoardDAO.updateBoard(dto, num);
		
		return new ModelAndView("redirect:qnaboard_list.do");
		
	}
	
}
