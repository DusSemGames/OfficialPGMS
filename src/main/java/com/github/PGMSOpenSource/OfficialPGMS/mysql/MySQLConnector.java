package com.github.PGMSOpenSource.OfficialPGMS.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

import com.github.PGMSOpenSource.OfficialPGMS.utils.PGMSLogger;

public class MySQLConnector {
	
	public static Connection con;
	
	public String dbhost;
	public int dbport;
	public String dbname;
	public String dbuser;
	public String dbpass;
	
	public void connect() {
		if(con == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://" + this.dbhost + ":" + this.dbport + "/" + this.dbname, this.dbuser, this.dbpass);
			} catch (Exception e) {
				PGMSLogger.log("warning", "Could not establish a connection to the database: " + e);
			}
		} else {
			PGMSLogger.log("Tried to establish a connection to the already connected database.");
		}
	}
	

}
