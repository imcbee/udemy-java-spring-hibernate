<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Customer Registration  Form</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
	<script src="${pageContext.request.contextPath}/resources/js/simple.test.js"></script>
</head>
<body>

	<i>Fill out form. Asterisk (*) means required.</i>
	
	<br><br>
	
	<form:form action="processForm" modelAttribute="customer">
		First Name: <form:input path="firstName"/>
		
		<br><br>
		
		Last Name (*): <form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error"/>
		
		<br><br>
		
		<input type="submit" Value="Submit"/>
	</form:form>
</body>

</html>