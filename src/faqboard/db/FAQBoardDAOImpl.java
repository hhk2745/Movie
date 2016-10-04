package faqboard.db;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import faqboard.mybatis.SimpleExample;

public class FAQBoardDAOImpl implements FAQBoardDAO {
	
	@Override
	public HashMap search(int startRow, int endRow, String search) throws SQLException{
		HashMap map = new HashMap();
		int count = SimpleExample.searchGetCount(search);
		
		HashMap listMap = new HashMap();
		listMap.put("startRow", startRow);
		listMap.put("endRow", endRow);
		listMap.put("search", search);
		List list = SimpleExample.search(listMap);
		
		map.put("count", count);
		map.put("list", list);
		return map;
	}
	
	@Override
	public List listBoard(int startRow, int endRow, String mode) throws SQLException{
		HashMap map = new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("mode", mode);
		return SimpleExample.listBoard(map);
	}
	
	@Override
	public List allListBoard(int startRow, int endRow) throws SQLException{
		HashMap map = new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		return SimpleExample.allListBoard(map);
	}
	
	@Override
	public FAQBoardDTO getBoard(int num) throws SQLException{
		upCount(num);
		return SimpleExample.getBoard(num);
	}
	
	@Override
	public int allGetCount() throws SQLException{
		return SimpleExample.allGetCount();
	}

	@Override
	public int getCount(String mode) throws SQLException{
		return SimpleExample.getCount(mode);
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