package admin.controller;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import admin.movie.db.MovieDAO;
import admin.schedule.db.ScheduleDAO;
import admin.schedule.db.ScheduleDTO;
import admin.schedule.db.Schedule_timeDTO;

@Controller
public class AdminTheaterController {
	
	@Autowired
	private ScheduleDAO admin_scheduleDAO;
	@Autowired
	private MovieDAO movieDAO;
	
	public static final int theaternum = 5;
	
	@RequestMapping(value="/admin_theater.do")
	public ModelAndView admin_theater(HttpServletRequest req,HttpServletResponse resp){
		ModelAndView mav = new ModelAndView();
		int listSize=theaternum*5*5;
		int deleteRes = admin_scheduleDAO.deleteSchedule();
		int newRes=0;
		String maxTerm = admin_scheduleDAO.maxTerm();
		String msg = null;
		List theaterList = null;
		List timeList = null;
		
		if(maxTerm==null){
			maxTerm="-1";
		}
		
		theaterList = admin_scheduleDAO.list();
		timeList = admin_scheduleDAO.listScheduleTime();
		
		if(listSize>theaterList.size()){	//추가 안된 스케줄을 추가
			newRes = admin_scheduleDAO.newSchedule(Integer.parseInt(maxTerm)+1);
			theaterList = admin_scheduleDAO.list();
		}
		/*if(theaterList.size()==0){		//스케줄이 없으면 새 스케줄을 짜준다.
			newRes = admin_scheduleDAO.newSchedule(0);
			theaterList = admin_scheduleDAO.list();
		}*/
		
		if(deleteRes>0 && newRes>0){
		}else if(deleteRes<=0){
			msg="지난 목록 삭제 실패!!";
		}else if(newRes<=0){
			msg="새 목록 등록 실패!!";
		}
		
		mav.addObject("theaterList",theaterList);
		mav.addObject("timeList", timeList);
		mav.addObject("theaternumsize", theaterList.size()/5);
		mav.setViewName("/admin/theater/admin_theater.jsp");
		
		
		return mav;
	}
	@RequestMapping(value="/admin_theater_update.do",method=RequestMethod.GET)
	public ModelAndView admin_theater_updateForm(HttpServletRequest req,HttpServletResponse resp){
		
		ModelAndView mav = new ModelAndView();
		ScheduleDTO dto = new ScheduleDTO();
		String scheduleTime = null;
		Calendar now = Calendar.getInstance();
		String msg = null;
		int year = now.get(Calendar.YEAR)-2000;
		int mm = now.get(Calendar.MONTH)+1;
		String month = mm +"";
		if(mm<10){
			month="0"+mm;
		}
		int dd = now.get(Calendar.DATE);
		String day = dd +"";
		if(dd<10){
			day="0"+dd;
		}
		if(req.getParameter("day").equals(year+"/"+month+"/"+day)){
			msg="오늘 날짜의 영화를 스케줄링 할 수 없습니다.";
			mav.addObject("msg",msg);
			mav.setViewName("/admin_theater.do");
			return mav;
		}
	
		dto.setTheater(req.getParameter("theater"));
		dto.setTheaternum(Integer.parseInt(req.getParameter("theaternum")));
		dto.setDay(req.getParameter("day"));
		dto.setTime(Integer.parseInt(req.getParameter("time")));
		System.out.println(dto);
		ScheduleDTO scheduleDTO = admin_scheduleDAO.getSchedule(dto);
		
		List movieTitleList = movieDAO.nowSchedule(req.getParameter("day"));
		
		List scheduleTimelist = admin_scheduleDAO.listScheduleTime();
		for(Iterator it = scheduleTimelist.iterator();it.hasNext();){
			Schedule_timeDTO sDto = (Schedule_timeDTO)it.next();
			if(dto.getTime()==sDto.getNum()){
				scheduleTime=sDto.getTime();
			}
		}
		
		
		mav.addObject("scheduleTime", scheduleTime);
		mav.addObject("movieTitleList", movieTitleList);
		mav.addObject("scheduleDTO", scheduleDTO);
		mav.setViewName("/admin/theater/admin_theater_update.jsp");
		return mav;
	}
	@RequestMapping(value="/admin_theater_update.do",method=RequestMethod.POST)
	public ModelAndView admin_theater_updatePro(HttpServletRequest req,HttpServletResponse resp){
		ModelAndView mav = new ModelAndView();
		String msg = null;
		String url = null;
		ScheduleDTO dto = new ScheduleDTO();
		dto.setTheater(req.getParameter("theater"));
		dto.setTheaternum(Integer.parseInt(req.getParameter("theaternum")));
		dto.setDay(req.getParameter("day"));
		dto.setTime(Integer.parseInt(req.getParameter("time")));
		dto.setTitle(req.getParameter("title"));
		
		int res = admin_scheduleDAO.updateSchedule(dto);
		
		if(res>0){
			url="redirect:/admin_theater.do";
		}else{
			url="redirect:/admin_theater.do";
			msg="수정 실패!!";
		}
		mav.addObject("msg", msg);
		mav.setViewName(url);
		return mav;
	}
	
	@RequestMapping(value="/admin_theater_isNull.do",method=RequestMethod.GET)
	public ModelAndView admin_theater_isNull(HttpServletRequest req,HttpServletResponse resp){
		ModelAndView mav = new ModelAndView();
		
		List theaterList = admin_scheduleDAO.isNullList();
		List timeList = admin_scheduleDAO.listScheduleTime();
		
		mav.addObject("theaterList", theaterList);
		mav.addObject("timeList", timeList);
		mav.setViewName("/admin/theater/admin_theater.jsp");
		
		return mav;
	}
	@RequestMapping(value="/admin_movie_closeDate.do")
	   public ModelAndView admin_movie_closeDate(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		   ModelAndView mav= new ModelAndView();
		   int num = Integer.parseInt(req.getParameter("num"));
		   String msg=null;
		   String url=null;
		   int scheduleRes=0;
		   int closeRes =0;
		   closeRes= movieDAO.updateClose(num);
		   
		   if(closeRes>0){
			   scheduleRes = admin_scheduleDAO.updateCloseMovie(num);
			   url="/admin_movie.do";
			   if(scheduleRes<=0){
				   msg="스케줄에 등록되어 있지 않은 영화입니다!!";
				   url="/admin_movie.do";
			   }
		   }else if(closeRes<=0){
			   
			   msg="클로징을 할 수 없는 영화입니다!!";
			   url="/admin_movie.do";
		   }
		   mav.addObject("msg",msg);
		   mav.setViewName(url);
		   return mav;
	   }
}
