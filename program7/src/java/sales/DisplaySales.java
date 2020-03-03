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
public class DisplaySales extends HttpServlet {

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
            out.println("<title>Servlet DisplaySales</title>");            
            out.println("</head>");
            out.println("<body>");
            String URL="jdbc:mysql://localhost/salesDB";
            String user="root";
            String pass="root";
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn=DriverManager.getConnection(URL,user,pass);
                
                  String sql="select s.salesId,c.custName,e.empName,i.itemName,s.sQty from custTB c, salesTB s,empTB e ,itemTB i where i.itemId=s.itemId and s.empId=e.empId and s.custId=c.custId";
                 
                 
                  
               
                  Statement stmt=cn.createStatement();
                  ResultSet rs =stmt.executeQuery(sql);
                 
                 
                 
                 
                  
                  out.println("<a href='SalesForm'>Add New Sales</a><br><hr>");
                  out.println("<center><table border=1><thead><tr><th>CustomerName</th><th>Employee</th><th>ItemName</th><th>Qty</th></tr></thead><tbody>");
                  
                  while(rs.next()){
                    out.println("<tr>");
                      
                   
                      out.println("<td>"+rs.getString(2)+"</td>");
                     out.println("<td>"+rs.getString(3)+"</td>");
                     out.println("<td>"+rs.getString(4)+"</td>");
                      out.println("<td>"+rs.getString(5)+"</td>");

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
