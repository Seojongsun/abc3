<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 리뷰 삭제 </title>


</head>
<body>


	<button type="button" onclick="location.href='./ReviewSelect'">홈</button>


	<form id="delete" name="delete" action="./ReviewDelete" method="post">
		<!-- <form  id="insert" name="insert" action="./ReviewInsert" method="post" enctype="multipart/form-data"> -->
<%-- 		<c:set var="rvdate2" value="<%=new java.util.Date()%>"/> --%>

		임시 리뷰 번호 <input type="number" name="rvno" id="rvno" value="${param.rvno}" readonly="readonly"> <br>
<%-- 		임시 리뷰내용 <input type="text" name="rvcontent" id="rvcontent" value="${reviewDTO.rvcontent}"> <br> --%>
<%-- 		임시 오더넘버 <input type="number" name="rvorderno" id="rvorderno" value="${reviewDTO.rvorderno}"> --%>
<%-- 		<br> 임시 아이디 <input type="text" name="mid" id="mid" value="${reviewDTO.mid}"> <br> --%>

<!-- 		 임시 날짜 <input type="text" name="rvdate" id="rvdate" > -->
<%-- 		 value="<fmt:formatDate value="${rvdate2}" pattern="YYYY-MM-DD "/>">	<br> --%>

<%-- 		임시 평점 <input type="text" name="rvrating" id="rvrating" value="${reviewDTO.rvrating}"> <br> --%>
<%-- 		임시 사이즈평가 <input type="text" name="rvsize" id="rvsize" value="${reviewDTO.rvsize}"> <br> --%>
<%-- 		임시 컬러평가 <input type="text" name="rvcolor" id="rvcolor" value="${reviewDTO.rvcolor}"> <br> --%>

		<!--  임시 파일 <input type="file" name="rvfile" id="rvfile">	<br> -->

<%-- 		임시 나의사이즈 <input type="text" name="mysize" id="mysize" value="${reviewDTO.mysize}"> <br> --%>
<%-- 		임시 나의발볼 <input type="text" name="myfootball" id="myfootball" value="${reviewDTO.myfootball}"> --%>
<%-- 		<br> 임시 나의발등 <input type="text" name="myinstep" id="myinstep" value="${reviewDTO.myinstep}"> --%>
<!-- 		<br> -->

		<div style="text-align: center;">
			--> <input type="submit" value="리뷰 삭제"> <input
				type="reset" value="취소">
		</div>




		<fieldset>
			상품 후기 작성 <br>
			<!-- 		</fieldset> -->
			<!-- 		<fieldset> -->
			<!-- 			<!--  추후 리뷰 작성할 상품과 연동 되게끔 구현 예정 -->
			-->
			<!-- 			<img src="./image/nikewaffle.jpg" height="100" width="100"> <strong> -->
			<!-- 				나이키 와플 트레이너 2 보이그레이드스쿨 <br> NIKE WAFFLE TRAINER 2 BG <br> -->
			<!-- 				245 -->
			<!-- 			</strong> -->
		</fieldset>
		<!-- 		<fieldset> -->
		<!-- 				 공부 후 구현 예정 -->
		<!-- 				<legend> 전체적인 만족도 </legend> -->
		<!-- 				<input type="radio" name="rvrating1" value="1" id="rvrating1" > <label for="rvrating1">⭐</label>  -->
		<!-- 				<input type="radio" name="rvrating2" value="2" id="rvrating2"> <label for="rvrating2">⭐⭐</label>  -->
		<!-- 				<input type="radio" name="rvrating3" value="3" id="rvrating3"> <label for="rvrating3">⭐⭐⭐</label>  -->
		<!-- 				<input type="radio" name="rvrating4" value="4" id="rvrating4"> <label for="rvrating4">⭐⭐⭐⭐</label>  -->
		<!-- 				<input type="radio" name="rvrating5" value="5" id="rvrating5"> <label for="rvrating5">⭐⭐⭐⭐⭐</label>  -->

		<!-- 				<br> <br> 사이즈 만족도 <input type="radio" name="rvsize" id="rvsize" value="10mm정도 작음 ">10mm정도 작음  -->
		<!-- 				<input type="radio" name="rvsize" value="5mm정도 작음">5mm정도 작음  -->
		<!-- 				<input type="radio" name="rvsize" value="적당함 ">적당함  -->
		<!-- 				<input type="radio" name="rvsize" value="5mm정도 큼">5mm정도 큼  -->
		<!-- 				<input type="radio" name="rvsize" value="10mm정도 큼 ">10mm정도 큼  -->

		<!-- 				<br> <br> 색상 만족도 <input type="radio" name="rvcolor" id="rvcolor" value="많이 밝음">많이 밝음  -->
		<!-- 				<input type="radio" name="rvcolor" value="조금 밝음">조금 밝음  -->
		<!-- 				<input type="radio"	name="rvcolor" value="화면과 같음">화면과 같음  -->
		<!-- 				<input type="radio"	name="rvcolor" value="조금 어두움 ">조금 어두움  -->
		<!-- 				<input type="radio" name="rvcolor" value="많이 어두움">많이 어두움  -->



		<!-- 				<br> <br> 나의 사이즈 <input type="button" name="mySize" value="미구현">  -->

		<!-- 				<br> <br> 상품후기 -->
		<!-- 				<textarea  name="rvcontent" id=rvcontent placeholder="최소 20자 이상 입력해 주세요." cols="80" rows="5" maxlength="1000"></textarea> 0 / 1,000 <br> -->
		<!-- 					 텍스트 입력시 입력한 바이트만큼 증가 하는 기능 구현 예정 , 최소 글자수 구현 예정 -->


		<!-- 				 포토/동영상 후기 파일 :  -->

		<!-- 						<div style=" text-align: center;"> -->
		<!-- 				<input  type="submit" value="상품 후기 등록"> -->
		<!-- 				<input type="reset" value="취소"> -->
		<!-- 	</div> -->
		<!-- 		</fieldset> -->
	</form>

	<fieldset>


		&nbsp;&nbsp;&nbsp; &#33;&#33; <strong>상품 후기 작성 안내</strong>
		<ul>

			<li>일반(텍스트) 후기는 500포인트, 포토 후기는 1,000포인트, 동영상 후기는 1,500포인트를
				적립해드립니다. (동영상 후기는 mp4 형식의 파일만 해당됩니다.)</li>
			<li>후기 등록일 이후 최대 3일 이내에 후기 포인트 적립해드립니다. (주말 및 공휴일 제외)</li>
			<li>상품 결제 가격이 2만 원 미만인 경우 후기 포인트가 지급되지 않습니다.</li>
			<li>구매 확정일로부터 30일 이후에 후기를 등록한 경우 후기 포인트가 지급되지 않습니다.</li>
			<li>직접 촬영한 사진 및 동영상이 아닐 경우 포토/동영상 후기에 대한 포인트 지급이 제외됩니다.</li>
			<li>동일한 이미지를 사용하여 여러 번 상품 후기를 등록하시는 경우 포토 후기에 대한 포인트는 한 번만
				지급됩니다.</li>
			<li>허위, 과대광고, 문의 등 후기 내용과 관련 없는 글은 통보 없이 삭제될 수 있습니다.</li>
			<li>포인트는 통합멤버십 회원에게만 지급됩니다.</li>
			<li>상품후기는 A-RT.COM 주문 상품만 작성 가능합니다.</li>
			<li>작성하신 상품후기는 A-RT.COM에 귀속되며, 마케팅 용도로 사용될 수 있습니다.</li>
		</ul>
	</fieldset>





</body>
</html>