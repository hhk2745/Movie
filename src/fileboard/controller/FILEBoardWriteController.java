package fileboard.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;

import fileboard.db.FILEBoardDAO;
import fileboard.db.FILEBoardDTO;

@Controller
public class FILEBoardWriteController {
	
	@Autowired
	private FILEBoardDAO fileBoardDAO;
	
	@RequestMapping(value="/fileboard_writeForm.do", method=RequestMethod.GET)
	public ModelAndView file_writeForm(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		return new ModelAndView("WEB-INF/customer/fileboard/writeForm.jsp");
	}
	
	@RequestMapping(value="/fileboard_writePro.do", method=RequestMethod.POST)
	protected ModelAndView file_writePro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		MultipartRequest mr = null;
		String upPath = arg0.getServletContext().getRealPath("WEB-INF/customer/fileboard/files");
		String realName = null;
		String id = null;
		FILEBoardDTO dto = new FILEBoardDTO();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		
		try{
			mr = new MultipartRequest(arg0, upPath, 10*1024*1024, "UTF-8");
			id = mr.getParameter("id");
			String fileName = mr.getFilesystemName("fileName");
			File oldFile = new File(upPath+"/"+fileName);
			int dotNum = fileName.lastIndexOf("."); //.찾기
			realName = sdf.format(date)+fileName.substring(dotNum, fileName.length());
			
			FileInputStream fis = new FileInputStream(upPath+"/"+fileName);
		    
		    upPath = arg0.getServletContext().getRealPath("/WEB-INF/customer/fileboard/files/"+id);
		    
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
			
			
		}catch(IOException e){
			System.out.println("파일 업로드 실패!!");
			e.printStackTrace();
		}

		dto.setId(id);
		dto.setContent(mr.getParameter("content"));
		dto.setFileName(realName); //aa1.jpg
		
		File file = mr.getFile("fileName");
		System.out.println(upPath);

		fileBoardDAO.insertBoard(dto);
		
		mav.addObject("file", file);
		mav.setViewName("redirect:fileboard_list.do");
		return mav;
	}
	
	@RequestMapping(value="/fileboard_updateForm.do")
	public ModelAndView file_update(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int num = ServletRequestUtils.getIntParameter(arg0, "num");
		FILEBoardDTO dto = fileBoardDAO.getBoard(num);
		mav.addObject("num", num);
		mav.addObject("dto", dto);
		mav.setViewName("WEB-INF/customer/fileboard/updateForm.jsp");
		return mav;
	}
	
	@RequestMapping(value="/fileboard_updatePro.do", method=RequestMethod.POST)
	protected ModelAndView file_updatePro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		MultipartRequest mr = null;
		String upPath = arg0.getServletContext().getRealPath("WEB-INF/customer/fileboard/files");
		FILEBoardDTO dto = new FILEBoardDTO();
		String realName = null;
		String id = null;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		
		try{
			mr = new MultipartRequest(arg0, upPath, 10*1024*1024, "UTF-8");
			String fileName = mr.getFilesystemName("fileName");
			id = mr.getParameter("id");
			File oldFile = new File(upPath+"/"+fileName);
			int dotNum = fileName.lastIndexOf("."); //.찾기
			realName = sdf.format(date)+fileName.substring(dotNum, fileName.length());
			
			FileInputStream fis = new FileInputStream(upPath+"/"+fileName);
		    
		    upPath = arg0.getServletContext().getRealPath("/WEB-INF/customer/fileboard/files/"+id);
		    
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
		    
		}catch(IOException e){
			System.out.println("파일 업로드 실패!!");
			e.printStackTrace();
		}
		
		int num = Integer.parseInt(mr.getParameter("num"));
		int likeCount = Integer.parseInt(mr.getParameter("likeCount"));
		String content = mr.getParameter("content");
		
		dto.setNum(num);
		dto.setId(id);
		dto.setContent(content);
		dto.setFileName(realName);
		dto.setLikeCount(likeCount);
		
		fileBoardDAO.updateBoard(dto);
		
		return new ModelAndView("redirect:fileboard_list.do");
	}
}