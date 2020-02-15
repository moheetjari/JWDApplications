/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.regex.Pattern;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class authFilter implements Filter {

    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public authFilter() {
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("authFilter:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("authFilter:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());

	}
         */
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        res.setContentType("text/html");
        String FirstName = req.getParameter("txtFirstName");
        String LastName = req.getParameter("txtLastName");
        String Address = req.getParameter("txtAddress");
        String Email = req.getParameter("txtEmail");
        String City = req.getParameter("txtCity");
        String Mobile = req.getParameter("txtMobile");
        request.setAttribute("ValFirstName", FirstName);
        request.setAttribute("ValLastName", LastName);
        request.setAttribute("ValAddress", Address);
        request.setAttribute("ValEmail", Email);
        request.setAttribute("ValCity", City);
        request.setAttribute("ValMobile", Mobile);

        boolean valid = false;

        if (FirstName.equals("")) {
            request.setAttribute("FirstName", "FirstName required!!");
            RequestDispatcher rd = req.getRequestDispatcher("RegistrationForm");
            valid = false;
            rd.include(request, response);
        } else if (Pattern.matches("[a-zA-Z]*", FirstName)) {
            request.setAttribute("ValFisrtName", FirstName);
            valid = true;
        } else {
            request.setAttribute("FirstName", "FirstName not contains digits and special characters.");
            request.setAttribute("ValFisrtName", FirstName);
            RequestDispatcher rd = req.getRequestDispatcher("RegistrationForm");
            valid = false;
            rd.include(request, response);
        }

        if (LastName.equals("")) {
            request.setAttribute("LastName", "LastName required!!");
            RequestDispatcher rd = req.getRequestDispatcher("RegistrationForm");
            valid = false;
            rd.include(request, response);
        } else if (Pattern.matches("[a-zA-Z]*", LastName)) {
            request.setAttribute("ValLastName", LastName);
            valid = true;
        } else {
            request.setAttribute("LastName", "LastName not contains digits and special characters.");
            request.setAttribute("ValLastName", LastName);
            RequestDispatcher rd = req.getRequestDispatcher("RegistrationForm");
            valid = false;
            rd.include(request, response);
        }

        if (Address.equals("")) {
            request.setAttribute("Address", "Address required!!");
            RequestDispatcher rd = req.getRequestDispatcher("RegistrationForm");
            valid = false;
            rd.include(request, response);
        } else if (Pattern.matches("[a-zA-Z]*", Address)) {
            request.setAttribute("ValAddress", Address);
            valid = true;
        } else {
            request.setAttribute("Address", "Address must be a characters only.");
            request.setAttribute("ValAddress", Address);
            RequestDispatcher rd = req.getRequestDispatcher("RegistrationForm");
            valid = false;
            rd.include(request, response);
        }

        if (Email.equals("")) {
            request.setAttribute("Email", "Email required!!");
            RequestDispatcher rd = req.getRequestDispatcher("RegistrationForm");
            valid = false;
            rd.include(request, response);
        } else if (Pattern.matches("^[a-z0-9](\\.?[a-z0-9]){5,}@g(oogle)?mail\\.com$", Email)) {
            request.setAttribute("ValEmail", Email);
            valid = true;
        } else {
            request.setAttribute("Email", "Enter only Google Email.");
            request.setAttribute("ValEmail", Email);
            RequestDispatcher rd = req.getRequestDispatcher("RegistrationForm");
            valid = false;
            rd.include(request, response);
        }

        if (City.equals("")) {
            request.setAttribute("City", "City required!!");
            RequestDispatcher rd = req.getRequestDispatcher("RegistrationForm");
            valid = false;
            rd.include(request, response);
        } else if (Pattern.matches("[a-zA-Z]*", City)) {
            request.setAttribute("ValCity", City);
            valid = true;
        } else {
            request.setAttribute("City", "City must be only characters only.");
            request.setAttribute("ValCity", City);
            RequestDispatcher rd = req.getRequestDispatcher("RegistrationForm");
            valid = false;
            rd.include(request, response);
        }

        if (Mobile.equals("")) {
            request.setAttribute("Mobile", "Mobile required!!");
            RequestDispatcher rd = req.getRequestDispatcher("RegistrationForm");
            valid = false;
            rd.include(request, response);
        } else if (Pattern.matches("^[6-9]\\d{9}$", Mobile)) {
            request.setAttribute("ValMobile", Mobile);
            valid = true;
        } else {
            request.setAttribute("Mobile", "MobileNo starts with 6-9");
            request.setAttribute("ValMobile", Mobile);
            RequestDispatcher rd = req.getRequestDispatcher("RegistrationForm");
            valid = false;
            rd.include(request, response);
        }

        if (valid == true) {
            chain.doFilter(request, response);
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("authFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("authFilter()");
        }
        StringBuffer sb = new StringBuffer("authFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
