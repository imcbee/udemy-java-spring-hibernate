<!DOCTYPE html>
<html>
<head>
	<title>Hello World - Input  Form</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
	<script src="${pageContext.request.contextPath}/resources/js/simple.test.js"></script>
</head>
<body>
	<form action="processFormVersionTwo" method="GET">
		<input type="text" name="studentName" placeholder="What is your name?" />
		
		<input type="submit"/>
	</form>
</body>

</html>