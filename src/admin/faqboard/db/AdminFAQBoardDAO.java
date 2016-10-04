package admin.faqboard.db;

import java.sql.SQLException;
import java.util.List;

public interface AdminFAQBoardDAO {
	public List admin_allListBoard(int startRow, int endRow) throws SQLException;
	public List admin_listBoard(int startRow, int endRow, String mode) throws SQLException;
	public void admin_insertBoard(AdminFAQBoardDTO dto) throws SQLException;
	public AdminFAQBoardDTO admin_getBoard(int num) throws SQLException;
	public void admin_deleteBoard(int num) throws SQLException;
	public int admin_getCount() throws SQLException;
	public void admin_readCountBoard(int num) throws SQLException;
	public void admin_updateBoard(AdminFAQBoardDTO dto) throws SQLException;
	public List admin_getCategory() throws SQLException;
}
