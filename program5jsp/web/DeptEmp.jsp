<%-- 
    Document   : DeptEmp
    Created on : 9 Mar, 2020, 8:35:08 PM
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
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/employeedb", "root", "root");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from department");
        %>
        Department:<select id="drpDept"onchange="getEmp(this)">
            <option>--SELECT--</option>
            <%
                while (rs.next()) {
            %>
            <option value="<%=rs.getInt("Id")%>"><%=rs.getString("departmentname")%></option>
            <%
                    }
                } catch (Exception ex) {
                    out.println(ex);
                }
            %>
        </select>
        <br>
        <div id="EmpList">            
        </div>
    </body>
</html>
<script>
    function getEmp(deptId) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("EmpList").innerHTML = this.responseText;
            }
        };
        xhttp.open("GET", "getEmpDept.jsp?deptId=" + deptId.value);
        xhttp.send();
    }
</script>
