package event.db;

import java.util.List;

public interface EventDAO
{
	public int insertEvent(EventDTO dto);

	public int deleteEvent(int num);
	
	public int updateEvent(EventDTO dto);
	
	public EventDTO getEvent(int num);
	
	public List getEvents();
	
	public int getSeqCurrVal();
	
}
