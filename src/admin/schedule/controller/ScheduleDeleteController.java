package admin.schedule.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import admin.schedule.db.ScheduleDAO;
import admin.schedule.db.ScheduleDTO;
@Controller
public class ScheduleDeleteController{
	@Autowired
	private ScheduleDAO admin_scheduleDAO;

	@RequestMapping(value="/admin_schedule_delete.do")
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		admin_scheduleDAO.deleteSchedule();
		return new ModelAndView("/admin_schedule_list.do");
	}

}
