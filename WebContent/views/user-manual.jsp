<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="header-css.jsp"/>
<body>
	<div class="container">
		<h2 class="text-center">HƯỚNG DẪN SỬ DỤNG QLSV</h2>
		<div class="row">
			<div class="col-md-6">
				<p>1. QL Lớp SV</p>
				<p>
					Click vào <a href = "<c:url value="/lopsv"/>">đây</a> để ra trang QL lớp SV
				</p>
				<p>Trong đó: </p>
				<ul>
					<li>Click Add để thêm Lớp SV</li>
					<li>Click Edit để sửa thông tin lớp </li>
					<li>Click Delete để xóa Lớp</li>
				</ul>
			</div>
			<div class="col-md-6">
				<p>2. QL SV</p>
				<p>
					Click vào <a href="<c:url value = "/sv"/>">đây</a> để ra trang SV
				</p>
				<p>Trong đó: </p>
				<ul>
					<li>Click Add để thêm SV</li>
					<li>Click Edit để sửa thông tin SV </li>
					<li>Click Delete để xóa SV</li>
				</ul>
			</div>
		</div>
		<p><strong>1 LỚP SV CÓ NHIỀU SV</strong></p>
	</div>
</body>
</html>