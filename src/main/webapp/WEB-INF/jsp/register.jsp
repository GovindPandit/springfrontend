<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<sp:form action="${pageContext.request.contextPath}/user/add" modelAttribute="user">
			<div class="form-group">
				<label>Enter Username</label>
				<sp:input path="username" class="form-control" placeholder="Enter Username"/>
				<sp:errors path="username" cssStyle="color:red"></sp:errors>
			</div>
			<div class="form-group">
				<label>Enter Email</label>
				<sp:input path="email" class="form-control" placeholder="Enter Email"/>
				<sp:errors path="email" cssStyle="color:red"></sp:errors>
			</div>
			<div class="form-group">
				<label>Enter Password</label>
				<sp:password path="password" class="form-control" placeholder="Enter Password"/>
				<sp:errors path="password" cssStyle="color:red"></sp:errors>
			</div>
			<div class="form-group">
				<input type="submit" value="Register" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
		</sp:form>
	</div>
</body>
</html>