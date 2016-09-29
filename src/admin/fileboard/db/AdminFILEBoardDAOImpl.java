package admin.fileboard.db;

import java.util.HashMap;
import java.util.List;

import admin.fileboard.mybatis.SimpleExample;

public class AdminFILEBoardDAOImpl implements AdminFILEBoardDAO {
	
	@Override
	public List listBoard(int startRow, int endRow) {
		HashMap map = new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		return SimpleExample.listBoard(map);
	}
	
	@Override
	public void deleteBoard(int num) {
		SimpleExample.deleteBoard(num);
	}

	@Override
	public int getCount() {
		return SimpleExample.getCount();
	}

}