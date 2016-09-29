package faqboard.db;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import faqboard.mybatis.SimpleExample;

public class FAQBoardDAOImpl implements FAQBoardDAO {
	
	@Override
	public List listBoard(int startRow, int endRow) throws SQLException{
		HashMap map = new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		return SimpleExample.listBoard(map);
	}
	
	@Override
	public FAQBoardDTO getBoard(int num) throws SQLException{
		upCount(num);
		return SimpleExample.getBoard(num);
	}

	@Override
	public int getCount() throws SQLException{
		return SimpleExample.getCount();
	}

	@Override
	public void readCountBoard(int num) throws SQLException{
		SimpleExample.readCountBoard(num);
	}

	@Override
	public void upCount(int num) throws SQLException{
		SimpleExample.upCount(num);
	}
	
	@Override
	public List getCategory() throws SQLException {
		return SimpleExample.getCategory();
	}
	
}