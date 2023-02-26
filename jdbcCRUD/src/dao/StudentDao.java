package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentDao {
	
	//connection with database
	public Connection createConnection() {
		String url="jdbc:mysql://localhost:3306/tnsif b42";
		String user="root";
		String password="Bgsreddy@467";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		 
		//if user enters a wrong url,user or password
		Connection connectionObj;
		
			try {
				connectionObj=DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				connectionObj=null;
				System.out.println("Invalid data");
			}
			return connectionObj;
		
		
	}

}
