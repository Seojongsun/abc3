<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 입력</title>
<c:forEach var="list" items="${list}">
	<%--객체값과 파라미터값이 같은지를 확인하고 반환한다.--%>
	<c:if test="${list.rvno==reviewDTO.rvno}">
		<script type="text/javascript">
			alert("입력하신 ${reviewDTO.rvno}번의 리뷰 번호가 존재합니다. 다시 입력하세요");
			location.href = "./ReviewInsert";
		</script>
	</c:if>
</c:forEach>
</head>
<body>
	<script type="text/javascript">
		alert("입력하신 ${reviewDTO.rvno}번의 리뷰 번호를 등록하였습니다.")
		location.href = "./ReviewSelect"
	</script>
</body>
</html>