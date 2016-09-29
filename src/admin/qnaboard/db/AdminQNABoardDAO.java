package admin.qnaboard.db;

import java.sql.SQLException;
import java.util.List;

public interface AdminQNABoardDAO {
	public List admin_listBoard(int startRow, int endRow) throws SQLException;
	public AdminQNABoardDTO admin_getBoard(int num) throws SQLException;
	public void admin_insertBoard(AdminQNABoardDTO dto) throws SQLException;
	public void admin_deleteBoard(int num) throws SQLException;
	public int admin_getCount() throws SQLException;
	public List admin_getCategory() throws SQLException;
	public void upCount(int num) throws SQLException;
	public void admin_stepUpdate(int re_step) throws SQLException;
}
