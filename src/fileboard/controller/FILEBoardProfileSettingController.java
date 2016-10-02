package fileboard.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fileboard.db.FILEBoardDAO;
import fileboard.db.FILEBoardDTO;
import member.db.MemberDAO;
import member.db.MemberDTO;

@Controller
public class FILEBoardProfileSettingController {

	@Autowired
	private FILEBoardDAO fileBoardDAO;
	
	@Autowired
	private MemberDAO memberDAO;
	
	@RequestMapping(value="/fileboard_setting.do")
	public ModelAndView file_setting(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		List file_list = fileBoardDAO.all();
		List member_list = memberDAO.all();
		
		Iterator<FILEBoardDTO> file_it = file_list.iterator();
		
		
		while(file_it.hasNext()){
			FILEBoardDTO fileDTO = file_it.next();
			Iterator<MemberDTO> member_it = member_list.iterator();
			while(member_it.hasNext()){
				MemberDTO memberDTO = member_it.next();
				String file_id = fileDTO.getId();
				String member_id = memberDTO.getId();
				
				if(file_id.equals(member_id)){
					if(memberDTO.getProfile_img() == null){
						int res = fileBoardDAO.profileSetting(file_id);
					}
				}
			}
		}
		mav.setViewName("fileboard_list.do");
		
		return mav;
	}
	
}
