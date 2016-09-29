package qnaboard.db;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface QNABoardDAO
{
	// QNABoard 답글형(계층형) 게시판(questions and answer // Q&A)
	/* 관리자에게 직접적으로 질문하는 게시판, 관리자는 답글형태로 답변함. */

	public List listBoard(int startRow, int endRow, String id) throws SQLException;
	public QNABoardDTO getBoard(int num) throws SQLException;
	public void insertBoard(QNABoardDTO dto) throws SQLException;
	public void deleteBoard(int num) throws SQLException;
	public void updateBoard(QNABoardDTO dto, int num) throws SQLException;
	public int getCount() throws SQLException;
	public void upCount(int num) throws SQLException;
	public List getCategory() throws SQLException;
}
