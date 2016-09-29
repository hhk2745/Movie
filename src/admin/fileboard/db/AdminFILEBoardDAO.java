package admin.fileboard.db;

import java.sql.SQLException;
import java.util.List;

public interface AdminFILEBoardDAO {
	public List listBoard(int startRow, int endRow) throws SQLException;
	public void deleteBoard(int num) throws SQLException;
	public int getCount() throws SQLException;
}
