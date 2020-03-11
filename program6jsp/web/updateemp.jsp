<%-- 
    Document   : updateemp
    Created on : 11 Mar, 2020, 9:39:37 PM
    Author     : admin
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="beans.employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.UserDAO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int empid = Integer.parseInt(request.getParameter("id"));
            employee e = UserDAO.getEmployeeById(empid);
        %>
        <form method="post" action="update.jsp">
            <input type="hidden" name="empid" value="<%=e.getEmpid()%>" />
            <table align="center" cellspacing="2" cellpadding="2">
                <tr>
                    <td>Name</td>
                    <td>
                        <input type="text" name="empname" value="<%=e.getEmpname()%>" />
                    </td>
                </tr>
                <tr>
                    <td>Designation</td>
                    <td>
                        <input type="text" name="designation" value="<%=e.getDesignation()%>" />
                    </td>
                </tr>
                <tr>
                    <td>Department</td>
                    <td>
                        <select name="deptid">
                            <option selected>--SELECT--</option>
                            <%
                                Connection con = null;
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/empprojectdb", "root", "root");
                                    PreparedStatement ps = con.prepareStatement("select * from depttb");
                                    ResultSet rs = ps.executeQuery();

                                    while (rs.next()) {
                            %>
                            <option value="<%=rs.getInt(1)%>"><%=rs.getString(2)%></option>
                            <%
                                    }
                                } catch (ClassNotFoundException | SQLException ex) {
                                    ex.printStackTrace();
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Register" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
