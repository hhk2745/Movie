package admin.sell.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import admin.movie.db.MovieDAO;
import admin.movie.db.Movie_infoDTO;
import admin.sell.db.SellDAO;

@Controller
public class SellListController{
	@Autowired
	private SellDAO sellDAO;
	@Autowired
	private MovieDAO movieDAO;
	
	private int priceTicket = 8000;
	
	
	@RequestMapping(value="/admin_sales.do")
	public ModelAndView admin_sales(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception{
		return new ModelAndView("/admin/sell/admin_sales.jsp");
	}
	
	@RequestMapping(value="/admin_sell_month.do")
	public ModelAndView MonthList(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		
		Calendar now = Calendar.getInstance();
		int YY = now.get(Calendar.YEAR);
		int mm = now.get(Calendar.MONTH);
		
		String year = YY+"";
		TreeMap<Integer, Integer> map = new TreeMap<>();
		
		for (int i = 0; i < 5; i++) {
			String Month = mm +"";
			if(mm<10){
				Month="0"+mm;
			}
			
			String nowDate = year.substring(2, 4)+"/"+Month;
			System.out.println(nowDate);
			int count = 0;
			count = sellDAO.countMonth(nowDate);
			
			System.out.println(count);
			int price = count * priceTicket;
			
			map.put(mm,price);
			mm--;
			
		}
		System.out.println("MAP.SIZE : " +map.size());
		ModelAndView mav = new ModelAndView();
		mav.addObject("monthmap",map);
		mav.setViewName("/admin/sell/month.jsp");
		return mav;
	}
	
	
	@RequestMapping(value="/admin_sell_year.do")
	public ModelAndView YearList(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		
		Calendar now = Calendar.getInstance();
		int YY = now.get(Calendar.YEAR);
		int mm = now.get(Calendar.MONTH);

		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < 4; i++) {
			String year = YY+"";
			String nowDate = year.substring(2, 4);
			int count = sellDAO.countYear(nowDate);
			int price = count * priceTicket;
			map.put(YY,price);
			YY--;
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("yearmap",map);
		mav.setViewName("/admin/sell/year.jsp");
		return mav;
	}
	
	@RequestMapping(value="/admin_sell_movie.do")
	public ModelAndView movieList(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		List listMovies = null;
		listMovies = movieDAO.getList("now");
		HashMap<String, Integer> map = new HashMap();
		System.out.println("chk1 : " +map.size());
		
		for (int i = 0; i < listMovies.size(); i++) {
			Movie_infoDTO dto = (Movie_infoDTO) listMovies.get(i);
			int count = dto.getWatchcount();
			int price = count * priceTicket;
			map.put(dto.getTitle(), price);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("moviemap",map);
		mav.setViewName("/admin/sell/movie.jsp");
		return mav;
	}

}
