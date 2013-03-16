import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class GameBean {
	
	ArrayList getGameList(){
		ArrayList gameList =new ArrayList();
		
		Connection conn = null;
		Statement st;
		try {
			
			conn = getConnection();
			System.out.println("Connected to the database");
			
			ArrayList al=null;
			ArrayList userList =new ArrayList();
			String query = "select * from game where owned != 1 order by no_of_votes desc";
			System.out.println("query " + query);
			st = conn.createStatement();
			ResultSet  rs = st.executeQuery(query);


			while(rs.next())
			{
				al  = new ArrayList();
			
			  al.add(rs.getInt(1));
			  al.add(rs.getString(2));
			  al.add(rs.getString(4));
			 System.out.println("al :: "+al);
			 gameList.add(al);
			}	
			conn.close();
			} catch (Exception e) {
				
				e.printStackTrace();
				}
	
		return gameList;
}
	public String addGame(String gameTitle){
		String result="Success";
		
		Connection conn = null;
		Statement st;
		try {
			
			conn = getConnection();
			System.out.println("Connected to the database");
			
			String query = "insert into game(title,owned,no_of_votes,created) values('"+gameTitle+"',0,1,now())";
			System.out.println("query " + query);
			st = conn.createStatement();
			int  rs = st.executeUpdate(query);
			
			String query1 = "insert into vote(gameid,lastvote) select gameid,created from game where title='"+gameTitle+"'";
			System.out.println("query " + query1);
			st = conn.createStatement();
			int  rs1 = st.executeUpdate(query1);
			
			conn.close();
			} catch (Exception e) {
				result="failed";
				e.printStackTrace();
				}
	

		return result;
	}
	
	public String voteGame(int id){
		String result="Success";
		
		Connection conn = null;
		Statement st;
		try {
			
			conn = getConnection();
			System.out.println("Connected to the database");
			
			
			String query = "update game set no_of_votes =  no_of_votes+1 where gameid="+id;
			System.out.println("query " + query);
			st = conn.createStatement();
			int  rs = st.executeUpdate(query);
			
			String query1 = "insert into vote(gameid,lastvote) values ("+id+",now())";
			System.out.println("query " + query1);
			st = conn.createStatement();
			int  rs1 = st.executeUpdate(query1);
			
			conn.close();
			} catch (Exception e) {
				result="failed";
				e.printStackTrace();
				}
	

		return result;
	}
	
	public String ownGame(int id){
		String result="Success";
		
		Connection conn = null;
		Statement st;
		try {
			
			conn = getConnection();
			System.out.println("Connected to the database");
			
			
			String query = "update game set owned = 1 where gameid="+id;
			System.out.println("query " + query);
			st = conn.createStatement();
			int  rs1 = st.executeUpdate(query);
			
			conn.close();
			} catch (Exception e) {
				result="failed";
				e.printStackTrace();
				}
	

		return result;
	}
	
	ArrayList getOwnList(){
		ArrayList gameList =new ArrayList();
		Connection conn = null;
		Statement st;
		try {

			conn = getConnection();
			System.out.println("Connected to the database");
			
			ArrayList al=null;
			ArrayList userList =new ArrayList();
			String query = "select * from game where owned != 0 order by title";
			System.out.println("query " + query);
			st = conn.createStatement();
			ResultSet  rs = st.executeQuery(query);


			while(rs.next())
			{
				al  = new ArrayList();
			
			  al.add(rs.getInt(1));
			  al.add(rs.getString(2));
			  al.add(rs.getString(4));
			 System.out.println("al :: "+al);
			 gameList.add(al);
			}	
			conn.close();
			} catch (Exception e) {
				
				e.printStackTrace();
				}
	
		return gameList;
}
	
	public Connection getConnection(){
		System.out.println("MySQL Connect.");
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "sai";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root"; 
		String password = "sriram1408";

		
		
			try {
				Class.forName(driver).newInstance();
				conn = DriverManager.getConnection(url+dbName,userName,password);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return conn;
	}
}
