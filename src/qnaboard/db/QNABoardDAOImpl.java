package qnaboard.db;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import qnaboard.mybatis.SimpleExample;

public class QNABoardDAOImpl implements QNABoardDAO{

	@Override
	public List listBoard(int startRow, int endRow, String id) {
		HashMap map = new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("id", id);
		return SimpleExample.listBoard(map);
	}
	
	@Override
	public QNABoardDTO getBoard(int num) throws SQLException {
		upCount(num);
		return SimpleExample.getBoard(num);
	}
	
	@Override
	public void insertBoard(QNABoardDTO dto) throws SQLException {
		SimpleExample.newStep();
		
		HashMap map = new HashMap();
		map.put("category", dto.getCategory());
		map.put("id", dto.getId());
		map.put("title", dto.getTitle());
		map.put("content", dto.getContent());
		if(dto.getFileName() == null){
			map.put("fileName", "");
			map.put("fileSize", 0);
		}else{
			map.put("fileName", dto.getFileName());
			map.put("fileSize", dto.getFileSize());
		}
		
		SimpleExample.insertBoard(map);
	}
	
	@Override
	public void deleteBoard(int num) throws SQLException {
		SimpleExample.deleteBoard(num);
	}
	
	@Override
	public void updateBoard(QNABoardDTO dto, int num) throws SQLException {
		HashMap map = new HashMap();
		map.put("category", dto.getCategory());
		map.put("id", dto.getId());
		map.put("title", dto.getTitle());
		map.put("content", dto.getContent());
		map.put("fileName", dto.getFileName());
		map.put("num", num);
		
		SimpleExample.updateBoard(map);
	}
	
	@Override
	public int getCount() throws SQLException {
		return SimpleExample.getCount();
	}
	
	@Override
	public void upCount(int num) throws SQLException {
		SimpleExample.upCount(num);
	}
	
	@Override
	public List getCategory() throws SQLException {
		return SimpleExample.getCategory();
	}
	
}
