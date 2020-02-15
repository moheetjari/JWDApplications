/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class RegistrationForm extends HttpServlet {

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
            out.println("<title>Servlet RegistrationForm</title>");
            out.println("</head>");
            out.println("<body>");
            String FirstName, LastName, Address, Email, City, Mobile = null;
            String ValFirstName, ValLastName, ValAddress, ValEmail, ValCity, ValMobile = null;

            FirstName = (String) request.getAttribute("FirstName");
            ValFirstName = (String) request.getAttribute("ValFirstName");

            LastName = (String) request.getAttribute("LastName");
            ValLastName = (String) request.getAttribute("ValLastName");

            Address = (String) request.getAttribute("Address");
            ValAddress = (String) request.getAttribute("ValAddress");

            Email = (String) request.getAttribute("Email");
            ValEmail = (String) request.getAttribute("ValEmail");

            City = (String) request.getAttribute("City");
            ValCity = (String) request.getAttribute("ValCity");

            Mobile = (String) request.getAttribute("Mobile");
            ValMobile = (String) request.getAttribute("ValMobile");

            out.println("<h1><center>Registration Form</center></h1>");
            out.println("<form action='welcomeServlet' method='post'>");
            out.println("<table cellspacing='2' cellpadding='2' align='center'>");
            out.println("<tr>");
            out.println("<td>");
            out.println("FirstName");
            out.println("</td>");
            out.println("<td>");
            if (ValFirstName == null) {
                out.println("<input type='text' name='txtFirstName' placeholder='Enter FirstName..' />");
            } else {
                out.println("<input type='text' name='txtFirstName' value=" + ValFirstName + ">");
            }
            out.println("</td>");
            out.println("<td>");
            if (FirstName != null) {
                out.println("<td><font color=red>" + FirstName + "</font></td>");
            }
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>");
            out.println("LastName");
            out.println("</td>");
            out.println("<td>");
            if (ValLastName == null) {
                out.println("<input type='text' name='txtLastName' placeholder='Enter LastName..' />");
            } else {
                out.println("<input type='text' name='txtLastName' value=" + ValLastName + ">");
            }
            out.println("</td>");
            out.println("<td>");
            if (LastName != null) {
                out.println("<td><font color=red>" + LastName + "</font></td>");
            }
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>");
            out.println("Address");
            out.println("</td>");
            out.println("<td>");
            if (ValAddress == null) {
                out.println("<textarea name='txtAddress' placeholder='Enter Address..' ></textarea>");
            } else {
                out.println("<textarea name='txtAddress'>" + ValAddress + "</textarea>");
            }
            out.println("</td>");
            out.println("<td>");
            if (Address != null) {
                out.println("<td><font color=red>" + Address + "</font></td>");
            }
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>");
            out.println("Gender");
            out.println("</td>");
            out.println("<td>");
            out.println("<input type='radio' name='rdogender' value='Male' />Male");
            out.println("<input type='radio' name='rdogender' value='Female' />Female");
            out.println("</td>");
            out.println("<td>");
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>");
            out.println("Email");
            out.println("</td>");
            out.println("<td>");
            if (ValEmail == null) {
                out.println("<input type='text' name='txtEmail' placeholder='Enter Email..' />");
            } else {
                out.println("<input type='text' name='txtEmail' value=" + ValEmail + ">");
            }
            out.println("</td>");
            out.println("<td>");
            if (Email != null) {
                out.println("<td><font color=red>" + Email + "</font></td>");
            }
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>");
            out.println("City");
            out.println("</td>");
            out.println("<td>");
            if (ValCity == null) {
                out.println("<input type='text' name='txtCity' placeholder='Enter City..' />");
            } else {
                out.println("<input type='text' name='txtCity' value=" + ValCity + ">");
            }
            out.println("</td>");
            out.println("<td>");
            if (City != null) {
                out.println("<td><font color=red>" + City + "</font></td>");
            }
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>");
            out.println("Mobile");
            out.println("</td>");
            out.println("<td>");
            if (ValMobile == null) {
                out.println("<input type='text' name='txtMobile' placeholder='Enter Mobile..' />");
            } else {
                out.println("<input type='text' name='txtMobile' value=" + ValMobile + ">");
            }
            out.println("</td>");
            out.println("<td>");
            if (Mobile != null) {
                out.println("<td><font color=red>" + Mobile + "</font></td>");
            }
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>");
            out.println("<input type='submit' name='btnSubmit' value='Register'/>");
            out.println("</td>");
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
