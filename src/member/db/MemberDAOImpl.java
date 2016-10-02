package member.db;

import java.sql.SQLException;
import java.util.List;

import member.db.MemberDTO;
import member.mybatis.SimpleExample;

public class MemberDAOImpl implements MemberDAO
{
	/*Client*/
	
	@Override
	public List all() throws SQLException{
		return SimpleExample.all();
	}
	
	@Override
	public MemberDTO checkMember(String name, String ssn, String hp) throws SQLException
	{
		System.out.println(name+ ssn+ hp);
		return SimpleExample.checkMember(name, ssn, hp);
	}

	@Override
	public void insertMember(MemberDTO dto) throws SQLException
	{
		SimpleExample.insertMember(dto);
	}

	@Override
	public MemberDTO getMember(String id, String pw) throws SQLException
	{
		return SimpleExample.getMember(id, pw);
	}

	@Override
	public int upPoint(String id,int count) throws SQLException{
		// TODO Auto-generated method stub
		return SimpleExample.upPoint(id,count);
	}
	
	@Override
	public int downPoint(String id) throws SQLException {
		// TODO Auto-generated method stub
		return SimpleExample.downPoint(id);
	}
	
	/*Admin*/
	@Override
	public int memberGetCount() throws SQLException
	{
		return SimpleExample.memberGetCount();
	}

	@Override
	public List<MemberDTO> listMember(int start, int end) throws SQLException
	{
		List list = null;
		try {
			list = SimpleExample.listMember(start, end);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public MemberDTO getMemberAdmin(int num) throws SQLException
	{
		System.out.println("MemberDAOImpl"+num);
		MemberDTO dto = null;
		
		dto = SimpleExample.getMemberAdmin(num);
		
		return dto;
	}

	@Override
	public int updateMember(MemberDTO dto) throws SQLException
	{
		int res = 0;
		res = SimpleExample.updateMember(dto);
		
		return res;
	}

	@Override
	public int deleteMember(int num) throws SQLException
	{
		int res = 0;
		res = SimpleExample.deleteMember(num);
		return res;
	}

	@Override
	public MemberDTO serchID(String name, String email) throws SQLException
	{
		return SimpleExample.serchID(name, email);
		
	}

	@Override
	public MemberDTO serchPW(String name, String id, String email) throws SQLException
	{
		return SimpleExample.serchPW(name, id, email);
	}
	
	@Override
	public int approve(String id) throws SQLException
	{
		System.out.println("Impl in id : "+id);
		return SimpleExample.approve(id);
	}

	@Override
	public void insertMoney(MemberDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		SimpleExample.insertMoney(dto);
	}

	@Override
	public int updateNickname(String id, String nickname) throws SQLException
	{
		// TODO Auto-generated method stub
		return SimpleExample.updateNickname(id, nickname);
	}

	@Override
	public int updateProfile_img(String id, String profile_img) throws SQLException
	{
		return SimpleExample.updateProfile_img(id, profile_img);
	}

	@Override
	public MemberDTO idCheck(String id) throws SQLException
	{
		// TODO Auto-generated method stub
		return SimpleExample.idCheck(id);
	}
	
}
