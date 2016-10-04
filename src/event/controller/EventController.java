package event.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;

import event.db.EventDAO;
import event.db.EventDTO;

@Controller
public class EventController
{
	@Autowired
	EventDAO eventDAO;

	@RequestMapping(value = "/clientEventList.do", method = RequestMethod.GET)
	public ModelAndView clientEventList(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		List list = eventDAO.getEvents();
		
		mav.addObject("list", list);
		mav.setViewName("WEB-INF/event/clientEventList.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/clientEventView.do", method = RequestMethod.GET)
	public ModelAndView clientEventView(HttpServletRequest req, HttpServletResponse arg1) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		EventDTO dto = eventDAO.getEvent(Integer.parseInt(req.getParameter("num")));
		mav.addObject("dto", dto);
		mav.setViewName("WEB-INF/event/clientEventView.jsp");
		return mav;
	}

	/* Admin */
	@RequestMapping(value = "/insertEvent.do", method = RequestMethod.GET)
	public ModelAndView insertEventForm(HttpServletRequest req, HttpServletResponse arg1) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/event/eventWriteForm.jsp");
		return mav;

	}

	@RequestMapping(value = "/insertEvent.do", method = RequestMethod.POST)
	public ModelAndView insertEventPro(HttpServletRequest req, HttpServletResponse arg1) throws Exception
	{
		ModelAndView mav = new ModelAndView();

		EventDTO dto = new EventDTO();
		MultipartRequest mr = null;
		String upPath = req.getServletContext().getRealPath("/event/"); //

		File file = new File(upPath);
		if (file.exists())
		{
		} else
		{
			if (file.mkdirs())
			{
				System.out.println("생성됨");
			}
		}
		mr = new MultipartRequest(req, upPath, 10 * 1024 * 1024, "UTF-8");

		/* dto setting */
		dto.setTitle(mr.getParameter("title"));
		dto.setContent(mr.getParameter("content"));
		dto.setStartDate(mr.getParameter("startDate"));
		dto.setEndDate(mr.getParameter("endDate"));
		String fileName = mr.getFilesystemName("event_img");
		dto.setFileName(fileName);
		
		/* file setting */
		
		int res = eventDAO.insertEvent(dto);
		mav.addObject("uploadResult", true);
		mav.setViewName("redirect:EventList.do");		
		return mav;
	}

	@RequestMapping(value = "/deleteEvent.do", method =
	{ RequestMethod.GET, RequestMethod.POST })
	public ModelAndView deleteEvent(HttpServletRequest req, HttpServletResponse arg1) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		String num = req.getParameter("num");
		
		System.out.println("controller : "+ num);
		
		int res = eventDAO.deleteEvent(Integer.parseInt(req.getParameter("num")));

		if (res > 0)
		{
			mav.addObject("deleteResult", true);
		} else
		{
			System.out.println("event 삭제중 에러 발생!, 위치: EventController /deleteEvent.do_POST");
		}
		mav.setViewName("redirect:EventList.do");
		return mav;
	}

	@RequestMapping(value = "/updateEvent.do", method = RequestMethod.GET)
	public ModelAndView updateEventForm(HttpServletRequest req, HttpServletResponse arg1) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		EventDTO dto = eventDAO.getEvent(Integer.parseInt(req.getParameter("num")));
		mav.addObject("dto", dto);
		mav.setViewName("admin/event/eventUpdateForm.jsp");
		return mav;
	}

	@RequestMapping(value = "/updateEventPro.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView updateEventPro(HttpServletRequest req, HttpServletResponse arg1) throws Exception
	{
		System.out.println("updateEventPro.do in");
		ModelAndView mav = new ModelAndView();
		String upPath = req.getServletContext().getRealPath("/event/");
		File file = new File(upPath);
		if (!file.exists() && file.mkdirs())
		{
				System.out.println("생성됨");
		} 
		
		
		MultipartRequest mr = null;
		
		//파일 업로드됨
		mr = new MultipartRequest(req, upPath, 10 * 1024 * 1024, "UTF-8");

		
		EventDTO dto = eventDAO.getEvent(Integer.parseInt(mr.getParameter("num")));

		/* update file 유무 */
		if (mr.getFilesystemName("event_img") == null)
		{//파일변경 안함
			System.out.print("파일변경 안함");
			dto.setTitle(mr.getParameter("title"));
			dto.setContent(mr.getParameter("content"));
			dto.setStartDate(mr.getParameter("startDate"));
			dto.setEndDate(mr.getParameter("endDate"));
			eventDAO.updateEvent(dto);
		} else if (mr.getFilesystemName("event_img") != null)
		{// 파일 변경 발생, 확장자 검사 성공
			System.out.print("파일 변경 발생, 확장자 검사 성공");
			
			dto.setTitle(mr.getParameter("title"));
			dto.setContent(mr.getParameter("content"));
			dto.setStartDate(mr.getParameter("startDate"));
			dto.setEndDate(mr.getParameter("endDate"));
			System.out.println("fileSystemName : "+mr.getFilesystemName("event_img"));
			dto.setFileName(mr.getFilesystemName("event_img"));
			
			
			eventDAO.updateEvent(dto);
			
		} else if (!checkFileExtension(mr.getFilesystemName("event_img")))
		{// 파일 변경 발생, 확장자 검사 실패
			mav.addObject("uploadResult", false); // 
		}else{
			System.out.print("?");
		}

		mav.setViewName("redirect:EventList.do");
		return mav;
	}

	@RequestMapping(value = "/getEvent.do", method = RequestMethod.GET)
	public ModelAndView getEvent(HttpServletRequest req, HttpServletResponse arg1) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		EventDTO dto = eventDAO.getEvent(Integer.parseInt(req.getParameter("num")));
		
		mav.addObject("dto", dto);
		mav.setViewName("admin/event/eventView.jsp");
		return mav;
	}
	
	
	@RequestMapping(value = "/EventList.do", method = RequestMethod.GET)
	public ModelAndView getEvents(HttpServletRequest req, HttpServletResponse arg1) throws Exception
	{
		
		ModelAndView mav = new ModelAndView();
		List list = eventDAO.getEvents();
		
		mav.addObject("list", list);
		mav.setViewName("admin/event/eventList.jsp");
		return mav;
	}
	

	private boolean checkFileExtension(String fileName)
	{
		System.out.println("checkFileExtension in fileName : " + fileName);
		String ext = "", newfname, pureFileName = "";
		int index = fileName.lastIndexOf(".");
		System.out.println("checkFileExtension in index :" + index);

		if (index != -1)
		{
			pureFileName = fileName.substring(0, index);
			ext = fileName.substring(index + 1);
			System.out.println("파일명: " + fileName + ", 확장자: " + ext);
			newfname = fileName + "_s." + ext;
			System.out.println(newfname);
		}
		System.out.println("파일명: " + fileName + ", 확장자: " + ext);

		if (ext.equals("jpg") || ext.equals("bmp") || ext.equals("png"))
		{
			return true;
		} else
		{
			return false;
		}
	}

	private void convertFile(MultipartRequest mr, String upPath, int seqCurrVal)
	{
		File file = mr.getFile("event_img");

		System.out.println("convertFile in file :" + file);
		System.out.println("convertFile in file.getName() :" + file.getName());
		System.out.println("convertFile in file.getPath() :" + file.getPath());

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try
		{
			fis = new FileInputStream(file.getPath());
			fos = new FileOutputStream(upPath + (seqCurrVal + 1) + ".jpg");
			byte[] buffer = new byte[512];
			int readcount = 0;
			while ((readcount = fis.read(buffer)) != -1)
			{
				fos.write(buffer, 0, readcount);
			}
			System.out.println("복사가 완료되었습니다.");
		} catch (Exception e)
		{
			System.out.println(e);
		} finally
		{
			try
			{
				fis.close();
			} catch (IOException e)
			{
			}
			try
			{
				fos.close();
			} catch (IOException e)
			{
			}
			if (file.delete())
			{
				System.out.println("모든 파일 등록, 변환 작업이 끝나고 기존 파일을 삭제합니다.");
			} else
			{
				System.out.println("모든 파일 등록, 변환 작업이 끝나고 기존 파일을 삭제합니다. [ 실패 ] ");
			}
		}
	}

}
