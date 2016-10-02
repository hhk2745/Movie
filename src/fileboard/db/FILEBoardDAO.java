package fileboard.db;

import java.sql.SQLException;
import java.util.List;

public interface FILEBoardDAO {
	public int profileSetting(String id) throws SQLException;
	public List all() throws SQLException;
	public List searchBoard(String id) throws SQLException;
	public List listBoard(int startRow, int endRow) throws SQLException;
	public FILEBoardDTO getBoard(int num) throws SQLException;
	public void deleteBoard(int num) throws SQLException;
	public void insertBoard(FILEBoardDTO dto) throws SQLException;
	public int getCount() throws SQLException;
	public void readCountBoard(int num) throws SQLException;
	public void updateBoard(FILEBoardDTO dto) throws SQLException;
}
