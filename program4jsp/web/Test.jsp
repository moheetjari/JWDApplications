<%-- 
    Document   : Test
    Created on : 5 Mar, 2020, 4:40:42 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="Employee.xml" var="employeeInfo"/>
        <x:parse xml="${employeeInfo}" var="result"/>

        <form method="post" action="Test.jsp">
            <select name="drp" onchange="this.form.submit()">
                <option>--SELECT--</option>
                <option value="HR">HR</option>
                <option value="IT">IT</option>
            </select>
        </form>

        <x:forEach select="$result/employees/employee" var="emp">
            <x:set var="dept" select="string($emp/department)"/>
            <c:if test="${dept == param.drp}">
                <x:out select="$emp"/><br>
            </c:if>
        </x:forEach>
    </body>
</html>
