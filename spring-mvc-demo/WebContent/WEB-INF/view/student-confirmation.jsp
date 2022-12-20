<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Student Confirmation</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
	<script src="${pageContext.request.contextPath}/resources/js/simple.test.js"></script>
</head>
<body>
	
	The student is confirmed: ${student.firstName} ${student.lastName}
	
	<br><br>
	
	Country: ${student.country}
	
	<br><br>
	
	Favorite Language: ${student.favoriteLanguage}
	
	<br><br>
	
	Operation System: 
	<ul>
		<c:forEach var="opsys" items="${student.operatingSystems}"> 
		
			<li>${opsys}</li>
		
		</c:forEach>
		
	</ul>

</body>

</html>