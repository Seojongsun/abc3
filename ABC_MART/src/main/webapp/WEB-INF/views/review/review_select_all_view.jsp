<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<header>
		<div>
			<h1>리뷰 전체 조회</h1>
		</div>
	</header>

	<section></section>
	<section>
		<div>
			<h5>리뷰 목록</h5>
		</div>

		<table>
			<tr>
				<th>리뷰 번호</th>
				<th>리뷰 내용</th>
				<th>리뷰 작성날짜</th>
			</tr>

			<tbody>
				<c:forEach var="list" items="${list}">
					<tr>
						<td>${list.rvno}</td>
						<td>${list.rvcontent}</td>
						<td>${list.rvdate}</td>
					
						<td>
						<button type="button" onclick="location.href='./ReviewSelectDetail?rvno=${list.rvno}'">리뷰 상세 보기</button>
						</td>
					</tr>
					
				</c:forEach>
					<c:if test="${empty  list }">
					
					<tr>
						<td>등록된 리뷰가 없습니다.</td>
					</tr>
					</c:if>
			</tbody>
		</table>
		<div>
			<button type="button" onclick="location.href='./ReviewInsert'"> 리뷰 작성 </button>
		</div>


	</section>








</body>
</html>