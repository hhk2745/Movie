<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../top.jsp"%>

<script type="text/javascript">
	function checkBoard(){
		if (f.content.value==""){
			alert("내용을 입력해 주세요!!");
			f.content.focus();
			return false;
		}
		if (f.fileName.value==""){
			alert("이미지를 첨부해 주세요!!");
			f.fileName.focus();
			return false;
		}
		return true;
	}
</script>
<section class="content">
	<nav>
	</nav>
	<main>
		<div align="center">
		<form name="f" action="fileboard_writePro.do" method="post" onsubmit="return checkBoard()" enctype="multipart/form-data">
		<table border="1" width="90%">
			<tr bgcolor="yellow">
				<th colspan="2">인증샷 남기기</th>
			</tr>
			<tr>
				<th bgcolor="yellow">내용</th>
				<td>
					<textarea name="content" cols="60" rows="10" maxlength="100"></textarea>
				</td>
			</tr>
			<tr>
				<th bgcolor="yellow">사진파일 선택</th>
				<td>
					<input type="file" name="fileName">
				</td>
			</tr>
			<tr>
				<td colspan="3" bgcolor="yellow" align="center">
					<input type="hidden" name="id" value="${loginId.id}" />
				
					<input type="submit" value="글쓰기">
					<input type="reset" value="다시쓰기">
					<input type="button" value="목록보기" onClick="window.location='fileboard_list.do'">
				</td>
			</tr>
		</table>
		</form>
	</div>
	</main>
</section>

<%@ include file="../../../bottom.jsp"%>