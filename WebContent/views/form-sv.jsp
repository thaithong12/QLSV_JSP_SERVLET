<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header-css.jsp" />
<body>
	<div class="container">
		<div class="header">
			<h2 class="text-center">ADD OR UPDATE SV</h2>
		</div>

		<div class="body">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<form action="<c:url value="/sv/insert"/>" method="post">
						<div class="form-group">
							<label for="exampleInputEmail1">MSSV</label> 
							<c:if test="${action == 'edit' }">
								<input type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="id" value="${sv.id}" readonly="readonly">
							</c:if>
							<c:if test="${action != 'edit' }">
								<input type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="id" value="${sv.id}" maxlength="20">
							</c:if>
							
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Name</label> <input
								type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="name" value="${sv.name }" maxlength="20">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Email</label> <input
								type="text" class="form-control" id="exampleInputPassword1" name="email" maxlength="30" value="${sv.emailEducation}" >
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Phone</label> <input
								type="text" class="form-control" id="exampleInputPassword1" name="phone" value="${sv.phoneNumber}">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Address</label> <input
								type="text" class="form-control" id="exampleInputPassword1" maxlength="20" name="address" value="${sv.address }">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Grade</label> 
							<select class="form-control" name="grade">
								<c:forEach items="${lopsvs}" var="item">
									<c:if test="${sv.lopsv_id == item.id }">
										<option value="${item.id}" selected>${item.name}</option>								
									</c:if>
									<c:if test="${sv.lopsv_id != item.id }">
										<option value="${item.id}">${item.name}</option>								
									</c:if>
								</c:forEach>
							</select>
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>
				<div class="col-md-3"></div>
			</div>

		</div>


	</div>

</body>
</html>