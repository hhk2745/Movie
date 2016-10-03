package member.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;

import client.reserve.db.TicketDAO;
import client.reserve.db.TicketDTO;
import member.db.MemberDAO;
import member.db.MemberDTO;

@Controller
public class MyPageController
{
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private TicketDAO ticketDAO;

	ModelAndView mav = null;

	@RequestMapping(value = "/member_MyPage.do", method = RequestMethod.GET)
	public ModelAndView memberMyPageForm(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		return getCommandFactory(req, resp);
	}

	@RequestMapping(value = "/member_MyPage.do", method = RequestMethod.POST)
	public ModelAndView memberMyPagePro(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		return postCommandFactory(req, resp);
	}

	/* ==========================Get CommandFactory========================== */
	public ModelAndView getCommandFactory(HttpServletRequest req, HttpServletResponse resp)
	{
		if (req.getParameter("mode").equals("myPageMain"))
		{
			mav = myPageMain(req, resp);
		} else if (req.getParameter("mode").equals("myTicket"))
		{
			mav = myTicket(req, resp);
		} else if (req.getParameter("mode").equals("myPoint"))
		{
			mav = myPoint(req, resp);
		} else if (req.getParameter("mode").equals("myMoney"))
		{
			mav = myMoney(req, resp);
		} else if (req.getParameter("mode").equals("myInfo"))
		{
			mav = myInfo(req, resp);
		} else if (req.getParameter("mode").equals("myProfile"))
		{
			mav = myProfile(req, resp);
		} else if (req.getParameter("mode").equals("myQuestion"))
		{
			mav = myQuestion(req, resp);
		} else if (req.getParameter("mode").equals("dropOut"))
		{
			mav = myDropOut(req, resp);
		}

		Calendar cal = Calendar.getInstance();
		mav.addObject("year", cal.get(Calendar.YEAR));

		return mav;
	}

	/*
	 * ==========================Post CommandFactory==========================
	 */
	public ModelAndView postCommandFactory(HttpServletRequest req, HttpServletResponse resp)
			throws NumberFormatException, SQLException
	{

		if (req.getParameter("mode").equals("myPageMain"))
		{
			mav = myPageMainPro(req, resp);
		} else if (req.getParameter("mode").equals("myTicket"))
		{
			mav = myTicketPro(req, resp);
		} else if (req.getParameter("mode").equals("myPoint"))
		{
			mav = myPointPro(req, resp);
		} else if (req.getParameter("mode").equals("myMoney"))
		{
			mav = myMoneyPro(req, resp);
		} else if (req.getParameter("mode").equals("myInfoPwCheck"))
		{// 개인정보 변경 전 패스워드
			mav = myInfoPwCheck(req, resp);
		} else if (req.getParameter("mode").equals("myInfo"))
		{// 개인정보 변경
			mav = myInfoPro(req, resp);
		} else if (req.getParameter("mode").equals("myProfile"))
		{
			mav = myProfilePro(req, resp);
		} else if (req.getParameter("mode").equals("myQuestion"))
		{
			mav = myQuestionPro(req, resp);
		} else if (req.getParameter("mode").equals("dropOut"))
		{
			mav = myDropOutPro(req, resp);
		}

		Calendar cal = Calendar.getInstance();
		mav.addObject("year", cal.get(Calendar.YEAR));

		return mav;
	}

	/* ==========================Get Method========================== */

	public ModelAndView myPageMain(HttpServletRequest req, HttpServletResponse resp)
	{

		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyPage.jsp");
		String upPath = req.getServletContext().getRealPath("/profile_img/"); // 프로필사진
		mav.addObject("upPath", upPath);
		return mav;

	}

	public ModelAndView myTicket(HttpServletRequest req, HttpServletResponse resp)
	{
		HttpSession session = req.getSession();
		MemberDTO mdto = (MemberDTO) session.getAttribute("loginId"); 
		List<TicketDTO> list = ticketDAO.listTicket(mdto.getId());
		List<TicketDTO> listDC = ticketDAO.listTicketDelCant(mdto.getId());
		
		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyTicket.jsp");
		mav.addObject("listTicket",list);
		mav.addObject("listTicketDC",listDC);
		return mav;

	}


	@RequestMapping(value = "/myTicketDelete.do")
	public ModelAndView TicketDelete(HttpServletRequest req, HttpServletResponse resp)
	{
	String num = req.getParameter("num");
	TicketDTO dto = ticketDAO.getTicket(num);
	
	
	HttpSession session = req.getSession();
	MemberDTO dto1 = (MemberDTO)session.getAttribute("loginId");
	String pw = dto1.getPw();
	String id = dto1.getId();
			
	int res = ticketDAO.watchCountDown(dto.getTitle());
	int res1 = ticketDAO.upSpaceSit(dto.getDay(), dto.getTime(), dto.getTheaternum()+""); 
	ticketDAO.upMoney(dto.getId(),dto.getPay());
	ticketDAO.deleteTicket(Integer.parseInt(num));

	MemberDTO memberDTO = null;
	try {
		memberDTO = memberDAO.getMember(id, pw);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	session.setAttribute("loginId", memberDTO);
	ModelAndView mav = new ModelAndView("member_MyPage.do?mode=myTicket");
	return mav;

	}
	public ModelAndView myPoint(HttpServletRequest req, HttpServletResponse resp)
	{

		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyPoint.jsp");
		return mav;

	}

	public ModelAndView myMoney(HttpServletRequest req, HttpServletResponse resp)
	{

		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyMoney.jsp");
		return mav;

	}

	public ModelAndView myInfo(HttpServletRequest req, HttpServletResponse resp)
	{

		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyInfo.jsp");
		return mav;

	}


	public ModelAndView myProfile(HttpServletRequest req, HttpServletResponse resp)
	{
		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyProfile.jsp");
		return mav;
	}

	public ModelAndView myQuestion(HttpServletRequest req, HttpServletResponse resp)
	{

		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyQuestion.jsp");
		return mav;

	}

	public ModelAndView myDropOut(HttpServletRequest req, HttpServletResponse resp)
	{
		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyDropOut.jsp");

		return mav;
	}

	/* ==========================Post Method========================== */

	public ModelAndView myPageMainPro(HttpServletRequest req, HttpServletResponse resp)
	{

		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyPage.jsp");

		return mav;

	}

	public ModelAndView myTicketPro(HttpServletRequest req, HttpServletResponse resp)
	{

		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyPage.jsp");

		return mav;

	}

	public ModelAndView myPointPro(HttpServletRequest req, HttpServletResponse resp)
	{

		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyPage.jsp");

		return mav;

	}

	public ModelAndView myMoneyPro(HttpServletRequest req, HttpServletResponse resp)
	{

		HttpSession session = req.getSession();
	      MemberDTO dto = new MemberDTO();
	      ModelAndView mav = new ModelAndView();
	      String money= req.getParameter("money");
	      
	      dto = (MemberDTO)session.getAttribute("loginId");
	      dto.setMoney(dto.getMoney() + Integer.parseInt(req.getParameter("money")));
	      
	      try
		{
			memberDAO.insertMoney(dto);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      session.setAttribute("loginId", dto);
	      
	      
	      mav.setViewName("redirect:/member_MyPage.do?mode=myMoney");
	      
	      return mav;

	}

	public ModelAndView myInfoPwCheck(HttpServletRequest req, HttpServletResponse resp)
			throws NumberFormatException, SQLException
	{
		// 개인정보 변경 전 PwCheck
		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyInfoUpdateForm.jsp");
		MemberDTO dto = memberDAO.getMemberAdmin(Integer.parseInt(req.getParameter("memberNum")));
		mav.addObject("dto", dto);
		return mav;
	}

	public ModelAndView myInfoPro(HttpServletRequest req, HttpServletResponse resp)
			throws NumberFormatException, SQLException
	{
		// 개인정보 변경 controller
		// mail. pw, name
		String email = req.getParameter("email");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyPage.jsp");
		MemberDTO dto = memberDAO.getMemberAdmin(Integer.parseInt(req.getParameter("memberNum")));
		dto.setEmail(email);
		dto.setPw(pw);
		dto.setName(name);
		int res = memberDAO.updateMember(dto);
		if (res > 0)
		{//성공
			mav.setViewName("index.jsp");
			mav.addObject("memberInfoUpdateResult", true);
			HttpSession session = req.getSession();
			session.invalidate();
		}

		return mav;

	}

	public ModelAndView myQuestionPro(HttpServletRequest req, HttpServletResponse resp)
	{

		ModelAndView mav = new ModelAndView("WEB-INF/member/memberMyPage.jsp");

		return mav;

	}

	public ModelAndView myDropOutPro(HttpServletRequest req, HttpServletResponse resp)
			throws NumberFormatException, SQLException
	{

		ModelAndView mav = new ModelAndView();
		String initPw = req.getParameter("initPw");

		int res = memberDAO.deleteMember(Integer.parseInt(req.getParameter("memberNum")));

		if (res > 0)
		{
			mav.addObject("dropOutResult", true);
			HttpSession session = req.getSession();
			session.invalidate();
			mav.setViewName("index.jsp");
		} else
		{
			mav.addObject("dropOutResult", false);
			mav.setViewName("redirect:member_MyPage.do");
		}
		return mav;
	}
	
	
	
	/* profile_img */
	@RequestMapping(value = "/member_MyProfile.do", method = RequestMethod.POST)
	public ModelAndView myProfilePro(HttpServletRequest req, HttpServletResponse resp)
	{

		ModelAndView mav = new ModelAndView();
		// MultipartRequest로 파일을 받고 lastIndexOf로 확장자를 구한다.
		// if(jpg, png, bmp) 가 아니라면 return

		// 2. MultipartRequest객체로 id, 파일정보를 받아 upPath에 파일을 등록한다.
		// 해당파일 정보를 filereader로 읽어들이고 변수에 담아둔다.
		// 기존에 등록된 파일을 삭제하고, id.jpg로 등록한다.
		
		MultipartRequest mr = null;
		String upPath = req.getServletContext().getRealPath("/profile_img/"); //
		File file = new File(upPath);
		if(file.exists()){}else{
			if(file.mkdirs()){
				System.out.println("생성됨");
			}
		}
		
		String id = "", profile_img = "";
		try
		{
			mr = new MultipartRequest(req, upPath, 10 * 1024 * 1024, "EUC-KR");
			profile_img = mr.getFilesystemName("profile_img");
			id = mr.getParameter("id");

			System.out.println("MemberUpdateProfile_imgController mr.request id : " + id);
			System.out.println("MemberUpdateProfile_imgController mr.request filename : " + profile_img);
			System.out.println("upPath : " + upPath);

			if (checkFileExtension(profile_img))
			{
				int res = -1;
				File existFile = new File(upPath + id + ".jpg");
				if (existFile.exists())
				{// 기존에 등록된 파일이 존재하다면
					if (existFile.delete())
					{
						System.out.println("삭제됨");
						res = memberDAO.updateProfile_img(id, id + ".jpg");
					} else
					{
						System.out.println("삭제안됨");
					}
				} else
				{// 기존에 등록된 파일이 없다면
					res = memberDAO.updateProfile_img(id, id + ".jpg");
				}

				if (res > 0)
				{// 성공
					mav.addObject("profile_img", true);

					convertFile(mr, upPath, id); // 파일변환
					
					HttpSession session = req.getSession();
					
					MemberDTO dto = (MemberDTO)session.getAttribute("loginId");
					
					dto = memberDAO.getMemberAdmin(dto.getNum());
					
					session.setAttribute("loginId", dto);
					
				} else
				{// 실패
					mav.addObject("profile_img", false);
				}
			} else if (!checkFileExtension(profile_img))
			{
				mav.addObject("fileCheckResult", false);
				File deleteFile = new File(upPath + mr.getFilesystemName("profile_img"));

				if (deleteFile.delete())
				{
					System.out.println("확장자에러! 파일삭제합니다.");
				} else
				{
					System.out.println("확장자에러! 파일삭제 실패!");
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		mav.setViewName("redirect:member_MyPage.do?mode=myPageMain");
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

	private void convertFile(MultipartRequest mr, String upPath, String id)
	{
		File file = mr.getFile("profile_img");

		System.out.println("convertFile in file :" + file);
		System.out.println("convertFile in file.getName() :" + file.getName());
		System.out.println("convertFile in file.getPath() :" + file.getPath());

		// FileWriter fw = new FileWriter(file);
		// fw.
		//
		// File newFile = new File(upPath+id+".jpg");
		// newFile.

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try
		{
			fis = new FileInputStream(file.getPath());
			fos = new FileOutputStream(upPath + id+".jpg");
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
			} catch (IOException e){}
			try
			{
				fos.close();
			} catch (IOException e){}
			if(file.delete()){
				System.out.println("모든 파일 등록, 변환 작업이 끝나고 기존 파일을 삭제합니다.");
			}else{
				System.out.println("모든 파일 등록, 변환 작업이 끝나고 기존 파일을 삭제합니다. [ 실패 ] ");
			}
		}
	}
	
	// nickname
	@RequestMapping(value = "/updateNickname.do", method = RequestMethod.POST)
	public ModelAndView memberConfirm2(HttpServletRequest req, HttpServletResponse resp) throws SQLException
	{
		ModelAndView mav = new ModelAndView();
		
		
		String id = req.getParameter("id");
		System.out.println("req id" + req.getParameter("id"));
		String nickname = req.getParameter("nickname");
		
		
		int res = memberDAO.updateNickname(id, nickname);
		
		if(res>0){
			mav.addObject("updateNickname", true);
		}else
		{
			mav.addObject("updateNickname", false);
		}
		HttpSession session = req.getSession();
		
		MemberDTO dto = (MemberDTO)session.getAttribute("loginId");
		
		dto = memberDAO.getMemberAdmin(dto.getNum());
		
		session.setAttribute("loginId", dto);
	
		mav.setViewName("WEB-INF/member/memberMyProfile.jsp");
		return mav;
	}
	
	
	
}
