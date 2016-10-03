package admin.controller;

import org.springframework.stereotype.Controller;

@Controller
public class AdminScheduleController {
	
	
	
	/*@RequestMapping(value="/admin_schedule_write.do", method=RequestMethod.GET)
	public ModelAndView writeForm(HttpServletRequest arg0, 
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		
		String title = arg0.getParameter("title");
		
		return new ModelAndView("admin/schedule/admin_schedule_writeForm.jsp?title="+title);
	}
	
	@RequestMapping(value="/admin_schedule_write.do", method=RequestMethod.POST)
	protected ModelAndView writePro(HttpServletRequest arg0, 
			HttpServletResponse arg1) throws Exception {
		ScheduleDTO dto = new ScheduleDTO();
		dto.setDay(arg0.getParameter("day"));
		dto.setTime(arg0.getParameter("time"));
		dto.setTheater(arg0.getParameter("theater"));
		dto.setTheaternum(arg0.getParameter("theaternum"));
		dto.setTitle(arg0.getParameter("title"));
		admin_scheduleDAO.insertSchedule(dto);
		
		return new ModelAndView("admin_schedule_list.do");
	}
*/
}
