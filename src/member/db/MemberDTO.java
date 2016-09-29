package member.db;

public class MemberDTO
{
	private int num; // member_seq
	private String name;
	private String id;
	private String pw;

	private String ssn; // 주민번호
	private String email;
	private String hp;

	private int money; // 돈
	private int point; // 마일리지 포인트

	private String profile_img;

	private String confirm;
	private String nickname;

	public int getNum()
	{
		return num;
	}

	public void setNum(int num)
	{
		this.num = num;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getPw()
	{
		return pw;
	}

	public void setPw(String pw)
	{
		this.pw = pw;
	}

	public String getSsn()
	{
		return ssn;
	}

	public void setSsn(String ssn)
	{
		this.ssn = ssn;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getHp()
	{
		return hp;
	}

	public void setHp(String hp)
	{
		this.hp = hp;
	}

	public int getMoney()
	{
		return money;
	}

	public void setMoney(int money)
	{
		this.money = money;
	}

	public int getPoint()
	{
		return point;
	}

	public void setPoint(int point)
	{
		this.point = point;
	}

	public String getProfile_img()
	{
		return profile_img;
	}

	public void setProfile_img(String profile_img)
	{
		this.profile_img = profile_img;
	}

	public String getConfirm()
	{
		return confirm;
	}

	public void setConfirm(String confirm)
	{
		this.confirm = confirm;
	}

	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	@Override
	public String toString()
	{
		return "MemberDTO [num=" + num + ", name=" + name + ", id=" + id + ", pw=" + pw + ", ssn=" + ssn + ", email="
				+ email + ", hp=" + hp + ", money=" + money + ", point=" + point + ", profile_img=" + profile_img
				+ ", confirm=" + confirm + ", nickname=" + nickname + "]";
	}



	
	
}
