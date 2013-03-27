package com.nbna.DAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nbna.model.User;

public class InsertDataDAO extends DatabaseAccessor {

	private static final String insert_st = "insert into CustomerInfo (Name, Userid, Password, Email,Street,City,State,ZipCode)   values(?, ?, ?, ?,?,?,?,?)";
	PreparedStatement pstmtProduct = null;
    ResultSet rs = null;
	private User user;
	
    public InsertDataDAO(User user){
    	super();
    	this.user = user;
    }
    
	@Override
	protected String getQuery() {
		return insert_st;		
	}

	
	
	@Override
	public ResultSet performQuery() throws SQLException{
		
		
		//try {
			pstmtProduct = getPreparedStatement(insert_st);
			pstmtProduct.setString(1,user.getName());
			pstmtProduct.setString(2,user.getUserid());
			pstmtProduct.setString(3,user.getPassword());
			pstmtProduct.setString(4,user.getEmail());
			pstmtProduct.setString(5,user.getStreet());
			pstmtProduct.setString(6,user.getCity());
			pstmtProduct.setString(7,user.getState());
			pstmtProduct.setString(8,user.getZip());
			pstmtProduct.execute();
			System.out.println(" Inserted Data sucessfully");
			
			
		/*} catch (Exception e) {			
			e.printStackTrace();
		}*/
				
		return null;
		
	}

}
