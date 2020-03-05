<%-- 
    Document   : Test
    Created on : 5 Mar, 2020, 3:10:58 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/TestTags.tld" prefix="e"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <e:SQLConnection /><br>
        <e:Employee deptName="IT" /><br>
        <e:ReverseString str="Mohit"/>
    </body>
</html>
