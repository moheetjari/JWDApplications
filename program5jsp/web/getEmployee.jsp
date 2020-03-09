<%-- 
    Document   : getEmployee
    Created on : 9 Mar, 2020, 3:13:01 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            try {
                String empName = request.getParameter("emp");

                if (!empName.equals("") && empName != null) {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/employeedb", "root", "root");
                    Statement stmt = con.createStatement();
                    PreparedStatement ps = con.prepareStatement("select * from employee where employeename like '" + empName + "%'");
                    ResultSet rs = ps.executeQuery();
                    out.println("<table cellspacing='2' cellpadding='2' align='center' border='2'>");
                    out.println("<tr>");
                    out.println("<th>EmployeeName</th>");
                    out.println("<th>Salary</th>");
                    out.println("</tr>");
                    out.println("<tr>");
                    while (rs.next()) {
                        out.println("<td>" + rs.getString("employeename") + "</td>");
                        out.println("<td>" + rs.getString("salary") + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                }
            } catch (Exception ex) {
                out.println(ex);
            }
        %>        
    </body>
</html>
