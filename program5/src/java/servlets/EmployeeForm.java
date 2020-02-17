/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class EmployeeForm extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmployeeForm</title>");
            out.println("</head>");
            out.println("<body>");

            String Id = "";
            String EmployeeName = "";
            String EmployeeSalary = "";
            String employeeId = request.getParameter("employeeId");
            String DepartmentId = "";
            String deptId = "";
            String DepartmentName = "";
            if (employeeId != null) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/employeedb", "root", "root");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE WHERE ID = " + employeeId + "");
                    rs.next();
                    Id = rs.getString(1);
                    EmployeeName = rs.getString(2);
                    EmployeeSalary = rs.getString(3);
                    deptId = rs.getString(4);
                } catch (ClassNotFoundException | SQLException ex) {
                    out.println(ex);
                }
            }
            out.println("<form method='post' action='AddEmployee'>");
            out.println("<table cellspacing='2' cellpadding='2' align='center'>");
            out.println("<tr>");
            out.println("<td>DepartmentName:</td>");
            if (employeeId == null) {
                out.println("<h1><center>Add Employee</center></h1>");
                out.println("<td><input type='text' placeholder='Enter Employee Name..' name='txtEmployeeName'></td>");
            } else {
                out.println("<h1><center>Edit Employee</center></h1>");
                out.println("<td><input type='text' name='txtEmployeeName' value='" + EmployeeName + "'></td>");
            }
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Salary:</td>");
            if (employeeId == null) {
                out.println("<td><input type='number' placeholder='Enter Employee Salary..' name='txtEmployeeSalary'></td>");
            } else {
                out.println("<td><input type='text' name='txtEmployeeSalary' value='" + EmployeeSalary + "'></td>");
                out.println("<td><input type='text' name='txtEmployeeId' value='" + employeeId + "'></td>");
            }
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Department:</td>");
            out.println("<td><select name='txtEmployeeDepartment'>");
            if (employeeId == null) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/employeedb", "root", "root");
                    Statement stmt = con.createStatement();
                    ResultSet ds = stmt.executeQuery("SELECT * FROM DEPARTMENT");
                    while (ds.next()) {
                        DepartmentId = ds.getString(1);
                        DepartmentName = ds.getString(2);
                        out.println("<option value='" + DepartmentId + "'>" + DepartmentName + "</option>");
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    out.println(ex);
                }
            } else {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/employeedb", "root", "root");
                    Statement stmt = con.createStatement();
                    ResultSet ds = stmt.executeQuery("SELECT * FROM DEPARTMENT");
                    while (ds.next()) {
                        DepartmentId = ds.getString(1);
                        DepartmentName = ds.getString(2);

                        if (DepartmentId.equals(deptId)) {
                            out.println("<option value='" + DepartmentId + "' selected>" + DepartmentName + "</option>");
                        } else {
                            out.println("<option value='" + DepartmentId + "'>" + DepartmentName + "</option>");
                        }
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    out.println(ex);
                }
            }
            out.println("</select></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td><input type='submit' name='btnSubmit' value='Submit' ></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
