package admin.faqboard.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;

import admin.faqboard.db.AdminFAQBoardDAO;
import admin.faqboard.db.AdminFAQBoardDTO;

@Controller
public class AdminFAQBoardWriteController{
	
	@Autowired
	private AdminFAQBoardDAO adminFAQBoardDAO;
	
	@RequestMapping(value="/admin_faq_writeForm.do")
	protected ModelAndView faq_writeForm(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		List categoryList = adminFAQBoardDAO.admin_getCategory();
		mav.addObject("categoryList", categoryList);
		mav.setViewName("admin/faqboard/admin_writeForm.jsp");
		
		return mav;
	}
	
	@RequestMapping(value="/admin_faqboard_writePro.do", method=RequestMethod.POST)
	protected ModelAndView faq_writePro (HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String mode = null;
		if(ServletRequestUtils.getStringParameter(arg0, "mode") == null){
			mode = "전체";
		}else{
			mode = ServletRequestUtils.getStringParameter(arg0, "mode");
		}
		
		MultipartRequest mr = null;
		String upPath = arg0.getServletContext().getRealPath("admin_faqboard_files");
		String realName = null;
		AdminFAQBoardDTO dto = new AdminFAQBoardDTO();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		
		try{
			mr = new MultipartRequest(arg0, upPath, 10*1024*1024, "UTF-8");
			String fileName = mr.getFilesystemName("fileName");
			
			if(fileName != null){
				File oldFile = new File(upPath+"/"+fileName);
				int dotNum = fileName.lastIndexOf(".");
				realName = sdf.format(date)+fileName.substring(dotNum, fileName.length());
				
				FileInputStream fis = new FileInputStream(upPath+"/"+fileName);
			    
			    upPath = arg0.getServletContext().getRealPath("admin_faqboard_files/");
			    
			    FileOutputStream fos = new FileOutputStream(upPath+"/"+realName);
			    
			    byte [] buf = new byte[1024];
				
				while(fis.available()>0)
				{
					int len = fis.read(buf);
					fos.write(buf, 0, len);
				}
				
				fis.close();
				fos.close();
				
				boolean delete = oldFile.delete();
				
			    if(!delete){
			    	System.out.println("삭제실패!!");
			    }
			}
		}catch(IOException e){
			System.out.println("파일 업로드 실패!!");
			e.printStackTrace();
		}
		
		int category = Integer.parseInt(mr.getParameter("category"));
		String content = mr.getParameter("content");
		String title = mr.getParameter("title");
		
		dto.setCategory(category);
		dto.setContent(content);
		dto.setTitle(title);
		dto.setFileName(realName);
		
		adminFAQBoardDAO.admin_insertBoard(dto);
		
		mav.addObject("mode", mode);
		mav.setViewName("redirect:admin_faqboard_list.do");
		return mav;
	}
}