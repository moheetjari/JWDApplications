<%-- 
    Document   : update
    Created on : 11 Mar, 2020, 9:43:34 PM
    Author     : admin
--%>

<%@page import="beans.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="e" class="beans.employee" />
<jsp:setProperty property="*" name="e" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int i = UserDAO.updateEmployee(e);
            response.sendRedirect("getallemp.jsp");
        %>
    </body>
</html>
