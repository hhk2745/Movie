package admin.qnaboard.controller;

import java.io.File;

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
	protected ModelAndView admin_qna_content(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int num = ServletRequestUtils.getIntParameter(arg0, "num");
		
		AdminQNABoardDTO dto = adminQNABoardDAO.admin_getBoard(num);
		
		mav.addObject("QNAboardDTO", dto);
		mav.setViewName("admin/qnaboard/admin_content.jsp");
		return mav;
	}
	
	@RequestMapping(value="/admin_qnaboard_delete.do")
	protected ModelAndView admin_qna_delete(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		String mode = null;
		
		if(ServletRequestUtils.getStringParameter(arg0, "mode") == null){
			mode = "전체";
		}else{
			mode = ServletRequestUtils.getStringParameter(arg0, "mode");
		}
		int num = ServletRequestUtils.getIntParameter(arg0, "num"); 
		String id = ServletRequestUtils.getStringParameter(arg0, "id");
		
		AdminQNABoardDTO dto = adminQNABoardDAO.admin_getBoard(num);
		
		if(dto.getFileName() != null){
			String upPath = arg0.getServletContext().getRealPath("qnaboard_files/"+id);
			String fileName = dto.getFileName();
			File oldFile = new File(upPath+"/"+fileName);
			
			boolean delete = oldFile.delete();
			if(!delete){
				System.out.println("삭제실패!!");
			}else{
				adminQNABoardDAO.admin_deleteBoard(num);
			}
		}else{
			adminQNABoardDAO.admin_deleteBoard(num);
		}
		
		mav.addObject("mode", mode);
		mav.setViewName("redirect:admin_qnaboard_list.do");
		return mav;
	}
	
}
