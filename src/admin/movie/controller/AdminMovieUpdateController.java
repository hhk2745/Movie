package admin.movie.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;

import admin.movie.db.MovieDAO;
import admin.movie.db.Movie_infoDTO;

@Controller
public class AdminMovieUpdateController
{

	@Autowired
	private MovieDAO movieDAO;

	//영화 업데이트
		@RequestMapping(value="/admin_movie_update.do",method=RequestMethod.GET)
		public ModelAndView admin_movie_updateForm(HttpServletRequest req,HttpServletResponse resp){
			ModelAndView mav = new ModelAndView();
			
			int num = Integer.parseInt(req.getParameter("num"));
			
			
			Movie_infoDTO dto = null;
			
			dto = movieDAO.getMovie(num);
			String upPath = req.getServletContext().getRealPath("/poster/"+dto.getTitle()+"_"+dto.getOpendate());//??
			
			mav.addObject("upPath", upPath);
			mav.addObject("movieDTO",dto);
			mav.setViewName("/admin/movie/admin_movie_update.jsp");
			
			return mav;
		}
		
		
		//영화 업데이트
		@RequestMapping(value="/admin_movie_update.do",method=RequestMethod.POST)
		public ModelAndView admin_movie_updatePro(HttpServletRequest req,HttpServletResponse resp){
			ModelAndView mav = new ModelAndView();
			Movie_infoDTO dto = new Movie_infoDTO();
			MultipartRequest mu = null;
			String upPath = req.getServletContext().getRealPath("");	//업패스 설정???
			String msg=null;
			String url="";
			String realFileName=null;
			String openDate=null;
			try {
				mu = new MultipartRequest(req,upPath,10*1024*1024,"UTF-8");
				
				
				String fileName = mu.getFilesystemName("poster");
				if(fileName==null){
					fileName = mu.getParameter("poster1");
				}
				try {
		        	  SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
		        	  SimpleDateFormat format2 = new SimpleDateFormat("20yy");
		              openDate = format2.format(format1.parse(mu.getParameter("opendate")));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			    String fileReName = mu.getParameter("title")+"("+openDate+")";
			    int i = -1;
			          i = fileName.lastIndexOf("."); // 파일 확장자 위치
			          realFileName = fileReName + fileName.substring(i, fileName.length());  //확장자와 바뀐 파일명 합치기
			    FileInputStream fis = new FileInputStream(upPath+fileName);
			    File oldFile = new File(upPath+fileName);
			    System.out.println(upPath+fileName);
			    
			    boolean delete=oldFile.delete();
			    if(!delete){
			    	System.out.println("삭제실패!!");
			    }
			    
			    upPath = req.getServletContext().getRealPath("/poster/"+fileReName);
			    
			    File dir = new File(upPath);
			    dir.mkdirs();	//영화이름에 맞는 디렉토리 생성
			    
			    FileOutputStream fos = new FileOutputStream(upPath+"/"+realFileName);
			    
			    byte [] buf = new byte[1024];
				
				while(fis.available()>0)
				{
					int len = fis.read(buf);
					fos.write(buf, 0, len);
				}
				fis.close();
				fos.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dto.setNum(Integer.parseInt(mu.getParameter("num")));
			dto.setTitle(mu.getParameter("title"));
			dto.setGenre(mu.getParameter("genre"));
			dto.setGrade(Integer.parseInt(mu.getParameter("grade")));
			dto.setCountry(mu.getParameter("country"));
			dto.setOpendate(mu.getParameter("opendate"));
			dto.setRuntime(Integer.parseInt(mu.getParameter("runtime")));
			dto.setMovie_info(mu.getParameter("movie_info"));
			dto.setPoster(realFileName);
			dto.setDirector(mu.getParameter("director"));
			dto.setActor(mu.getParameter("actor"));
			
			int res = movieDAO.updateMovie(dto);
			
			if(res>0){
				url="redirect:/admin_movie.do";
			}else{
				msg="수정 실패!!";
				url="/admin_movie.do";
			}
			/*List<Integer> gradeList = new ArrayList();
			gradeList.add(0);
			gradeList.add(12);
			gradeList.add(15);
			gradeList.add(18);
			gradeList.add(19);
			
			mav.addObject("gradeList", gradeList);*/
			mav.addObject("msg",msg);
			mav.setViewName(url);
			
			return mav;
		}
}
