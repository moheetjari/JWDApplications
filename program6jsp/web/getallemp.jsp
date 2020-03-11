<%-- 
    Document   : getallemp
    Created on : 11 Mar, 2020, 8:42:34 PM
    Author     : admin
--%>

<%@page import="java.util.List"%>
<%@page import="beans.employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.UserDAO" %>
<jsp:useBean id="e" class="beans.employee" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<employee> list = UserDAO.getAllEmployee();
            request.setAttribute("list", list);
        %>
    <center><h1>Employee</h1></center>
    <table cellspacing="2" cellpadding="2" align="center" border="2">
        <tr>
            <th>Employee Name</th>
            <th>Designation</th>
            <th>Department</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${list}" var="emp">
            <tr>
                <td>
                    ${emp.getEmpname()}
                </td>
                <td>
                    ${emp.getDesignation()}
                </td>
                <td>
                    ${emp.getDeptid()}
                </td>
                <td>
                    <a href="updateemp.jsp?id=${emp.getEmpid()}">Edit</a>
                </td>
                <td>
                    <a href="deleteemp.jsp?id=${emp.getEmpid()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
