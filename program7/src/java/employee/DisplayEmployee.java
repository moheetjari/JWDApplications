/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

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
public class DisplayEmployee extends HttpServlet {

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
            out.println("<title>Servlet DisplayEmployee</title>");            
            out.println("</head>");
            out.println("<body>");
            String URL="jdbc:mysql://localhost/salesDB";
            String user="root";
            String pass="root";
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn=DriverManager.getConnection(URL,user,pass);
                
                


                  
               String s="select e.empId,e.empName,s.storeName from empTB e,storeTB s where e.storeId=s.storeId ";
                  Statement stmt=cn.createStatement();
                  ResultSet rs =stmt.executeQuery(s);
                  
                  
                  out.println("<a href='EmployeeForm'>Add New Employee</a><br><hr>");
                  out.println("<center><table border=1><thead><tr><th>Employee Name</th><th>Store</th><th>Reports</th></tr></thead><tbody>");
                   String eid =request.getParameter("eid");
                 String name="";
                 
                
                  while(rs.next()){
                      if(eid!=null){
                      if(eid.equals(rs.getString(1))){
                          name=rs.getString(2);
                      }
                      }
                      
                    out.println("<tr>");
                      
//                      out.println(rs.getInt(1));
                      out.println("<td>"+rs.getString(2)+"</td>");
                      out.println("<td>"+rs.getString(3)+"</td>");
                        out.println("<td><a href='DisplayEmployee?eid="+rs.getInt(1)+"'>Report of Sales</a></td>");
                       out.println("</tr>");
                      }
   
                  
                  out.println("</tbody></table></center>");
               
                
                
                
               
                if(eid!=null)
                {
                    
                    
                  String s1="select e.empName,s.sQty,i.itemName,c.custName from empTB e,salesTB s,itemTB i,custTB c where e.empId=s.empId and s.itemId=s.itemId and s.custId=c.custId and e.empId="+eid;
                  Statement stmts=cn.createStatement();
                  ResultSet rss =stmts.executeQuery(s1);
                 
                  
                  out.println("Sales Detail of Employee-"+name+" <hr>");
                  out.println("<center><table border=1><thead><tr><th>Customer</th><th>Item</th><th>Qty</th></tr></thead><tbody>");
                  
                  while(rss.next()){
                    out.println("<tr>");
                      
                      //out.println(rs.getInt(1));
                       out.println("<td>"+rss.getString(4)+"</td>");
                     out.println("<td>"+rss.getString(3)+"</td>");
                      out.println("<td>"+rss.getString(2)+"</td>");
                       out.println("</tr>");
                      }
                  
                  out.println("</tbody></table></center>");
               
                
                stmts.close();
               
                    
                }

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
