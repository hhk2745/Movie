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
public class AdminCategoryWriteController {
	
	@Autowired
	AdminCategoryDAO adminCategoryDAO;
	
	@RequestMapping(value="/admin_category_writeForm.do")
	public ModelAndView admin_category_writeForm(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/category/admin_writeForm.jsp");
		return mav;
	}
	
	@RequestMapping(value="/admin_category_writePro.do")
	public ModelAndView admin_category_writePro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
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
			adminCategoryDAO.insert(category_title);
			mav.setViewName("redirect:admin_category_list.do");
			return mav;
		}
		
		mav.setViewName("redirect:admin_category_writeForm.do");
		return mav;
	}
}