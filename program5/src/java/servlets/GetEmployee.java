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
public class GetEmployee extends HttpServlet {

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
            out.println("<title>Servlet GetEmployee</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1><center>Employees</center></h1>");
            out.println("<table border='1' align='center' cellspacing='2' cellpadding='2'>");
            out.println("<center><a href='http://localhost:8080/program5/EmployeeForm'>Add Employee</a></center>");
            out.println("<br>");
            out.println("<tr>");
            out.println("<th>Id</th>");
            out.println("<th>EmployeeName</th>");
            out.println("<th>Salary</th>");
            out.println("<th>DepartmentId</th>");
            out.println("<th>Edit</th>");
            out.println("<th>Delete</th>");
            out.println("</tr>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/employeedb", "root", "root");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");

                while (rs.next()) {
                    out.println("<tr>");
                    Integer EmployeeId = rs.getInt(1);
                    String EmployeeName = rs.getString(2);
                    Integer EmployeeSalary = rs.getInt(3);
                    Integer DepartmentId = rs.getInt(4);
                    out.println("<td>" + EmployeeId + "</td>");
                    out.println("<td>" + EmployeeName + "</td>");
                    out.println("<td>" + EmployeeSalary + "</td>");
                    out.println("<td>" + DepartmentId + "</td>");
                    out.println("<td><a href='http://localhost:8080/program5/EmployeeForm?employeeId=" + EmployeeId + "'>Edit</a></td>");
                    out.println("<td><a href='http://localhost:8080/program5/EmployeeDelete?employeeId=" + EmployeeId + "'>Delete</a></td>");
                    out.println("</tr>");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                out.println(ex);
            }
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
