/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listners;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Web application lifecycle listener.
 *
 * @author admin
 */
public class SessionAttListner implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        Connection con = null;
        Statement stmt = null;
        int size = 0;
        int dataVisits = 0;
        try {
            String sessionId = event.getSession().getId();

            Date d = new Date(event.getSession().getCreationTime());
            Format f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String creationtime = f.format(d);

            Date d1 = new Date(event.getSession().getLastAccessedTime());
            Format f1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String lastaccesstime = f1.format(d1);

            String userId = (String) event.getSession().getAttribute("id");

            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/computershopdb", "root", "root");
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from logtb where userid=?");
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();
            rs.last();
            size = rs.getRow();

            if (size > 0) {
                dataVisits = rs.getInt("visits");
                stmt = (Statement) con.createStatement();
                PreparedStatement ps2 = (PreparedStatement) con.prepareStatement("update logtb set visits=?,lastaccesstime=?,sessionid=?,creationtime=? where userid=?");
                ps2.setInt(1, dataVisits + 1);
                ps2.setString(2, lastaccesstime);
                ps2.setString(3, sessionId);
                ps2.setString(4, creationtime);
                ps2.setString(5, userId);
                ps2.executeUpdate();

            } else {
                stmt = (Statement) con.createStatement();
                PreparedStatement ps1 = (PreparedStatement) con.prepareStatement("insert into logtb(sessionid,creationtime,lastaccesstime,userid,visits) values(?,?,?,?,?)");
                ps1.setString(1, sessionId);
                ps1.setString(2, creationtime);
                ps1.setString(3, lastaccesstime);
                ps1.setString(4, userId);
                ps1.setInt(5, 1);

                ps1.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
    }
}
