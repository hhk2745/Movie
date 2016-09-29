package admin.category.db;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import admin.category.mybatis.SimpleExample;

public class AdminCategoryDAOImpl implements AdminCategoryDAO {
	
	@Override
	public List list(int startRow, int endRow) {
		HashMap map = new HashMap();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		return SimpleExample.list(map);
	}
	
	@Override
	public void insert(String category_title) {
		SimpleExample.insert(category_title);
	}

	@Override
	public void delete(int category_num) {
		SimpleExample.delete(category_num);
	}

	@Override
	public int getCount() {
		return SimpleExample.getCount();
	}

	@Override
	public void update(AdminCategoryDTO dto) {
		HashMap map = new HashMap();
		map.put("category_num", dto.getCategory_num());
		map.put("category_title", dto.getCategory_title());
		SimpleExample.update(map);
	}

	@Override
	public List getCategory() throws SQLException {
		return SimpleExample.getCategory();
	}

	@Override
	public AdminCategoryDTO get(int category_num) throws SQLException {
		AdminCategoryDTO dto = new AdminCategoryDTO();
		dto = SimpleExample.get(category_num);
		return dto;
	}
	
}