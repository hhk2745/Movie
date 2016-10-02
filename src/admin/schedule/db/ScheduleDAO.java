package admin.schedule.db;

import java.util.List;

public interface ScheduleDAO {
	public List list();
	public List listScheduleTime();
	public List isNullList();
	public ScheduleDTO getSchedule(ScheduleDTO dto);
	public int insertSchedule(ScheduleDTO dto);
	public int updateSchedule(ScheduleDTO dto);
	public int updateCloseMovie(int num);
	public int deleteSchedule();
	public int newSchedule(int maxTerm);
	public String maxTerm();
}
