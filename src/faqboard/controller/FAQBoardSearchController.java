package faqboard.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import faqboard.db.FAQBoardDAO;

@Controller
public class FAQBoardSearchController {
	
	@Autowired
	FAQBoardDAO faqBoardDAO;
	
	@RequestMapping(value="/faq_search.do")
	protected ModelAndView faq_search(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		String search = ServletRequestUtils.getStringParameter(arg0, "search");
		
		int pageSize = 5;
		String pageNum = arg0.getParameter("pageNum");
		if(pageNum == null){
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		int startRow = pageSize*(currentPage-1)+1;
		int endRow = startRow+pageSize-1;
		
		HashMap map = faqBoardDAO.search(startRow, endRow, search);
		
		int count = (int)map.get("count");
		
		if(endRow > count){
			endRow = count;
		}
		
		int pageCount = count/pageSize+(count%pageSize==0 ? 0 : 1);
		int pageBlock = 3;
		int startPage = (currentPage-1)/pageBlock*pageBlock+1;
		int endPage = startPage+pageBlock-1;
		
		mav.addObject("endPage", endPage);
		mav.addObject("startPage", startPage);
		mav.addObject("pageBlock", pageBlock);
		mav.addObject("pageCount", pageCount);
		mav.addObject("pageSize", pageSize);
		mav.addObject("count", count);
		mav.addObject("currentPage", currentPage);
		mav.addObject("boardList", map.get("list"));
		mav.addObject("search", search);
		mav.setViewName("/WEB-INF/customer/faqboard/search_list.jsp");
		return mav;
	}

}
