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
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class AddEmployee extends HttpServlet {

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
            out.println("<title>Servlet AddEmployee</title>");
            out.println("</head>");
            out.println("<body>");
            String EmployeeId = request.getParameter("txtEmployeeId");
            String EmployeeName = request.getParameter("txtEmployeeName");
            String EmployeeSalary = request.getParameter("txtEmployeeSalary");
            String DepartmentId = request.getParameter("txtEmployeeDepartment");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/employeedb", "root", "root");
                if (EmployeeId == null) {
                    PreparedStatement stmt = con.prepareStatement("INSERT INTO EMPLOYEE(EMPLOYEENAME,SALARY,DEPARTMENTID) VALUES(?,?,?)");
                    stmt.setString(1, EmployeeName);
                    stmt.setString(2, EmployeeSalary);
                    stmt.setString(3, DepartmentId);
                    int rowsAff = stmt.executeUpdate();
                    if (rowsAff > 0) {
                        response.sendRedirect("GetEmployee");
                    }
                } else {
                    PreparedStatement stmt = con.prepareStatement("UPDATE EMPLOYEE SET EMPLOYEENAME=?,SALARY=?,DEPARTMENTID=? WHERE Id=?");
                    stmt.setString(1, EmployeeName);
                    stmt.setString(2, EmployeeSalary);
                    stmt.setString(3, DepartmentId);
                    stmt.setString(4, EmployeeId);
                    int rowsAff = stmt.executeUpdate();
                    if (rowsAff > 0) {
                        response.sendRedirect("GetEmployee");
                    }
                }
            } catch (Exception ex) {
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
