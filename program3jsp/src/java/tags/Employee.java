/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author admin
 */
public class Employee extends SimpleTagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    public String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/employeedb", "root", "root");
            Statement stmt = (Statement) con.createStatement();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select e.employeename,d.departmentname from employee e,department d where e.departmentid=d.id and d.departmentname=?");
            ps.setString(1, deptName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                out.println(rs.getString(1));
                out.println(rs.getString(2));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            out.println(ex);
        }
    }
}
