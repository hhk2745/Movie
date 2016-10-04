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
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;

import admin.faqboard.db.AdminFAQBoardDAO;
import admin.faqboard.db.AdminFAQBoardDTO;

@Controller
public class AdminFAQBoardContentController {
	
	@Autowired
	private AdminFAQBoardDAO adminFAQBoardDAO;
	
	@RequestMapping(value="/admin_faqboard_content.do")
	protected ModelAndView faq_client_content(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		int num = ServletRequestUtils.getIntParameter(arg0, "num");
		
		AdminFAQBoardDTO dto = adminFAQBoardDAO.admin_getBoard(num);
		mav.addObject("boardDTO", dto);
		mav.setViewName("admin/faqboard/admin_content.jsp");
		
		return mav;
	}
	
	@RequestMapping(value="/admin_faqboard_updateForm.do")
	public ModelAndView faq_updateForm(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		int num = ServletRequestUtils.getIntParameter(arg0, "num");
		AdminFAQBoardDTO dto = adminFAQBoardDAO.admin_getBoard(num);
		List categoryList = adminFAQBoardDAO.admin_getCategory();
		
		mav.addObject("categoryList", categoryList);
		mav.addObject("num", num);
		mav.addObject("dto", dto);
		mav.setViewName("admin/faqboard/admin_updateForm.jsp");
		
		return mav;
	}
	
	@RequestMapping(value="/admin_faqboard_updatePro.do")
	protected ModelAndView faq_updatePro(HttpServletRequest arg0, HttpServletResponse arg1)throws Exception {
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
		int num = 0;
		
		AdminFAQBoardDTO dto = new AdminFAQBoardDTO();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");

		try{
			mr = new MultipartRequest(arg0, upPath, 10*1024*1024, "UTF-8");
			num = Integer.parseInt(mr.getParameter("num"));
			String fileName = mr.getFilesystemName("fileName");
			String fileName2 = mr.getParameter("fileName2");
			
			if(fileName == null){
				realName = fileName2;
			}else{
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
				
				File updateFile = new File(upPath+"/"+fileName2);
				if(!fileName2.equals(realName)){
					updateFile.delete();
				}

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
		
		dto.setNum(num);
		dto.setCategory(category);
		dto.setContent(content);
		dto.setTitle(title);
		dto.setFileName(realName);
		dto.setId("admin");
		adminFAQBoardDAO.admin_updateBoard(dto);
		
		mav.addObject("mode", mode);
		mav.setViewName("redirect:admin_faqboard_list.do");
		return mav;
	}
	
	@RequestMapping(value="/admin_faqboard_delete.do")
	protected ModelAndView faq_delete(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String mode = null;
		if(ServletRequestUtils.getStringParameter(arg0, "mode") == null){
			mode = "전체";
		}else{
			mode = ServletRequestUtils.getStringParameter(arg0, "mode");
		}
		
		int num = ServletRequestUtils.getIntParameter(arg0, "num");
		
		AdminFAQBoardDTO dto = adminFAQBoardDAO.admin_getBoard(num);
		
		if(dto.getFileName() != null){
			String upPath = arg0.getServletContext().getRealPath("admin_faqboard_files/");
			String fileName = dto.getFileName();	
			File oldFile = new File(upPath+"/"+fileName);
			
			boolean delete = oldFile.delete();
			if(!delete){
				System.out.println("삭제실패!!");
			}else{
				adminFAQBoardDAO.admin_deleteBoard(num);
			}
		}else{
			adminFAQBoardDAO.admin_deleteBoard(num);
		}
		
		mav.addObject("mode", mode);
		mav.setViewName("redirect:admin_faqboard_list.do");
		return mav;
	}
}




