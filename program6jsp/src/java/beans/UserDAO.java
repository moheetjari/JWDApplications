/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class UserDAO {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/empprojectdb", "root", "root");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return con;
    }

    public static int addEmployee(employee e) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into emptb(empname,designation,deptid) values(?,?,?)");
            ps.setString(1, e.getEmpname());
            ps.setString(2, e.getDesignation());
            ps.setInt(3, e.getDeptid());
            status = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static int updateEmployee(employee e) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("update emptb set empname=?,designation=?,deptid=? where empid=?");
            ps.setString(1, e.getEmpname());
            ps.setString(2, e.getDesignation());
            ps.setInt(3, e.getDeptid());
            ps.setInt(4, e.getEmpid());
            status = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static int deleteEmployee(int id) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("delete from emptb where empid=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static List<employee> getAllEmployee() {
        List<employee> lstEmp = new ArrayList<employee>();
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from emptb");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                employee e = new employee();
                e.setEmpid(rs.getInt("empid"));
                e.setEmpname(rs.getString("empname"));
                e.setDesignation(rs.getString("designation"));
                e.setDeptid(rs.getInt("deptid"));
                lstEmp.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lstEmp;
    }

    public static employee getEmployeeById(int id) {
        employee e = null;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from emptb where empid=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                e = new employee();
                e.setEmpid(rs.getInt("empid"));
                e.setEmpname(rs.getString("empname"));
                e.setDesignation(rs.getString("designation"));
                e.setDeptid(rs.getInt("deptid"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return e;
    }
}
