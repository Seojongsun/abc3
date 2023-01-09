<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


${reviewDTO}

<div>
<a href="./ReviewUpdate?rvno=${reviewDTO.rvno}" >
리뷰 수정
</a>
</div>

<div>
<a href="./ReviewDelete?rvno=${reviewDTO.rvno}" >
리뷰 삭제
</a>
</div>


</body>
</html>