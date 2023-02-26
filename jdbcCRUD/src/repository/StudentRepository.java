package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import entities.Student;

public interface StudentRepository {
	
	Statement createStatement();
	PreparedStatement createPreparedStatement(String query);
	
	//user-defined methods for curd operations
	int addQuery(String query, Student studentObj);
	public ResultSet retriveQuery(String query);
	int updateQuery(String query, Student studentObj);
	int deleteQuery(String query);


}
