<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
	<title>Home Page</title>
</head>
<header></header>
<body>

<h1> Edit Task:</h1>

	
	<sf:form method="POST" modelAttribute="task">
	
	New Task Title:<sf:input path="title" /><br>
	New Task Content:<sf:input path="content" /><br>
	<input type="submit" value="update"/>
    </sf:form>

</body>
<footer></footer>
</html>