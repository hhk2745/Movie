package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import admin.movie.db.MovieDAO;
import member.db.MemberDAO;
import member.db.MemberDTO;
@Controller
public class MemberMoneyController {

   @Autowired
   private MemberDAO memberDAO;  
   
   
   @RequestMapping(value="/member_Money.do")
   public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception
   {
      HttpSession session = req.getSession();
      MemberDTO dto = new MemberDTO();
      ModelAndView mav = new ModelAndView();
      String money= req.getParameter("money");
      
      dto = (MemberDTO)session.getAttribute("loginId");
      dto.setMoney(dto.getMoney() + Integer.parseInt(req.getParameter("money")));
      
      memberDAO.insertMoney(dto);
      
      session.setAttribute("loginId", dto);
      
      
      mav.setViewName("redirect:/member_MyPage.do?mode=myMoney");
      
      return mav;
      
   }
   
   
}