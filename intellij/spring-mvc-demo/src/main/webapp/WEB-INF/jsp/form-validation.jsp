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
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>
<h1>MVC HTML Forms for hibernate validation</h1>

<form:form action="process-form" modelAttribute="customer">

    First name : <form:input path="firstName"/>
    <br>
    <br>
    First name : <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error"/>
    <br>
    <br>
    Number of free passes : <form:input path="freePasses"/>
    <form:errors path="freePasses" cssClass="error"/>
    <br>
    <br>
    Postal Code : <form:input path="postalCode"/>
    <form:errors path="postalCode" cssClass="error"/>
    <br>
    <br>
    <input type="submit" value="submit">
</form:form>

</body>
</html>
