package com.github.PGMSOpenSource.OfficialPGMS.mysql;

import com.github.PGMSOpenSource.OfficialPGMS.PGMS;
import com.github.PGMSOpenSource.OfficialPGMS.utils.PGMSLogger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    
    private PGMS p;
    
    public MySQL(PGMS pgm) {
        p=pgm;
    }
    
    protected boolean loadDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return true;
        }
        catch (ClassNotFoundException ex) {
            PGMSLogger.log("severe","Could not load JDBC driver!");
            ex.printStackTrace();
            return false;
        }
    }
    
    protected String getJdbcUrl() {
        String host=p.getConfig().getString("database.hostname");
        String port=p.getConfig().getString("database.port");
        String name=p.getConfig().getString("database.name");
        String url="jdbc:mysql://"+host+":"+port+"/"+name;
        return url;
    }
    
    protected String getUsername() {
        String user=p.getConfig().getString("database.username");
        return user;
    }
    
    protected String getPassword() {
        String pass=p.getConfig().getString("database.password");
        return pass;
    }
    
    public boolean connect() {
        if(loadDriver()) {
            try {
                this.con=DriverManager.getConnection(getJdbcUrl(), getUsername(), getPassword());
                return true;
            }
            catch (SQLException ex) {
                PGMSLogger.log("severe","Could not connect to database!");
                ex.printStackTrace();
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    public boolean isConn() {
        if(con!=null) {
            try {
                if(con.isValid(1)) {
                    return true;
                }
                else {
                    return false;
                }
            }
            catch (SQLException ex) {
                PGMSLogger.log("severe","Database error!");
                ex.printStackTrace();
                return false;
            }
        }
        else{
            return false;
        }
    }
    
    public ResultSet query(String query) {
        if(isConn()) {
            try {
                st=con.createStatement();
                rs=st.executeQuery(query);
                return rs;
            }
            catch (SQLException ex) {
                PGMSLogger.log("severe","Database error!");
                ex.printStackTrace();
                return null;
            }
        }
        else {
            PGMSLogger.log("severe","Database error!");
            return null;
        }
    }
    
    public ResultSet query(PreparedStatement ps) {
        if(isConn()) {
            try {
                ps.execute();
                rs=ps.getResultSet();
                return rs;
            }
            catch (SQLException ex) {
                PGMSLogger.log("severe","Database error!");
                ex.printStackTrace();
                return null;
            }
        }
        else {
            PGMSLogger.log("severe","Database error!");
            return null;
        }
    }
    
    public PreparedStatement prepare(String query) {
        if(isConn()) {
            try {
                ps=con.prepareStatement(query);
                return ps;
            }
            catch (SQLException ex) {
                PGMSLogger.log("severe","Database error!");
                ex.printStackTrace();
                return null;
            }
        }
        else {
            PGMSLogger.log("severe","Database error!");
            return null;
        }
    }
    
    public int getNumRows(ResultSet rs){
        int count=0;
        try {
            while(rs.next()) {
                count++;
            }
            return count;
        } catch (SQLException ex) {
            PGMSLogger.log("severe","Database error!");
            ex.printStackTrace();
            return count;
        }
    }
    
    public boolean isColumn(String table, String col) {
        String query="SELECT "+col+" FROM "+table;
        try {
            st=con.createStatement();
            st.executeQuery(query);
            return true;
        }
        catch (SQLException ex) {
            return false;
        }
    }
    
}