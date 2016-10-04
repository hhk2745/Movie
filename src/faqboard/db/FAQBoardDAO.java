package faqboard.db;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface FAQBoardDAO {
	public HashMap search(int startRow, int endRow, String search) throws SQLException;
	public List allListBoard(int startRow, int endRow) throws SQLException;
	public List listBoard(int startRow, int endRow, String mode) throws SQLException;
	public FAQBoardDTO getBoard(int num) throws SQLException;
	public int allGetCount() throws SQLException;
	public int getCount(String mode) throws SQLException;
	public void readCountBoard(int num) throws SQLException;
	public void upCount(int num) throws SQLException;
	public List getCategory() throws SQLException;
}
