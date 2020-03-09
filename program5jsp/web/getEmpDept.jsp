<%-- 
    Document   : getEmpDept
    Created on : 9 Mar, 2020, 9:06:23 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head> 
    <body>
        <%
            String deptId = request.getParameter("deptId");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/employeedb", "root", "root");
            PreparedStatement ps = con.prepareStatement("select e.employeename from employee e,department d where e.departmentid = d.id and d.id = ?");
            ps.setString(1, deptId);
            ResultSet rs = ps.executeQuery();
            out.println("<select id='drpEmp'>");
            while (rs.next()) {
                out.println("<option>" + rs.getString(1) + "</option>");
            }
            out.println("</select>");
        %>
    </body>
</html>
