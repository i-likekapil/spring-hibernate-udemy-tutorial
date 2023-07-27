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
<h1>MVC HTML Forms</h1>

<form:form action="process-form" modelAttribute="student">
    First name : <form:input path="firstName"/>
    <br>
    <br>
    First name : <form:input path="lastName"/>
    <br>
    <br>
    <%--<form:select path="country">
        <form:option value="India" label="india"/>
        <form:option value="China" label="china"/>
        <form:option value="UK" label="united kingdom"/>
        <form:option value="Russia" label="russia"/>

        
        
    </form:select>--%>
    <form:select path="country">
        <form:options items="${student.countryOptions}"/>
    </form:select>
    <br>
    <br>
    Favourite Programming Language :
    Java <form:radiobutton path="programmingLanguage" value="Java"/>
    Python <form:radiobutton path="programmingLanguage" value="Python"/>
    C++ <form:radiobutton path="programmingLanguage" value="Cpp"/>
    Javascript <form:radiobutton path="programmingLanguage" value="Javascript"/>

    <br>
    <br>
    
    Favourite Operating Systems :

    Linux <form:checkbox path="operatingSystems" value="Linux" />
    Windows <form:checkbox path="operatingSystems" value="Windows"/>
    Mac <form:checkbox path="operatingSystems" value="Mac"/>

    <br>
    <br>

    <input type="submit" value="submit">
</form:form>

</body>
</html>
