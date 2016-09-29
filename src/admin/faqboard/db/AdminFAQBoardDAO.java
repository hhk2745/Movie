package admin.faqboard.db;

import java.sql.SQLException;
import java.util.List;

public interface AdminFAQBoardDAO {
	public List listBoard(int startRow, int endRow) throws SQLException;
	public void insertBoard(AdminFAQBoardDTO dto) throws SQLException;
	public AdminFAQBoardDTO getBoard(int num) throws SQLException;
	public void deleteBoard(int num) throws SQLException;
	public int getCount() throws SQLException;
	public void readCountBoard(int num) throws SQLException;
	public void updateBoard(AdminFAQBoardDTO dto) throws SQLException;
	public List getCategory() throws SQLException;
}
