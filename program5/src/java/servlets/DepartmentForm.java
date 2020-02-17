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
public class DepartmentForm extends HttpServlet {

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
            out.println("<title>Servlet DepartmentForm</title>");
            out.println("</head>");
            out.println("<body>");
            String Id = "";
            String DepartmentName = "";
            String departmentId = request.getParameter("departmentId");
            if (departmentId != null) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/employeedb", "root", "root");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM DEPARTMENT WHERE ID = " + departmentId + "");
                    rs.next();
                    Id = rs.getString(1);
                    DepartmentName = rs.getString(2);
                } catch (ClassNotFoundException | SQLException ex) {
                    out.println(ex);
                }
            }
            out.println("<h1><center>Add Department</center></h1>");
            out.println("<form method='post' action='AddDepartment'>");
            out.println("<table cellspacing='2' cellpadding='2' align='center'>");
            out.println("<tr>");
            out.println("<td>DepartmentName:</td>");
            if (departmentId == null) {
                out.println("<td><input type='text' placeholder='Enter Department Name..' name='txtDepartmentName'></td>");
            } else {
                out.println("<td><input type='text' name='txtDepartmentName' value='" + DepartmentName + "'></td>");
                out.println("<td><input type='text' name='txtDepartmentId' value='" + departmentId + "'></td>");
            }

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
