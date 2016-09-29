package admin.qnaboard.db;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import admin.qnaboard.mybatis.SimpleExample;

public class AdminQNABoardDAOImpl implements AdminQNABoardDAO{

	@Override
	public List admin_listBoard(int startRow, int endRow) throws SQLException {
		HashMap map = new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		return SimpleExample.admin_listBoard(map);
	}

	@Override
	public AdminQNABoardDTO admin_getBoard(int num) throws SQLException {
		upCount(num);
		return SimpleExample.admin_getBoard(num);
	}

	@Override
	public void admin_insertBoard(AdminQNABoardDTO dto) throws SQLException {
		SimpleExample.admin_stepUpdate(dto.getRe_step());
		dto.setRe_step(dto.getRe_step()+1);
		dto.setRe_level(dto.getRe_level()+1);
		
		HashMap map = new HashMap();
		map.put("category", dto.getCategory());
		map.put("id", dto.getId());
		map.put("title", dto.getTitle());
		map.put("content", dto.getContent());
		map.put("re_step", dto.getRe_step());
		map.put("re_level", dto.getRe_level());
		map.put("recipient", dto.getRecipient());
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
	public void admin_deleteBoard(int num) throws SQLException {
		
	}

	@Override
	public int admin_getCount() throws SQLException {
		return SimpleExample.admin_getCount();
	}

	@Override
	public List admin_getCategory() throws SQLException {
		return SimpleExample.admin_getCategory();
	}

	@Override
	public void upCount(int num) throws SQLException {
		SimpleExample.admin_upCount(num);
	}

	@Override
	public void admin_stepUpdate(int re_step) throws SQLException {
		SimpleExample.admin_stepUpdate(re_step);
	}
	
}
