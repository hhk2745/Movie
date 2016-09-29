package fileboard.db;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import fileboard.mybatis.SimpleExample;

public class FILEBoardDAOImpl implements FILEBoardDAO {
	
	@Override
	public List listBoard(int startRow, int endRow) {
		HashMap map = new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		return SimpleExample.listBoard(map);
	}
	
	@Override
	public FILEBoardDTO getBoard(int num) {
		return SimpleExample.getBoard(num);
	}

	@Override
	public void insertBoard(FILEBoardDTO dto) {
		HashMap map = new HashMap();
		map.put("id", dto.getId());
		map.put("content", dto.getContent());
		map.put("fileName", dto.getFileName());
		
		SimpleExample.insertBoard(map);
	}

	@Override
	public void deleteBoard(int num) {
		SimpleExample.deleteBoard(num);
	}

	@Override
	public int getCount() {
		return SimpleExample.getCount();
	}

	@Override
	public void readCountBoard(int num) {
		SimpleExample.readCountBoard(num);
	}

	@Override
	public void updateBoard(FILEBoardDTO dto) {
		HashMap map = new HashMap();
		map.put("num", dto.getNum());
		map.put("id", dto.getId());
		map.put("content", dto.getContent());
		map.put("fileName", dto.getFileName());
		map.put("likeCount", dto.getLikeCount());
		System.out.println(dto);
		SimpleExample.updateBoard(map);
	}

	@Override
	public List searchBoard(String id) throws SQLException {
		return SimpleExample.searchBoard(id);
	}
	
}