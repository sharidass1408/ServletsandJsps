package com.nbna.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.nbna.model.User;
import java.sql.PreparedStatement;

public class LoginDataDAO extends DatabaseAccessor {

	private static final String select_st = "select * from CustomerInfo where Userid = ?";
	PreparedStatement pstmtProduct = null;
    ResultSet rs = null;
    String userid=null;
    
	
    public LoginDataDAO(String userid){
    	super();
    	this.userid = userid;
    }

	@Override
	protected String getQuery() {

		return select_st;
	}

	@Override
	public ResultSet performQuery(){
		
		
		try {
			pstmtProduct = getPreparedStatement(select_st);
			pstmtProduct.setString(1,userid);			
			rs = pstmtProduct.executeQuery();
			System.out.println(" Queried Sucessfully");			
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
				
		return null;
		
	}

	
	public User getProcessedResults() {
		this.performQuery();
		if(rs!= null){
			try {				
				//followed the order as displayed by ui 
				User user = new User();
				rs.next();
				user.setUserid(rs.getString("C_Id"));
				user.setName(rs.getString("Name"));
				user.setUserid(rs.getString("Userid"));												
				user.setPassword(rs.getString("Password"));
				user.setEmail(rs.getString("Email"));		
				
				user.setStreet(rs.getString("Street"));
				user.setCity(rs.getString("City"));
				user.setState(rs.getString("State"));
				user.setZip(rs.getString("ZipCode"));				
				return user;
				
			} catch (SQLException e) {				
				e.printStackTrace();
				}
			
			
		}
		
		return null;
	}
	
	
}
