/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class AdminHomeServlet extends HttpServlet {

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
            out.println("<title>Servlet AdminHomeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            Connection con = null;
            Statement stmt = null;
            String categoryName = null;

            out.println("<center><h1>Welcome Admin</h1></center>");
            out.println("<Button><a href='http://localhost:8080/program8/AddCategory.html'><b>Add Category</b></a></Button>");
            out.println("<Button><a href='http://localhost:8080/program8/productServlet'><b>Add Product</b></a></Button>");
            out.println("<br><br>");
            out.println("<table cellpadding='2' cellspacing='2' align='center' border='1'>");
            out.println("<tr>");
            out.println("<th>Id</th>");
            out.println("<th>CategoryName</th>");
            out.println("</tr>");
            out.println("<tr>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/computershopdb", "root", "root");
                stmt = (Statement) con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from Category");

                while (rs.next()) {
                    out.println("<td>" + rs.getString("categoryId") + "</td>");
                    out.println("<td>" + rs.getString("categoryName") + "</td>");
                    out.println("</tr>");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                out.println(ex);
            }
            out.println("</table>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<table cellpadding='2' cellspacing='2' align='center' border='1'>");
            out.println("<tr>");
            out.println("<th>Id</th>");
            out.println("<th>ProductName</th>");
            out.println("<th>ProductPrice</th>");
            out.println("</tr>");
            out.println("<tr>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/computershopdb", "root", "root");
                stmt = (Statement) con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from product");

                while (rs.next()) {
                    out.println("<td>" + rs.getString("productid") + "</td>");
                    out.println("<td>" + rs.getString("productname") + "</td>");
                    out.println("<td>" + rs.getString("price") + "</td>");
                    out.println("</tr>");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                out.println(ex);
            }
            out.println("</table>");
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
