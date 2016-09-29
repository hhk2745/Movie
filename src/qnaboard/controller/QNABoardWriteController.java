package qnaboard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import qnaboard.db.QNABoardDAO;
import qnaboard.db.QNABoardDTO;

@Controller
public class QNABoardWriteController {
	
	@Autowired
	private QNABoardDAO qnaBoardDAO;
	
	@RequestMapping(value="/qna_writeForm.do")
	public ModelAndView qna_writeForm(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		List categoryList = qnaBoardDAO.getCategory();
		mav.addObject("categoryList", categoryList);
		
		mav.setViewName("WEB-INF/customer/qnaboard/writeForm.jsp");
		return mav;
	}
	
	@RequestMapping(value="/qnaboard_writePro.do")
	protected ModelAndView qna_writePro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		int category = ServletRequestUtils.getIntParameter(arg0, "category");
		String content = ServletRequestUtils.getStringParameter(arg0, "content");
		String title = ServletRequestUtils.getStringParameter(arg0, "title");
		String id = ServletRequestUtils.getStringParameter(arg0, "id");
		
		ModelAndView mav = new ModelAndView();
		QNABoardDTO dto = new QNABoardDTO();
		dto.setCategory(category);
		dto.setContent(content);
		dto.setTitle(title);
		dto.setId(id);
		qnaBoardDAO.insertBoard(dto);
		mav.setViewName("redirect:qnaboard_list.do");
		
		return mav;
	}
	
}
