package admin.faqboard.db;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import admin.faqboard.mybatis.SimpleExample;

public class AdminFAQBoardDAOImpl implements AdminFAQBoardDAO {
	
	@Override
	public List admin_listBoard(int startRow, int endRow, String mode) throws SQLException{
		HashMap map = new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("mode", mode);
		return SimpleExample.admin_listBoard(map);
	}
	
	@Override
	public List admin_allListBoard(int startRow, int endRow) throws SQLException{
		HashMap map = new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		return SimpleExample.admin_allListBoard(map);
	}
	
	@Override
	public AdminFAQBoardDTO admin_getBoard(int num) throws SQLException{
		return SimpleExample.admin_getBoard(num);
	}

	@Override
	public void admin_insertBoard(AdminFAQBoardDTO dto) throws SQLException{
		HashMap map = new HashMap();
		map.put("category", dto.getCategory());
		map.put("id", dto.getId());
		map.put("title", dto.getTitle());
		map.put("content", dto.getContent());
		if(dto.getFileName() == null){
			map.put("fileName", "");
		}else{
			map.put("fileName", dto.getFileName());
		}
		
		SimpleExample.admin_insertBoard(map);
	}

	@Override
	public void admin_deleteBoard(int num) throws SQLException{
		SimpleExample.admin_deleteBoard(num);
	}

	@Override
	public int admin_getCount() throws SQLException{
		return SimpleExample.admin_getCount();
	}

	@Override
	public void admin_readCountBoard(int num) throws SQLException{
		SimpleExample.admin_readCountBoard(num);
	}

	@Override
	public void admin_updateBoard(AdminFAQBoardDTO dto) throws SQLException{
		SimpleExample.admin_updateBoard(dto);
	}
	
	@Override
	public List admin_getCategory() throws SQLException {
		return SimpleExample.admin_getCategory();
	}
	
}