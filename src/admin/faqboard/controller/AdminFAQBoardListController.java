package admin.faqboard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import admin.faqboard.db.AdminFAQBoardDAO;

@Controller
public class AdminFAQBoardListController {

	@Autowired
	private AdminFAQBoardDAO adminFAQBoardDAO;
	
	@RequestMapping(value="/admin_faqboard_list.do")
	public ModelAndView admin_faqboard_list(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		String mode = null;
		if(ServletRequestUtils.getStringParameter(arg0, "mode") == null){
			mode = "전체";
		}else{
			mode = ServletRequestUtils.getStringParameter(arg0, "mode");
		}
		
		int pageSize = 10;
		String pageNum = arg0.getParameter("pageNum");
		if(pageNum == null){
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		int startRow = pageSize*(currentPage-1)+1;
		int endRow = startRow+pageSize-1;
		int count = 0;
		
		count = adminFAQBoardDAO.getCount();
		
		if(endRow > count){
			endRow = count;
		}
		
		int pageCount = count/pageSize+(count%pageSize==0 ? 0 : 1);
		int pageBlock = 3;
		int startPage = (currentPage-1)/pageBlock*pageBlock+1;
		int endPage = startPage+pageBlock-1;
		
		List list = null;
		if(mode.equals("전체")){
			list = adminFAQBoardDAO.allListBoard(startRow, endRow);
		}else{
			list = adminFAQBoardDAO.listBoard(startRow, endRow, mode);
		}
		
		List cateList = adminFAQBoardDAO.getCategory();
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("endPage", endPage);
		mav.addObject("startPage", startPage);
		mav.addObject("pageBlock", pageBlock);
		mav.addObject("pageCount", pageCount);
		mav.addObject("pageSize", pageSize);
		mav.addObject("count", count);
		mav.addObject("currentPage", currentPage);
		mav.addObject("boardList", list);
		mav.addObject("cateList", cateList);
		
		mav.setViewName("/admin/faqboard/admin_list.jsp");
		
		return mav;
		}

}
