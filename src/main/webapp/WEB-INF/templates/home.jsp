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


<ul>
<c:forEach var="task" items="${tasks}">
	<li>${task.title}</li>
	<li>${task.content}</li>
	
	 <s:url value="delete/${task.id}" var="delete"/>	
	 <a href="${delete}">delete</a>
	  <s:url value="edit/${task.id}" var="edit"/>	
	 <a href="${edit}">edit</a>
	
</c:forEach>
</ul>
	
<sf:form method="POST" modelAttribute="task">
	Task Title:<sf:input path="title" /><br>
	Task Content:<sf:input path="content" /><br>
	<input type="submit" value="save"/>
</sf:form>


</body>
<footer></footer>
</html>