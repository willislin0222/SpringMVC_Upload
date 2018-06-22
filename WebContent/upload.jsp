<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FileUpload DEMO</title>
</head>
<body>
	<form:form  action="insert" enctype="multipart/form-data" modelAttribute="uploadVO">
		<form:input id="name" path="name" type="text" /><br>
		<form:input id="address" path="address" type="text" /><br>
		<form:input id="birthday" path="birthday" type="date" /><br>
		<input name="picture"  type="file" />
		<input type="submit" value="送出">
	</form:form>
</body>
</html>