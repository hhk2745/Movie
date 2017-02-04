영화예매사이트
============================

목적
----------------------------
* Springframework기반 영화예매사이트를 개발해 봄으로써 Spring을 학습함.

### 개발 환경
* java 1.8, jsp, mybatis 3.2, spring 3.8.1, ApacheTomcat8.0, Oracle11g

### 기능 목록
* 고객(Customer)
예매,확인,취소, 마이페이지, CRUD게시판
* 관리자(Admin)
상영스케줄, 회원, 매출정보, 고객센터 관리

### 고객(Customer)
영화목록(모든영화, 현재 개봉작, 박스오피스, 개봉 예정작), 한줄평, 예매, 고객센터

![movie list](https://dl.dropbox.com/s/cuhb0ax6hcir7ry/movies_rank.png)
<p align="center">그림1. 영화목록</p>

![reply](https://dl.dropbox.com/s/xm5mkffl2tcn5ow/movie_detail.png)
<p align="center">그림2. 한줄평 등록</p>

![reservation](https://dl.dropbox.com/s/mrac540s9g6tffg/movie_seat.png)
<p align="center">그림3. 예매</p>

![customer center](https://dl.dropbox.com/s/mqk6hurt5r8tuj0/customer_center.png)
<p align="center">그림4. 고객센터</p>

### 관리자(Admin)
영화등록,수정,상영스케줄,매출정보,고객센터관리

![lobby](https://dl.dropbox.com/s/8xhkgrf53chiyit/insert_movie.png)
<p align="center">그림5. 영화등록</p>

![modify_info](https://dl.dropbox.com/s/q2erjm7pc4hrouo/update_movie.png)
<p align="center">그림6. 영화수정</p>

![room](https://dl.dropbox.com/s/sfp22jss5k1q7b4/schedule.png)
<p align="center">그림7. 상영스케줄 관리</p>
<p align="center">
![game](https://dl.dropbox.com/s/gdcyw7gn9ew23fp/sell_info.png)
그림8. 매출정보</p>

![game](https://dl.dropbox.com/s/6fvzkxnosj2sc8y/customer_center_mng.png)
<p align="center">그림9. 고객센터 관리</p>

### DB
* 기본키는 시퀀스.nextval로 회원의 고유번호를 부여합니다.
```sql
CREATE TABLE "USER"."MEMBER"
(
   "NUM" NUMBER,
   "ID" VARCHAR2(25 BYTE) NOT NULL,
   "PW" VARCHAR2(25 BYTE) NOT NULL,
   "email" VARCHAR2(50 BYTE) NOT NULL,
   "regdate" VARCHAR2(8 BYTE) NOT NULL
   CONSTRAINT PK_USERS PRIMARY KEY(NUM)
);
```

### 주요 클래스 설명
변형체스게임을 구성하는 클래스에 대한 설명입니다.
MVC에 대한 개념이 없을 때 개발되어 java코드내에 SQL문이 직접 하드코딩 되어 있습니다.
데이터베이스 접속은 ojdbc6을 라이브러리에 추가하여 연동합니다.
READEME.md가 너무 길어지는 것 같아 주요 소스(Server, Client)만 설명드린 점 양해 부탁드립니다.
전체 소스를 보고 싶으신분은 [github](https://github.com/hhk2745/JavaProject_Movie-KnightGame) 저장소에서 확인 하실 수 있습니다. 로컬에서 동작하는 프로그램이므로 Oracle 설치, 테이블 생성 후 실행 시켜야 합니다.

* 사용자의 상태를 나타내는 DemandChart 인터페이스 입니다.
```java
public interface DemandChart
{
	public static final int LOGOUT = -2;
	public static final int LOGIN = 0;
	public static final int CHANGE_USER_LOCATION = 1;
	public static final int CHATTING = 2;
	public static final int UPDATE_USERCHART = 3;
	public static final int READY = 4;
	public static final int GAME_START = 5;
	public static final int SENDING_BOARD = 6;
	public static final int TURN_CHANGE = 7;
	public static final int END_GAME = 8;
}
```

* Server

```java
class ServerReceiver extends Thread implements DemandChart
{
	HashMap<MemberDTO, ObjectOutputStream> clients;
	HashMap<Integer, HashMap<MemberDTO, Boolean>> roomInfo;
	ObjectOutputStream oos;
	ObjectInputStream ois;
  public ServerReceiver(Socket socket, HashMap<MemberDTO, ObjectOutputStream> clients,
			HashMap<Integer, HashMap<MemberDTO, Boolean>> roomInfo){}
  @Override
	public void run(){}
  synchronized public void process(Demand demand) throws IOException{}

  public class KnightGameServer
  {
  	HashMap<MemberDTO, ObjectOutputStream> clients = new HashMap<>();
  	HashMap<Integer, HashMap<MemberDTO, Boolean>> roomInfo = new HashMap<>();

  	public KnightGameServer()
  	{
  		try
  		{
  			ServerSocket serverSocket = new ServerSocket(12345);
  			while (true)
  			{
  				Socket socket = serverSocket.accept();
  				System.out.println(">> Accept LOG :::: " + socket);
  				new ServerReceiver(socket, clients, roomInfo).start();
  			}
  		} catch (Exception e){e.printStackTrace();}
  	}
  	public static void main(String[] args)
  	{
  		new KnightGameServer();
  	}
  }
}
```

* Client

```Java
public class KnightGameClient implements DemandChart, KnightGameInfo
{
	public ClientSender sender;
	public ClientReceiver receiver;
	public ObjectOutputStream oos;
	public ObjectInputStream ois;
	public MemberDTO user;
	public MemberDAO dao;
	public LoginGUI login;
	public LobbyGUI lobby;
	public RoomGUI room;
	public KnightGameMain main;
	public JTextArea chatArea;
	public JTextField chat;
	public JButton logout;
	public Vector<MemberDTO> userChart;
	public boolean start = false;

	public KnightGameClient(){}
	class ClientSender{}
	class ClientReceiver extends Thread
  {
		public ObjectInputStream ois;
		public ClientReceiver(ObjectInputStream ois){}
		@Override
		public void run(){}
		public void process(Result result) throws IOException{}
	}

	LoginGUI newLogin(String str) throws IOException
  {
		login.loginBtn.addActionListener(new ActionListener() {});
		return login;
	}

	public static void main(String[] args)
  {
		new KnightGameClient();
	}
}
```

### 후기

위와 같이 java로 소켓 프로그래밍을 개발해 보았습니다.
객체직렬화를 하기 위해 Serializable 인터페이스를 구현 하였고,
ObjectInputStream,ObjectOutputStream클래스는 readObject(), writeObject()를 통해 객체를 입출력 하기 위해 사용되었습니다.
게임 방에 입장하는 부분에서 동기화가 필요했는데 ArrayList에 DTO를 담아서 전송하니 리스트 내의 모든 DTO가 index 0번의 정보로 복사되어 애를 먹었습니다... 레퍼런스를 참조하여 동기화를 보장하지 않는 ArrayList 대신에 Vector클래스를 권장 하고 있어 해결할 수 있었습니다.
디자인패턴에서 Command 패턴을 흉내내서 모든 명령(Demand)를 캡슐화 하여 설계해 보았습니다.
