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
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;

import member.db.MemberDTO;
import qnaboard.db.QNABoardDAO;
import qnaboard.db.QNABoardDTO;

@Controller
public class QNABoardContentController {

	@Autowired
	private QNABoardDAO qnaBoardDAO;
	
	@RequestMapping(value="/qna_content.do")
	protected ModelAndView qna_content(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int num = ServletRequestUtils.getIntParameter(arg0, "num");
		String recipient = ServletRequestUtils.getStringParameter(arg0, "recipient");
		
		QNABoardDTO dto = qnaBoardDAO.getBoard(num);
		dto.setRecipient(recipient);
		
		mav.addObject("QNAboardDTO", dto);
		mav.setViewName("WEB-INF/customer/qnaboard/content.jsp");
		return mav;
	}
	
	@RequestMapping(value="/qnaboard_delete.do")
	protected ModelAndView qna_delete(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int num = ServletRequestUtils.getIntParameter(arg0, "num");
		QNABoardDTO dto = qnaBoardDAO.getBoard(num);
		String id =	dto.getId();
		
		if(dto.getFileName() != null){
			String upPath = arg0.getServletContext().getRealPath("qnaboard_files/"+id);
			String fileName = dto.getFileName();	
			File oldFile = new File(upPath+"/"+fileName);
			
			boolean delete = oldFile.delete();
			if(!delete){
				System.out.println("삭제실패!!");
			}
			else{		
				qnaBoardDAO.deleteBoard(num);
			}
		}else{
			qnaBoardDAO.deleteBoard(num);
		}
		
		mav.addObject("id", id);
		mav.setViewName("redirect:qnaboard_list.do");
		
		return mav;
	}
	
	@RequestMapping(value="/qnaboard_updateForm.do")
	public ModelAndView qna_updateForm(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		int num = ServletRequestUtils.getIntParameter(arg0, "num");
		QNABoardDTO dto = qnaBoardDAO.getBoard(num);
		List categoryList = qnaBoardDAO.getCategory();
		
		mav.addObject("categoryList", categoryList);
		mav.addObject("num", num);
		mav.addObject("dto", dto);
		mav.setViewName("WEB-INF/customer/qnaboard/updateForm.jsp");
		
		return mav;
	}
	
	@RequestMapping(value="/qnaboard_updatePro.do")
	protected ModelAndView qna_updatePro(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		MultipartRequest mr = null;
		String upPath = arg0.getServletContext().getRealPath("qnaboard_files");
		String realName = null;
		String id = null;
		int num = 0;
		QNABoardDTO dto = new QNABoardDTO();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		
		try{
			mr = new MultipartRequest(arg0, upPath, 10*1024*1024, "UTF-8");
			id = mr.getParameter("id");
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
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		
		dto.setCategory(category);
		dto.setId(id);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setFileName(realName);
		
		File file = mr.getFile("fileName");
		
		qnaBoardDAO.updateBoard(dto, num);
		mav.addObject("file", file);
		mav.addObject("id", id);
		///
		int pageSize = 10;
		String pageNum = arg0.getParameter("pageNum");
		if(pageNum == null){
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		int startRow = pageSize*(currentPage-1)+1;
		int endRow = startRow+pageSize-1;
		int count = 0;
		
		count = qnaBoardDAO.getCount(id);
		
		if(endRow > count){
			endRow = count;
		}
		
		int pageCount = count/pageSize+(count%pageSize==0 ? 0 : 1);
		int pageBlock = 3;
		int startPage = (currentPage-1)/pageBlock*pageBlock+1;
		int endPage = startPage+pageBlock-1;
		
		HttpSession session = arg0.getSession();
		MemberDTO session_dto = (MemberDTO)session.getAttribute("loginId");
		String loginId = "";
		if(session_dto != null){
			loginId = session_dto.getId();
		}
		
		List list = qnaBoardDAO.listBoard(startRow, endRow, id);
		
		mav.addObject("endPage", endPage);
		mav.addObject("startPage", startPage);
		mav.addObject("pageBlock", pageBlock);
		mav.addObject("pageCount", pageCount);
		mav.addObject("pageSize", pageSize);
		mav.addObject("count", count);
		mav.addObject("currentPage", currentPage);
		mav.addObject("boardList", list);
		mav.setViewName("WEB-INF/member/memberMyQuestion.jsp");
		///
		return mav;
	}
	
}
