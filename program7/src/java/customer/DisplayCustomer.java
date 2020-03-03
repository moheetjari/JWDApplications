/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

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
public class DisplayCustomer extends HttpServlet {

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
            out.println("<title>Servlet DisplayCustomer</title>");            
            out.println("</head>");
            out.println("<body>");
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/salesDB","root","root");
                
                  String sql="select * from custTB";
                
               
                  Statement stmt=cn.createStatement();
                  ResultSet rs =stmt.executeQuery(sql);
                  
                  out.println("<a href='CustomerForm'>Add New Customer</a><br><hr>");
                  out.println("<center><table border=1><thead><tr><th>Name</th><th>Location</th></tr></thead><tbody>");
                  
                  while(rs.next()){
                    out.println("<tr>");
                      
                      //out.println(rs.getInt(1));
                      out.println("<td>"+rs.getString(3)+"</td>");
                      out.println("<td>"+rs.getString(2)+"</td>");
                    
  

//                      out.println("<td><a href='FormServlet?id="+rs.getInt(1)+"'>Edit</a></td>");
//                       out.println("<td><a href='DeleteServlet?id="+rs.getInt(1)+"' >Delete</a></td>");

                     out.println("</tr>");
                      
                  }
                  out.println("</tbody></table></center>");
               
                
                stmt.close();
                cn.close();
                
            }
            catch(Exception ex){
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
