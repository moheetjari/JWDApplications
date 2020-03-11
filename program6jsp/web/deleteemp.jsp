<%-- 
    Document   : deleteemp
    Created on : 11 Mar, 2020, 9:52:14 PM
    Author     : admin
--%>

<%@page import="beans.employee"%>
<%@page import="beans.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="e" class="beans.employee" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int empid = Integer.parseInt(request.getParameter("id"));
            UserDAO.deleteEmployee(empid);
            response.sendRedirect("getallemp.jsp");
        %>
    </body>
</html>
