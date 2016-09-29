package admin.category.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import admin.category.db.AdminCategoryDAO;
import admin.category.db.AdminCategoryDTO;

@Controller
public class AdminCategoryListController {

	@Autowired
	AdminCategoryDAO adminCategoryDAO;
	
	@RequestMapping(value="/admin_category_list.do")
	public ModelAndView admin_category_list(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		int pageSize = 10;
		String pageNum = arg0.getParameter("pageNum");
		if(pageNum == null){
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		int startRow = pageSize*(currentPage-1)+1;
		int endRow = startRow+pageSize-1;
		int count = 0;
		
		count = adminCategoryDAO.getCount();
		
		if(endRow > count){
			endRow = count;
		}
		
		int pageCount = count/pageSize+(count%pageSize==0 ? 0 : 1);
		int pageBlock = 3;
		int startPage = (currentPage-1)/pageBlock*pageBlock+1;
		int endPage = startPage+pageBlock-1;
		
		List list = adminCategoryDAO.list(startRow, endRow);
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("endPage", endPage);
		mav.addObject("startPage", startPage);
		mav.addObject("pageBlock", pageBlock);
		mav.addObject("pageCount", pageCount);
		mav.addObject("pageSize", pageSize);
		mav.addObject("count", count);
		mav.addObject("currentPage", currentPage);
		mav.addObject("categoryList", list);
		
		mav.setViewName("admin/category/admin_list.jsp");
		
		return mav;
	}
	
	@RequestMapping(value="/admin_category_delete.do")
	public ModelAndView admin_category_delete(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		int category_num = ServletRequestUtils.getIntParameter(arg0, "category_num");
		adminCategoryDAO.delete(category_num);
		return new ModelAndView("redirect:admin_category_list.do");
	}
	
	@RequestMapping(value="/admin_category_updateForm.do")
	public ModelAndView admin_category_updateForm(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		int category_num = ServletRequestUtils.getIntParameter(arg0, "category_num");
		ModelAndView mav = new ModelAndView();
		AdminCategoryDTO dto = new AdminCategoryDTO();
		
		dto = adminCategoryDAO.get(category_num);
		dto.setCategory_num(category_num);
		mav.addObject("dto", dto);
		mav.setViewName("admin/category/admin_updateForm.jsp");
		
		return mav;
	}
	
	@RequestMapping(value="/admin_category_updatePro.do")
	public ModelAndView admin_category_updatePro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		int category_num = ServletRequestUtils.getIntParameter(arg0, "category_num");
		String category_title = ServletRequestUtils.getStringParameter(arg0, "category_title");
		
		List<AdminCategoryDTO> list = adminCategoryDAO.getCategory();
		int res = 0;
		for(AdminCategoryDTO dto : list){
			if(dto.getCategory_title().equals(category_title)){
				res = -1;
				break;
			}
		}
		
		if(res == 0){
			//등록가능
			AdminCategoryDTO dto = new AdminCategoryDTO();
			dto.setCategory_num(category_num);
			dto.setCategory_title(category_title);
			adminCategoryDAO.update(dto);
			mav.setViewName("redirect:admin_category_list.do");
			return mav;
		}
		
		mav.setViewName("redirect:admin_category_updateForm.do");
		return mav;
	}
	
}
