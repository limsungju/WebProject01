<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script src="${path}/ckeditor/ckeditor.js"></script>
<c:if test="${sessionScope.admin_userid == null }">
	<script>
	alert("로그인 하신 후 사용하세요.");
	location.href="${path}/admin/login.do";
	</script>
</c:if>
<script>
function product_write() {
	// 태그를 name으로 조회할 경우
	// var product_name=document.form1.product_name.value;
	// 태그를 id로 조회할 경우
	var product_name=document.form1.product_name.value;
	var price=document.form1.price.value;
	var description=document.form1.description.value;
	if(product_name == "") { //빈값이면
		alert("상품명을 입력하세요");
		document.form1.product_name.focus(); //입력포커스 이동
		return; //함수 종료, 폼 데이터를 제출하지 않음
	}
	if(price == "") {
		alert("가격을 입력하세요");
		document.form1.price.focus();
		return;
	}
	/* if(description == "") { // ckeditor를 적용시키면 id값이 변경되기 때문에 주석으로 묶어둔것
		alert("상품설명을 입력하세요.");
		document.form1.description.focus();
		return;
	} */
	document.form1.action="${path}/shop/product/insert.do";
	document.form1.submit();
}
</script>
</head>
<body>
<%@ include file="../include/admin_menu.jsp" %>
<h2>상품등록</h2>
<form id="form1" name="form1" method="post" enctype="multipart/form-data">
<table>
	<tr>
		<td>상품명</td>
		<td><input name="product_name"></td>
	</tr>
	<tr>
		<td>가격</td>
		<td><input name="price"></td>
	</tr>
	<tr>
		<td>상품설명</td>
		<td><textarea rows="5" cols="60" name="description" id="description"></textarea></td>
		
	</tr>
<script>
	//id가 description인 태그에 ckeditor를 적용시킴
	//CKEDITOR.replace("description"); //이미지 업로드 안됨
	CKEDITOR.replace("description",{
		filebrowserUploadUrl : "${path}/imageUpload.do"
	});
</script>
	<tr>
		<td>상품이미지</td>
		<td><input type="file" name="file1"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="button" value="등록" onclick="product_write()">
			<input type="button" value="목록" onclick="location.href='${path}/shop/product/list.do'">
		</td>
	</tr>
</table>
</form>
</body>
</html>