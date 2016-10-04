package event.db;

import java.util.List;

import event.mybatis.SimpleExample;

public class EventDAOImpl implements EventDAO
{

	@Override
	public int insertEvent(EventDTO dto)
	{
		int res = SimpleExample.insertEvent(dto);
		return res;
	}

	@Override
	public int deleteEvent(int num)
	{
		int res = SimpleExample.deleteEvent(num);
		return res;
	}

	@Override
	public int updateEvent(EventDTO dto)
	{
		int res = SimpleExample.updateEvent(dto);
		return res;
	}

	@Override
	public EventDTO getEvent(int num)
	{
		return SimpleExample.getEvent(num);
	}

	@Override
	public List<EventDTO> getEvents()
	{
		return SimpleExample.getEvents();
	}

	@Override
	public int getSeqCurrVal()
	{
		return SimpleExample.getSeqCurrVal();
	}

}
