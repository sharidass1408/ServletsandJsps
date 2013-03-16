package com.nbna.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;

import com.nbna.model.User;

public class InsertDataDAO extends DatabaseAccessor {

	private static final String Insert_St = "insert into CustomerInfo (Name, Userid, Password, Email,Street,City,State,ZipCode)   values(?, ?, ?, ?,?,?,?,?)";
	PreparedStatement pstmtProduct = null;
    ResultSet rs = null;
	private User user;
	
    public InsertDataDAO(User user){
    	super();
    	this.user = user;
    }
    
	@Override
	protected String getQuery() {
		return Insert_St;		
	}

	@Override
	protected String getProcessResults() {
		
		return null;
	}
	
	@Override
	public ResultSet performQuery(){
		
		
		try {
			pstmtProduct = getPreparedStatement(Insert_St);
			pstmtProduct.setString(1,user.getName());
			pstmtProduct.setString(2,user.getUserid());
			pstmtProduct.setString(3,user.getPassword());
			pstmtProduct.setString(4,user.getEmail());
			pstmtProduct.setString(5,user.getStreet());
			pstmtProduct.setString(6,user.getCity());
			pstmtProduct.setString(7,user.getState());
			pstmtProduct.setString(8,user.getZip());
			rs = pstmtProduct.executeQuery();
			System.out.println(rs);
			return rs;
		} catch (Exception e) {			
			e.printStackTrace();
		}
				
		return null;
		
	}

}
