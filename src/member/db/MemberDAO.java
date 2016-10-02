package member.db;

import java.sql.SQLException;
import java.util.List;

public interface MemberDAO
{
	/*Client*/
	public List all() throws SQLException;
	
	public MemberDTO checkMember(String name, String ssn, String hp) throws SQLException;

	public void insertMember(MemberDTO dto) throws SQLException;
	
	public MemberDTO getMember(String id, String pw) throws SQLException;
	
	public MemberDTO serchID(String name, String email) throws SQLException;

	public MemberDTO serchPW(String name, String id, String email) throws SQLException;
	
	public void insertMoney(MemberDTO dto) throws SQLException;
	
	public int approve(String id)throws SQLException;
	
	public int updateNickname(String id, String nickname) throws SQLException;
	
	public int updateProfile_img(String id, String profile_img) throws SQLException;
	
	public MemberDTO idCheck(String id)throws SQLException;

	public int upPoint(String id,int count) throws SQLException;
	
	public int downPoint(String id) throws SQLException;
	
	/*Admin*/
	public int memberGetCount() throws SQLException; 

	public List<MemberDTO> listMember(int start, int end) throws SQLException; //리스트

	public MemberDTO getMemberAdmin(int num) throws SQLException; //상세정보

	public int updateMember(MemberDTO dto) throws SQLException; //수정

	public int deleteMember(int num) throws SQLException; //삭제
	
	
	
	
}
