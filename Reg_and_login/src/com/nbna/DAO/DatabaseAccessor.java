/**
 * The purpose of this program is to demo the usage of chained constructors in java, apart from that
 * there is no difference between DAOpattern example and this project
 */
package com.nbna.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DatabaseAccessor {
	
    private Connection conn = null;
	private String url;
	private String dbName;
	private String driver;
	private String userName; 
	private String password;		
	/*
	 * To Demo constructor chain usage. 
	 */
	public DatabaseAccessor() {	
		this("jdbc:mysql://localhost:3306/","nbna_database","com.mysql.jdbc.Driver","root","sriram1408");
	}
	
	public DatabaseAccessor(String dbName) {	
		this("jdbc:mysql://localhost:3306/",dbName,"com.mysql.jdbc.Driver","root","sriram1408");
	}
	
	public DatabaseAccessor(String url,String dbName,String driver) {	
		this(url,dbName,driver,"root","sriram1408");
	}
	
	public DatabaseAccessor(String url,String dbName, String driver, String userName, String password) {
		System.out.println("Constructor of DatabaseAccessor got called");
		this.url = url;
		this.dbName = dbName;
		this.driver = driver;
		this.userName = userName; 
		this.password = password;
		this.conn = this.getConnection(); 
		
		
	}
	
	private Connection getConnection(){
		
		System.out.println("Attempting connection...");
			
			try {
				Class.forName(driver).newInstance();
				System.out.println("connection info:"+this.url+this.dbName+" "+this.userName+" "+this.password);
				System.out.println("Sucessfully got the connection and set the value to connection feild variable");
				return DriverManager.getConnection(this.url+this.dbName,this.userName,this.password);
			} catch (InstantiationException ine) {
				System.out.println("InstantiationException exception occured: ");
				ine.printStackTrace();
			} catch (IllegalAccessException ile) {
				System.out.println("IllegalAccessException exception occured: ");
				ile.printStackTrace();
			} catch (ClassNotFoundException cnfe) {
				System.out.println("ClassNotFoundException exception occured: ");
				cnfe.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Unknown exception occured: ");
				e.printStackTrace();
			}
			
			return null;	
			 
	} 

	
	
	abstract protected String getQuery();
	
	
	protected PreparedStatement getPreparedStatement(String str) throws SQLException{
		
		if (conn== null)	return null;		
		return  conn.prepareStatement(str);		
	}
	
	protected ResultSet performQuery(){
		
		String query = this.getQuery();
		Statement st;
		try {
			System.out.println("Performing Query..... "+query);
			st = this.conn.createStatement();			
			ResultSet rs = st.executeQuery(query);
			System.out.println("Sucessfully executedQuery");
			return rs;
		} catch (SQLException e) {
			System.out.println("SQLException Occured in DatabaseAccessor");
		}catch (Exception e) {
			System.out.println("Unknown Exception Occured");
		}finally{
			/*try {
				conn.close();				
			} catch (SQLException e) {
				System.out.println("Execption occured while closing connection");
				e.printStackTrace();
			}*/
			System.out.println("Note: Should not close connection here...");
		}
		
		return null;
		
	}
	
	abstract protected String getProcessResults();
	
	protected boolean performCleanUp(){
		
		try {
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Execption occured while closing connection");
			e.printStackTrace();
		}
		
		return false;
	}
	
}
