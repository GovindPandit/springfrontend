<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href='<sp:url value="/css/book.css"></sp:url>' rel="stylesheet"/>
 <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<c:if test="${empty cartitems}">
		<center><h1>Cart Is Empty</h1></center>
	</c:if>
	
	<div class="container">
		<c:forEach  items="${cartitems}" var="cartitem"> 
		<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="preview col-md-6">
						
						<div class="preview-pic tab-content">
						  <div class="tab-pane active" id="pic-1"><img src="http://placekitten.com/400/252" /></div>
						</div>
					</div>
					<div class="details col-md-6">
						<h3 class="product-title">${cartitem.book.bookname}</h3>
						<p class="product-description">Suspendisse quos? Tempus cras iure temporibus? Eu laudantium cubilia sem sem! Repudiandae et! Massa senectus enim minim sociosqu delectus posuere.</p>
						<h4 class="price">current price: <span>Rs. ${cartitem.book.price}</span></h4>
						<div class="action">
							<a class="btn btn-primary" href="${pageContext.request.contextPath}/cart/remove/${cartitem.cartitemid}">Remove From Cart</a>
							<a class="btn btn-danger" href="${pageContext.request.contextPath}/book/buy">Buy</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
</body>
</html>