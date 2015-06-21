package com.timetable.dao;

import java.sql.Connection;  
//import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Calendar;

import com.timetable.model.SessionProps;
import com.timetable.util.DbUtil;

  
public class LoginDao {  
	public static void validate(String name, String pass, Timestamp time) {     
        Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null;  
        String query = null;
        boolean resultState = false;
        int id = -1;
        int visits = -1;
        Timestamp create = null;
        try {
        	conn =		DbUtil.getConnection();
        	
        	query = "select id from users where username=? and password=?";
            pst = conn  
                    .prepareStatement(query);  
            pst.setString(1, name);  
            pst.setString(2, pass);  
  
            rs = pst.executeQuery();  
            
            while(rs.next()){
            	id  = rs.getInt("id");
            }
            if(id != -1){
            	resultState = true;
            }
            SessionProps.login(resultState);
            
//            Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
//            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
/*            query = "update members set last_access = ? and num_visits = ?  where mem_id =?";
            pst = conn  
                    .prepareStatement(query);  
            pst.setTimestamp(1, time);
            pst.setInt(2, visits);
            pst.setInt(3, id);  
  
            rs = pst.executeQuery();  */
            
        } catch (Exception e) {  
            System.out.println(e);  
        }/* finally {  
           closeConnection(connection);
            closeStatement(pst);
           closeResult(rs); 
        }  		/* */
    }
	
	public static boolean newUser(String name, String pass, String email, Timestamp time) {     
        Connection conn = null;  
        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
        PreparedStatement pst3 = null;  
        ResultSet rs = null;  
        boolean status = false;
        int id = -1;
//        Date create_time = new Date();
//        Date last_access = new Date();
        String query = null;
        
        try {
        	conn =		DbUtil.getConnection();
            query = "insert into users(id, username, password) values(?, ?, ?)";
        	pst = conn  
                    .prepareStatement(query);  
        	pst.setString(1, "");
        	pst.setString(2, name);
        	pst.setString(3, pass);
            pst.executeUpdate();
            
            /*
            if(rs.next()){
            	query = "select id from users where username=? and password=?";
            	pst2 = conn  
                        .prepareStatement(query);  
                pst2.setString(1, name);  
                pst2.setString(2, pass); 
                rs = pst2.executeQuery(); 
                //get id from users table
                while(rs.next()){
                	id  = rs.getInt("id");
                }
                query = "insert into members(mem_id, email, num_visits)  values(?,?,?,?,?)";
                pst3 = conn
                	.prepareStatement(query);
                pst3.setInt(1, id);
                pst3.setString(2, email);
                pst3.setInt(4, 0);
                rs = pst3.executeQuery(); 
            } else {
            	//failed to insert username and password into users table
            	
            }	/*  */
          LoginDao.validate(name, pass,  time);

        } catch (Exception e) {  
            System.out.println(e);  
        }/* finally {  
           closeConnection(connection);
            closeStatement(pst);
           closeResult(rs); 
        }  		/* */
        return status;
    }
	
	// for setting session variables
	public static void setSessionVariables(String name, String pass, Timestamp time){       
      Connection connection = null;
      PreparedStatement pst = null;
      ResultSet rs = null;
      int id = 0;
      int role = 0;
      String username = null;
      String loggedIn = "You have successfully logged in";
      String notLoggedIn = "Login unsuccessful";
      Timestamp create = null;
      
      try {
    	  String query = "select id, username, Roles_id from users where username=? and password=?";
    	  connection = DbUtil.getConnection();
          pst = connection
                  .prepareStatement(query);
          pst.setString(1, name);
          pst.setString(2, pass);

          rs = pst.executeQuery();
          
          while(rs.next()){
          	//retrieve values by column name
          	id  = rs.getInt("id");
          	username = rs.getString("username");
          	role = rs.getInt("Roles_id");
          }
          query = "select create_time from members where mem_id=?";
          
          pst = connection
                  .prepareStatement(query);
          pst.setInt(1, id);
          rs = pst.executeQuery();
          
          while(rs.next()){
          	//retrieve values by column name
        	  create  = rs.getTimestamp("create_time");
          }
          
          SessionProps.setSessionId(id);
          SessionProps.setSessionName(username);
          SessionProps.setSessionRole(role);
          SessionProps.setSessionTime(time);
          SessionProps.setSessionCreate(create);
          if(id != 0 )
        	  SessionProps.setSessionMessage(loggedIn);
          
          else
        	  SessionProps.setSessionMessage(notLoggedIn);
          
          
      } catch (Exception e) {
          System.out.println(e);
      }/* finally {
      	closeConnection(connection);
      	closeStatement(pst);
      	closeResult(rs);
      } /*  */
  }	/*	*/
	
	//closeConnection closes the currently open db connection
	public static void closeConnection( Connection conn ){
		//close connection
        if (conn != null) {
        	
            try {
            	conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }		
	}
	
	//closeStatement frees the prepared statement
	public static void closeStatement( PreparedStatement pst ){
		//close prepared statement
        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
	
	//closeResult frees the result set variable
	public static void closeResult( ResultSet rs ){
		//close result set
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
}
