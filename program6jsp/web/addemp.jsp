<%-- 
    Document   : addemp
    Created on : 11 Mar, 2020, 8:05:27 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.UserDAO" %>
<jsp:useBean id="e" class="beans.employee" />
<jsp:setProperty property="*" name="e"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int i = UserDAO.addEmployee(e);
            if (i > 0) {
                response.sendRedirect("getallemp.jsp");
            } else {
                response.sendRedirect("Registration.jsp");
            }
        %>
    </body>
</html>
