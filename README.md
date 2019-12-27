영화예매사이트
============================

### 목적
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

###### 그림1. 영화목록
![movie list](https://dl.dropbox.com/s/cuhb0ax6hcir7ry/movies_rank.png)

###### 그림2. 한줄평 등록
![reply](https://dl.dropbox.com/s/xm5mkffl2tcn5ow/movie_detail.png)

###### 그림3. 예매
![reservation](https://dl.dropbox.com/s/mrac540s9g6tffg/movie_seat.png)

###### 그림4. 고객센터
![customer center](https://dl.dropbox.com/s/mqk6hurt5r8tuj0/customer_center.png)

### 관리자(Admin)

###### 그림5. 영화등록
![lobby](https://dl.dropbox.com/s/8xhkgrf53chiyit/insert_movie.png)

###### 그림6. 영화수정
![modify_info](https://dl.dropbox.com/s/q2erjm7pc4hrouo/update_movie.png)

###### 그림7. 상영스케줄 관리
![room](https://dl.dropbox.com/s/sfp22jss5k1q7b4/schedule.png)

###### 그림8. 매출정보
![game](https://dl.dropbox.com/s/gdcyw7gn9ew23fp/sell_info.png)

###### 그림9. 고객센터 관리
![game](https://dl.dropbox.com/s/6fvzkxnosj2sc8y/customer_center_mng.png)

### DB
* 상영가능한 영화목록을 불러오는 SELECT문 입니다.
```xml
<select parameterType="int" id="movieSelected" resultType="MovieSelectDTO">
  SELECT
    s.day, s.theater, s.THEATERNUM, s.TITLE, st.time, s.SITCOUNT FROM schedule s, SCHEDULE_TIME st
  WHERE
    ((to_date(s.DAY,'yy/MM/dd')=to_date(sysdate,'yy/MM/dd') and
    substr(st.TIME,1,5) > to_char(sysdate, 'hh24/mm')) or
    to_date(s.DAY,'yy/MM/dd') > to_date(sysdate,'yy/MM/dd')) and
    s.time = st.num and
    s.title = (select title from Movies_info where num = #{num})
    order by s.DAY asc ,st.time asc
</select>
```

### 주요 소스 설명
config 파일(.xml), CRUD중 Read에 대한 설명입니다.
전체 소스를 보고 싶으신분은 [github](https://github.com/hhk2745/SpringProject_Movie-Ticketing-Site) 저장소에서 확인 하실 수 있습니다. 로컬에서 동작하는 프로그램이므로 Oracle 설치, 테이블 생성 후 실행 시켜야 합니다.

* web.xml
```xml
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd" id="WebApp_ID" version="3.1">
  <display-name>ROOT</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
  </welcome-file-list>
  <servlet>
    <servlet-name>springmovie</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>springmovie</servlet-name>
    <url-pattern>*.do</url-pattern>
  </servlet-mapping>
  <filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
      <param-name>encoding</param-name>
      <param-value>UTF-8</param-value>
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
</web-app>
```
.do로 들어오는 요청을 DispatcherServlet에서 감지하고 해당 RequestMapping과 일치하는 Controller에 전송합니다.

* springmovie-servlet.xml
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.1.xsd">

	<context:annotation-config/>
  <bean id="memberDAO" class="member.db.MemberDAOImpl" />
	<bean id="movieDAO" class="admin.movie.db.MovieDAOImpl" />
  ...
  <bean class="admin.category.controller.AdminCategoryListController" />
	<bean class="admin.category.controller.AdminCategoryWriteController" />
</beans>
```
annotation 사용을 위해 설정 <context:annotation-config/>


* Account.xml
```xml
<select id="QNAlistBoard" parameterType="map" resultType="QNABoardDTO">
	select * from (select rownum rn, A.* from (select * from qnaboard where id = #{id} or recipient = #{id} order by re_step asc)A) where rn between #{startRow} and #{endRow}
</select>
```

* SimpleExample.java
``` java
public class SimpleExample {

	/**
	 * SqlMapClient instances are thread safe, so you only need one. In this
	 * case, we'll use a static singleton. So sue me. ;-)
	 */
	private static SqlSessionFactory sqlMapper;

	/**
	 * It's not a good idea to put code that can fail in a class initializer,
	 * but for sake of argument, here's how you configure an SQL Map.
	 */
	static {
		try {
			Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException e) {
			// Fail fast.
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}

  public static List listBoard(HashMap map) {
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("QNAlistBoard", map);
		session.close();
		return list;
	}

}

