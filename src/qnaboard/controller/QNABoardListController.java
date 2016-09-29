package qnaboard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.db.MemberDTO;
import qnaboard.db.QNABoardDAO;

@Controller
public class QNABoardListController {
	
	@Autowired
	private QNABoardDAO qnaBoardDAO;
	
	@RequestMapping(value="/qnaboard_list.do")
	public ModelAndView qnaboard_list(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		int pageSize = 10;
		String pageNum = arg0.getParameter("pageNum");
		if(pageNum == null){
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		int startRow = pageSize*(currentPage-1)+1;
		int endRow = startRow+pageSize-1;
		int count = 0;
		
		count = qnaBoardDAO.getCount();
		
		if(endRow > count){
			endRow = count;
		}
		
		int pageCount = count/pageSize+(count%pageSize==0 ? 0 : 1);
		int pageBlock = 3;
		int startPage = (currentPage-1)/pageBlock*pageBlock+1;
		int endPage = startPage+pageBlock-1;
		
		HttpSession session = arg0.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("loginId");
		String id = "";
		if(dto != null){
			id = dto.getId();
		}
		
		List list = qnaBoardDAO.listBoard(startRow, endRow, id);
		ModelAndView mav = new ModelAndView();
		
		//setAttribute과 같은 역할, 계속 넣어주기만 하면 됨
		mav.addObject("endPage", endPage);
		mav.addObject("startPage", startPage);
		mav.addObject("pageBlock", pageBlock);
		mav.addObject("pageCount", pageCount);
		mav.addObject("pageSize", pageSize);
		mav.addObject("count", count);
		mav.addObject("currentPage", currentPage);
		mav.addObject("boardList", list);
		
		mav.setViewName("/WEB-INF/customer/qnaboard/list.jsp");
		
		return mav;
	}
	
}
