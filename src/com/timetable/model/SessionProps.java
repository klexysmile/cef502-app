package com.timetable.model;

import java.sql.*;

public class SessionProps {
	
	public static int id = -1;
	public static int role = -1;
	public static int visit = -1;
	public static String name = null;
	public static String message = "Sorry username or password error";
	public static Timestamp time = null;
	public static Timestamp create = null;
	public static boolean isLoggedIn = false;
	
	public static void setSessionName ( String name ){
		//set session name here
		SessionProps.name = name;
	}
	
	public static void setSessionMessage ( String message ){
		//set session message here
		SessionProps.message = message;
	}
	
	public static void setSessionId ( int id ){
		//set session id here
		SessionProps.id = id;
	}
	
	public static void setSessionVisits ( int visit ){
		//set session id here
		SessionProps.visit = visit;
	}
	
	public static void setSessionRole (int role ){
		//set session role here
		SessionProps.role = role;
	}
	
	public static void setSessionTime ( Timestamp time ){
		//set session name here
		SessionProps.time = time;
	}
	
	public static void setSessionCreate ( Timestamp create ){
		//set session name here
		SessionProps.create = create;
	}
	
	public static String getSessionName (){
		return SessionProps.name;
	}
	
	public static String getSessionMessage (  ){
		return SessionProps.message;
	}
	
	public static int getSessionId(){
		return SessionProps.id;
	}
	
	public static int getSessionVisits(){
		return SessionProps.visit;
	}
	
	public static int getSessionRole(){
		return SessionProps.role;
	}
	
	public static Timestamp getSessionTime(){
		return SessionProps.time;
	}
	
	public static Timestamp getSessionCreate(){
		return SessionProps.create;
	}
	
	public static void login( boolean tryLogin ){
		SessionProps.isLoggedIn = tryLogin;
	}
	
	public static boolean isLoggedIn(){
		return SessionProps.isLoggedIn;
	}
	
	public static void logout(  ){
		SessionProps.isLoggedIn = false;
	}
}
