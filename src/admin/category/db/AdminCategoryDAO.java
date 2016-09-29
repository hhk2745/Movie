package admin.category.db;

import java.sql.SQLException;
import java.util.List;

public interface AdminCategoryDAO {
	public List list(int startRow, int endRow) throws SQLException;
	public void delete(int category_num) throws SQLException;
	public void insert(String category_title) throws SQLException;
	public int getCount() throws SQLException;
	public void update(AdminCategoryDTO dto) throws SQLException;
	public List getCategory() throws SQLException;
	public AdminCategoryDTO get(int category_num) throws SQLException;
}
