<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header-css.jsp" />
<body>
	<div class="container">
		<div class="header">
			<h2 class="text-center">ADD OR UPDATE LOP SV</h2>
		</div>

		<div class="body">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<form action="<c:url value="/lopsv/insert"/>" method="post">
						<div class="form-group">
							<label for="exampleInputEmail1">Code</label> 
							<c:if test="${action == 'edit' }">
								<input type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="id" value="${lopsv.id}" readonly="readonly" placeholder="Ex: 17TCLC2">
							</c:if>
							<c:if test="${action != 'edit' }">
								<input type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="id" value="${lopsv.id}" maxlength="20" placeholder="Ex: 17TCLC2">
							</c:if>
							
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Name</label> <input
								type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="name" value="${lopsv.name }" maxlength="20" placeholder="Ex: Công nghệ thông tin tiếng Nhật">
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