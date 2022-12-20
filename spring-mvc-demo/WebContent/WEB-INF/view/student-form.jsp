<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Student Registration Form</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
	<script src="${pageContext.request.contextPath}/resources/js/simple.test.js"></script>
</head>
<body>
	
	<form:form action="processForm" modelAttribute="student">
		
		First Name: <form:input path="firstName"/>
	
	<br><br>
		
		Last Name: <form:input path="lastName"/>
 
	<br><br>
		
		<input type="submit" value="submit"/>
		
	</form:form>

</body>

</html>