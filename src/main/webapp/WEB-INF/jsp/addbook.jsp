<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
<c:if test="${b==null}">
	<sp:form action="${pageContext.request.contextPath}/book/add" modelAttribute="book">
		<div class="form-group">
			<label>Enter BookName</label>
			<sp:input path="bookname" class="form-control" placeholder="Enter Bookname"/>
		</div>
		<div class="form-group">
			<label>Enter Author</label>
			<sp:input path="author" class="form-control" placeholder="Enter Author"/>
		</div>
		<div class="form-group">
			<label>Enter Price</label>
			<sp:input path="price" class="form-control" placeholder="Enter Price"/>
		</div>
		<div class="form-group">
			<label>Enter Link</label>
			<sp:input path="link" class="form-control" placeholder="Enter Link"/>
		</div>
		<div class="form-group">
			<input type="submit" value="Add Book" class="btn btn-primary btn-block"/>
			<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
		</div>
	</sp:form>
</c:if>
<c:if test="${b!=null}">
	<sp:form action="${pageContext.request.contextPath}/book/update" modelAttribute="b">
		<div class="form-group">
			<label>Enter BookId</label>
			<sp:input path="bookid" class="form-control" placeholder="Enter Bookid"/>
		</div>
		<div class="form-group">
			<label>Enter BookName</label>
			<sp:input path="bookname" class="form-control" placeholder="Enter Bookname"/>
		</div>
		<div class="form-group">
			<label>Enter Author</label>
			<sp:input path="author" class="form-control" placeholder="Enter Author"/>
		</div>
		<div class="form-group">
			<label>Enter Price</label>
			<sp:input path="price" class="form-control" placeholder="Enter Price"/>
		</div>
		<div class="form-group">
			<label>Enter Link</label>
			<sp:input path="link" class="form-control" placeholder="Enter Link"/>
		</div>
		<div class="form-group">
			<input type="submit" value="Update Book" class="btn btn-primary btn-block"/>
			<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
		</div>
	</sp:form>
</c:if>
</div>
</body>
</html>