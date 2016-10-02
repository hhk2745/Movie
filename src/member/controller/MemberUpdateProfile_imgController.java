package member.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;

import member.db.MemberDAO;
import member.db.MemberDTO;

@Controller
public class MemberUpdateProfile_imgController
{

	@Autowired
	MemberDAO memberDAO;

	@RequestMapping(value = "updateProfile_img.do", method = RequestMethod.POST)
	public ModelAndView memberUpdateProfile_imgPro(HttpServletRequest req, HttpServletResponse resp) throws SQLException
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
					
					dto = memberDAO.getMemberAdmin((int) dto.getNum());
					
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
		mav.setViewName("member_MyPage.do?mode=myPageMain");
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

}
