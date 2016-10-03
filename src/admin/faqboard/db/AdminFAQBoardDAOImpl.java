package admin.faqboard.db;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import admin.faqboard.mybatis.SimpleExample;

public class AdminFAQBoardDAOImpl implements AdminFAQBoardDAO {
	
	@Override
	public List listBoard(int startRow, int endRow, String mode) throws SQLException{
		HashMap map = new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("mode", mode);
//		SimpleExample.admin_getCategory();
		return SimpleExample.admin_listBoard(map);
	}
	
	@Override
	public List allListBoard(int startRow, int endRow) throws SQLException{
		HashMap map = new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		return SimpleExample.admin_allListBoard(map);
	}
	
	@Override
	public AdminFAQBoardDTO getBoard(int num) throws SQLException{
		return SimpleExample.admin_getBoard(num);
	}

	@Override
	public void insertBoard(AdminFAQBoardDTO dto) throws SQLException{
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
		
		SimpleExample.admin_insertBoard(map);
	}

	@Override
	public void deleteBoard(int num) throws SQLException{
		SimpleExample.admin_deleteBoard(num);
	}

	@Override
	public int getCount() throws SQLException{
		return SimpleExample.admin_getCount();
	}

	@Override
	public void readCountBoard(int num) throws SQLException{
		SimpleExample.admin_readCountBoard(num);
	}

	@Override
	public void updateBoard(AdminFAQBoardDTO dto) throws SQLException{
		SimpleExample.admin_updateBoard(dto);
	}
	
	@Override
	public List getCategory() throws SQLException {
		return SimpleExample.admin_getCategory();
	}
	
}