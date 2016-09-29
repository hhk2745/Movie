<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- admin_movie_insertForm.jsp -->
<%@ include file = "../admin_top.jsp"%>

<script type="text/javascript">
	function checkEmpty(){
		if (f.title.value==""){
			alert("제목을 입력해 주세요!!");
			f.title.focus();
			return false;
		}
		if (f.genre.value==""){
			alert("장르를 입력해 주세요!!");
			f.genre.focus();
			return false;
		}
		if (f.grade.value==""){
			alert("제한연령 입력해 주세요!!");
			f.grade.focus();
			return false;
		}
		if (f.country.value==""){
			alert("국가를 입력해 주세요!!");
			f.country.focus();
			return false;
		}
		if (f.country.value==""){
			alert("국가를 입력해 주세요!!");
			f.country.focus();
			return false;
		}
		if (f.country.value==""){
			alert("국가를 입력해 주세요!!");
			f.country.focus();
			return false;
		}
		if (f.opendate.value==""){
			alert("개봉일을 입력해 주세요!!");
			f.opendate.focus();
			return false;
		}
		if (f.director.value==""){
			alert("영화감독을 입력해 주세요!!");
			f.director.focus();
			return false;
		}
		if (f.actor.value==""){
			alert("영화배우를 입력해 주세요!!");
			f.actor.focus();
			return false;
		}
		if (f.runtime.value==""){
			alert("상영시간을 입력해 주세요!!");
			f.runtime.focus();
			return false;
		}
		if (f.movie_info.value==""){
			alert("영화정보를 입력해 주세요!!");
			f.movie_info.focus();
			return false;
		}
		if (f.poster.value==""){
			alert("영화포스터를 등록해 주세요!!");
			f.poster.focus();
			return false;
		}
		
		return true;
	}
</script>
<div align="center">
	<ul class="submenuBox">
		<a href="admin_movie.do">
			<li class="subHover effect">
				<span>영화리스트</span>
			</li>
		</a>
		<a href="admin_movie_insert.do">
			<li class="subHover effect">
				<span>영화추가</span>
			</li>
		</a>
		<!-- <a>
			<li class="subHover effect">
				<span>+</span>
			</li>
		</a> -->
	</ul>
	<hr color="Green" width="99%">
	<h4>영화추가</h4>
	<hr color="Green" width="99%">
	<form name="f" action="admin_movie_updatePro.do" method="post"
   enctype="multipart/form-data">
   <input type="hidden" name="num" value="${dto.num}" >
   <%-- <c:set var="dto" value="${MemberDTO}"> --%>
   <table border="2" class="outline" width="800" align="center">

      <caption>

         <font size="25">영화 수정 페이지</font>
      <td align="center"><font color="red">* 필수 입력 사항</font></td>
      </caption>

      <tr>

         <th class="m2">*영화제목</th>
         <td align="left"><input type="text" size="40" name="title"
            value="${dto.title }"></td>
      </tr>
      <tr>
         <th class="m2">*감독</th>
         <td align="left"><input type="text" name="director"
            value="${dto.director }"></td>
      </tr>
      <tr>
         <th class="m2">*주연배우</th>
         <td align="left"><input type="text" name="actor"
            value="${dto.actor }"> 입력 예시-- 하**,양**,조**</td>
      </tr>
      <tr>
         <th class="m2">*장르</th>
         <td align="left"><input type="text" name="genre"
            value="${dto.genre }"></td>
      </tr>
      <tr>
         <th class="m2">*등급</th>
         <td align="left"><select name="grade">
<%--          <c:forEach var="grade" items="${gradeList}">
            <option value="${grade}"></option>
         </c:forEach> --%>
            <option value="${dto.grade}" selected>${dto.grade}</option>
               <c:if test="${dto.grade!=0 }"><option value="0">0</option></c:if>
               <c:if test="${dto.grade!=12 }"><option value="12">12</option></c:if>
               <c:if test="${dto.grade!=15 }"><option value="15">15</option></c:if>
               <c:if test="${dto.grade!=18 }"><option value="18">18</option></c:if>
               <c:if test="${dto.grade!=19 }"><option value="19">19</option></c:if>
         </select></td>
      </tr>

      <tr>
         <th class="m2">*국가</th>
         <td align="left"><input type="text" name="country"
            value="${dto.country }"></td>
      </tr>
      <tr>
         <th class="m2">*개봉일</th>
         <td align="left">
            <form>
               <input type="text" id="txtDate" value="${dto.opendate }" name="opendate"
                  onclick="fnPopUpCalendar(txtDate,txtDate,'yyyy/mm/dd')"
                  class='text_box1'>
               <script type="text/javascript" src="/js/calendar.js"
                  charset='EUC-KR'></script>
            </form>

         </td>

      </tr>
      <tr>
         <th class="m2">*상영시간</th>
         <td align="left"><input type="text" name="runtime" value="${dto.runtime }"> 단위:
            분</td>
      </tr>
      <!-- <tr>
         <th class="m2">*지점</th>
         <td align="left"><select name="theater">
               <option value="select" selected>지점선택</option>
               <option value="num1">강남</option>
               <option value="num2">강북</option>
               <option value="num3">갓종로</option>
         </select></td>
      </tr>

      <tr>
         <th class="m2">*상영관</th>
         <td align="left"><select name="theaternum">
               <option value="select" selected>상영관선택</option>
               <option value="num1">1관</option>
               <option value="num2">2관</option>
               <option value="num3">3관</option>


         </select></td>
      </tr> -->

      <tr>
         <th class="m2">*줄거리</th>
         <td align="left"><textarea name="movie_info" rows="15" cols="80">${dto.movie_info }</textarea></td>
      </tr>
      <tr>
         <th class="m2">*포스터등록</th>
         <td align="left"><input type="file" name="poster"></td>
      </tr>
      <tr>
         <th class="m2">예고편 등록(선택)</th>
         <td align="left"><input type="file" name="stillcut"><-mp4,
            ogg, webm 파일만 가능합니다.</td>
      </tr>

      <tr>
         <td align="right" colspan="2" class="m1"><input type="submit"
            value="영화수정"> <input type="reset" value="취소"></td>
      </tr>
   </table>
   <%-- </c:set> --%>
</form>
</div>
<%@ include file = "../admin_bottom.jsp"%>