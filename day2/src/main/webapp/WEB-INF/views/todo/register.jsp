<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<img alt="" src="/resources/sample.jpg"> <!-- alt: 이미지 제대로 안나왔을때 나오는 것 -->
<form method="post"> <!-- 등록은 포스트. 액션은 생략하면 유알엘 경로가 디폴트. -->
	<input type='text' name='title' value='한글테스트'> <!-- 한글깨짐 -->
	<br/>
	<input type='date'name='regdate'>
		<button>Save</button>
</form>




</body>
</html>