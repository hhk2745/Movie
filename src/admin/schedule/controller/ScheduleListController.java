package admin.schedule.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import admin.schedule.db.ScheduleDAO;
@Controller
public class ScheduleListController{
	@Autowired
	private ScheduleDAO admin_scheduleDAO;

	@RequestMapping(value="/admin_schedule_list.do")
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		String theater = arg0.getParameter("theater");
		ModelAndView mav = new ModelAndView();
		
		List scheduleList = admin_scheduleDAO.list();
		
		
		System.out.println(scheduleList.size());
		
		List scheduleTimeList = admin_scheduleDAO.listScheduleTime();
		
		if(theater!=null){
			List branchList = new ArrayList();
		}
		
		mav.addObject("scheduleTimeList", scheduleTimeList);
		mav.addObject("scheduleList", scheduleList);
		mav.setViewName("/admin/schedule/admin_schedule_list.jsp");
		return mav;
	}

}
