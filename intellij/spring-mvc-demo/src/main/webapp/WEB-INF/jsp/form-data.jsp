<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cavisson
  Date: 27/07/23
  Time: 12:43 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MVC Form Process Data</title>
</head>
<body>
<h2>Student Data after processing</h2>
<h2>First name is ${student.firstName}</h2>
<h2>Last name is ${student.lastName}</h2>
<h2>Country is ${student.country}</h2>
<h2>Favourite Programming language is ${student.programmingLanguage}</h2>
<h2>Operating Systems </h2>
<ul>
    <c:forEach var="arr" items="${student.operatingSystems}">

        <li> ${arr} </li>

    </c:forEach>
</ul>
</body>
</html>
