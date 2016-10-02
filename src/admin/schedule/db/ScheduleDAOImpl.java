package admin.schedule.db;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import admin.controller.AdminScheduleController;
import admin.controller.AdminTheaterController;
import admin.schedule.controller.ScheduleListController;
import admin.schedule.mybatis.SimpleExample;

public class ScheduleDAOImpl implements ScheduleDAO{
	@Override
	public List list() {
		// TODO Auto-generated method stub
		return SimpleExample.listSchedule();
	}
	@Override
	public List listScheduleTime() {
		// TODO Auto-generated method stub
		return SimpleExample.listScheduleTime();
	}
	@Override
	public List isNullList() {
		// TODO Auto-generated method stub
		return SimpleExample.isNullList();
	}
	@Override
	public ScheduleDTO getSchedule(ScheduleDTO dto) {
		// TODO Auto-generated method stub
		ScheduleDTO returnDTO = SimpleExample.getSchedule(dto);
		return returnDTO;
	}

	@Override
	public int insertSchedule(ScheduleDTO dto) {
		// TODO Auto-generated method stub
		return SimpleExample.insertSchedule(dto);
	}

	@Override
	public int updateSchedule(ScheduleDTO dto) {
		// TODO Auto-generated method stub
		return SimpleExample.updateSchedule(dto);
	}
	
	@Override
	public int updateCloseMovie(int num) {
		// TODO Auto-generated method stub
		return SimpleExample.updateCloseMovie(num);
	}
	
	@Override
	public int newSchedule(int maxTerm) {
		// TODO Auto-generated method stub
		int res = 0;
		for(int k=maxTerm;k<=4;k++){
			for(int i =1;i<=5;i++){
				  for(int j=1; j<=AdminTheaterController.theaternum;j++){
					  res = SimpleExample.newSchedule(k,i, "서울_강남", j);
					  if(res==0){
						  System.out.println("newSchedule Error");
					  }
				  }
			  }
		}
		return res;
	}
	@Override
	public int deleteSchedule() {
		// TODO Auto-generated method stub
		return SimpleExample.deleteSchedule();
	}
	@Override
	public String maxTerm() {
		// TODO Auto-generated method stub
		return SimpleExample.maxTerm();
	}
	
	
}
