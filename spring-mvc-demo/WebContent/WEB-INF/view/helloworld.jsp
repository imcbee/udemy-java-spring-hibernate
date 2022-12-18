<!DOCTYPE html>
<html>
<head>
	<title>Hello World</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
	<script src="${pageContext.request.contextPath}/resources/js/simple.test.js"></script>

</head>
<body>


Hello World of Spring!

<br><br>

Student Name: ${param.studentName}

<br><br>

The Message: ${message}
</body>

</html>