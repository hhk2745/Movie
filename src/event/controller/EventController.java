package event.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventController
{
	@RequestMapping(value = "/eventHome.do", method = RequestMethod.GET)
	public ModelAndView eventHome(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception
	{
		ModelAndView mav =new ModelAndView();
		
		mav.setViewName("event.jsp");
		
		return mav;
	}
	@RequestMapping(value = "/event1.do", method = RequestMethod.GET)
	public ModelAndView event1(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception
	{
		ModelAndView mav =new ModelAndView();
		
		mav.setViewName("WEB-INF/event/event1.jsp");
		
		return mav; 
	}
	@RequestMapping(value = "/event2.do", method = RequestMethod.GET)
	public ModelAndView event2(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception
	{
		ModelAndView mav =new ModelAndView();
		
		mav.setViewName("#");
		
		return mav; 
	}
	@RequestMapping(value = "/event3.do", method = RequestMethod.GET)
	public ModelAndView event3(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception
	{
		ModelAndView mav =new ModelAndView();
		
		mav.setViewName("#");
		
		return mav; 
	}
	@RequestMapping(value = "/event4.do", method = RequestMethod.GET)
	public ModelAndView event4(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception
	{
		ModelAndView mav =new ModelAndView();
		
		mav.setViewName("#");
		
		return mav; 
	}
	
}
