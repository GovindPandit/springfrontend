<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container-fluid">
	<table class="table table-striped table-hover">
		<tr>
			<th>Book Id</th>
			<th>Book Name</th>
			<th>Book Author</th>
			<th>Book Price</th>
			<sec:authorize access="hasAuthority('admin') and isAuthenticated()">
			<th>Read</th>
			</sec:authorize>
		</tr>
		<c:forEach items="${books}" var="book">
			<tr class="clickable-row" data-href="${pageContext.request.contextPath}/book/display?bookid=${book.bookid}">
				<td>${book.bookid}</td>
				<td>${book.bookname}</td>
				<td>${book.author}</td>
				<td>${book.price}</td>
				<td>
					<sec:authorize access="hasAuthority('admin') and isAuthenticated()">
					<a href="${pageContext.request.contextPath}/book/edit?bookid=${book.bookid}"  class="btn btn-warning">Edit</a>
					<a href="${pageContext.request.contextPath}/book/delete?bookid=${book.bookid}"  class="btn btn-danger">Delete</a>
					</sec:authorize>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<script>
	$(document).ready(function()
	{
		$(".clickable-row").click(function()
		{
			window.location=$(this).data("href");
		})
	});
</script>
</body>
</html>