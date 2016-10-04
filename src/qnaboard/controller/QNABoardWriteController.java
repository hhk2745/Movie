package qnaboard.controller;

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
		ModelAndView mav = new ModelAndView();
		MultipartRequest mr = null;
		String upPath = arg0.getServletContext().getRealPath("qnaboard_files");
		String realName = null;
		String id = null;
		QNABoardDTO dto = new QNABoardDTO();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		
		try{
			mr = new MultipartRequest(arg0, upPath, 10*1024*1024, "UTF-8");
			id = mr.getParameter("id");
			String fileName = mr.getFilesystemName("fileName");
			
			if(fileName != null){
				File oldFile = new File(upPath+"/"+fileName);
				int dotNum = fileName.lastIndexOf(".");
				realName = sdf.format(date)+fileName.substring(dotNum, fileName.length());
				
				FileInputStream fis = new FileInputStream(upPath+"/"+fileName);
			    
			    upPath = arg0.getServletContext().getRealPath("qnaboard_files/"+id);
			    
			    File dir = new File(upPath);
			    if(!dir.exists()){
			    	dir.mkdir();
			    }
			    
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
		
		dto.setFileName(realName);
		dto.setCategory(category);
		dto.setContent(content);
		dto.setTitle(title);
		dto.setId(id);
		
		File file = mr.getFile("fileName");
		mav.addObject("file", file);
		mav.addObject("id", id);
		
		qnaBoardDAO.insertBoard(dto);
		mav.setViewName("redirect:qnaboard_list.do");
		
		return mav;
	}
	
}
