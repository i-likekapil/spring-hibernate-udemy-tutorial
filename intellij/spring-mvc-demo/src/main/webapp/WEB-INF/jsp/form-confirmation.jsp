<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: cavisson
  Date: 27/07/23
  Time: 12:32 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MVC Form</title>
</head>
<body>
<h1>MVC HTML Forms with hibernate validation</h1>
<h1>Result </h1>
<h2>First Name is ${customer.firstName}</h2>
<h2>Last Name is ${customer.lastName} </h2>
<h2>Postal Code is ${customer.postalCode} </h2>
<h2>Number of free passes is ${customer.freePasses} </h2>

</body>
</html>
