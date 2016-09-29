import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController
{
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public ModelAndView memberJoinCheckForm(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception
	{
		return new ModelAndView("index.jsp");
	}
	
	//고객센터 메인
	@RequestMapping(value = "/customer_main.do", method = RequestMethod.GET)
	public ModelAndView customer_main(HttpServletRequest arg0, HttpServletResponse arg1) 
				throws Exception {

		return new ModelAndView("WEB-INF/customer/customer_index.jsp");
	}
	
	//admin_게시판 관리
	@RequestMapping(value="/admin_board.do", method=RequestMethod.GET)
	public ModelAndView admin_board(HttpServletRequest arg0, HttpServletResponse arg1) 
			throws Exception {

		return new ModelAndView("admin/admin_board.jsp");
	}

}
