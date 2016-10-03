package qnaboard.db;

import java.sql.SQLException;
import java.util.List;

public interface QNABoardDAO
{
	public List listBoard(int startRow, int endRow, String id) throws SQLException;
	public QNABoardDTO getBoard(int num) throws SQLException;
	public void insertBoard(QNABoardDTO dto) throws SQLException;
	public void deleteBoard(int num) throws SQLException;
	public void updateBoard(QNABoardDTO dto, int num) throws SQLException;
	public int getCount() throws SQLException;
	public void upCount(int num) throws SQLException;
	public List getCategory() throws SQLException;
}
