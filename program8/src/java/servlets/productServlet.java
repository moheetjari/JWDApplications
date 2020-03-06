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
public class productServlet extends HttpServlet {

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
            out.println("<title>Servlet productServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center><h1>Add Product</h1></center>");
            out.println("<form method='post' action='addproductServlet'>");
            out.println("<table align=\"center\" cellpadding=\"2\" cellspacing=\"2\">");
            out.println("<tr>");
            out.println("<td>Name</td>");
            out.println("<td><input type='text' name='txtProductName' placeholder='Enter productname..' required/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Price</td>");
            out.println("<td><input type='number' name='txtProductPrice' placeholder='Enter prouctprice..' required/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Category</td>");
            out.println("<td>");
            out.println("<select name='drpcategory'>");
            out.println("<option>--SELECT CATEGORY--</option>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/computershopdb", "root", "root");
                Statement stmt = (Statement) con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from category");

                while (rs.next()) {
                    out.println("<option value='" + rs.getString("categoryid") + "' >" + rs.getString("categoryname") + "</option>");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                out.println(ex);
            }
            out.println("</select>");
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td><input type=\"submit\" value=\"Submit\"/></td>");
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
