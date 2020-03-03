/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author riddhi
 */
public class SalesForm extends HttpServlet {

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
            out.println("<title>Servlet SalesForm</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Sales Add Form</h1>");
            String URL = "jdbc:mysql://localhost/salesDB";
            String user = "root";
            String pass = "root";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn = DriverManager.getConnection(URL, user, pass);

                String sql = "select * from itemTB";
                String s1="select * from empTB";
                String s2="select * from custTB";

                Statement stmt = cn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                
                Statement stmt1 = cn.createStatement();
                ResultSet rsd = stmt1.executeQuery(s1);

                Statement stmt2 = cn.createStatement();
                ResultSet rss = stmt2.executeQuery(s2);

                out.print("<form action='SalesAdd' method='post'>");



            
                
         

                 out.println("Employee :<select name='empid'><option value='-1'>Select</option>");
                while (rsd.next()) {

                    
                    out.println("<option value='"+rsd.getInt(1)+"'>"+rsd.getString(2)+"</option>");
                   

                }
                
              out.println("</select><br>");
                              out.println("Item :<select name='itemid'><option value='-1'>Select</option>");
                while (rs.next()) {

                    
                    out.println("<option value='"+rs.getInt(1)+"'>"+rs.getString(2)+"</option>");
                   

                }
                out.println("</select><br>");
                
               
                              out.println("Customer :<select name='cid'><option value='-1'>Select</option>");
                while (rss.next()) {

                    
                    out.println("<option value='"+rss.getInt(1)+"'>"+rss.getString(3)+"</option>");
                   

                }
                out.println("</select><br>"); 
              out.println("Qty :<input type='number' name='qty'><br>");
              out.println("<input type='submit' value='Add Sales'>");
                stmt.close();
                cn.close();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
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
