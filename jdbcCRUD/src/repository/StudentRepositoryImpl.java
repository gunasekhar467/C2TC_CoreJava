package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.StudentDao;
import entities.Student;

public class StudentRepositoryImpl implements StudentRepository {
	
	StudentDao dao;
	

	public StudentRepositoryImpl() {
		super();
		dao= new StudentDao();
	}

	@Override
	public Statement createStatement() {
		Connection connectionObj=dao.createConnection();
		Statement statementObj;
		try {
			statementObj=connectionObj.createStatement();
		} catch (SQLException e) {
			statementObj=null;
			System.out.println("Invalid data");
		}
		return statementObj;
	}

	@Override
	public PreparedStatement createPreparedStatement(String query) {
		Connection connectionObj=dao.createConnection();
		PreparedStatement preparedStatementObj;
		try {
			preparedStatementObj=connectionObj.prepareStatement(query);
		} catch (SQLException e) {
			preparedStatementObj=null;
			System.out.println("Invalid data");
		}
		return preparedStatementObj;
	}

	@Override
	public int addQuery(String query, Student studentObj) {

		PreparedStatement preparedStatementObj=createPreparedStatement(query);
		int count=0;
		
		try {
			preparedStatementObj.setInt(1, studentObj.getRollno());
			preparedStatementObj.setString(2, studentObj.getName());
			count=preparedStatementObj.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Data not found");
		}
		
		return count;
	}

	@Override
	public ResultSet retriveQuery(String query) {
		Statement statementObj=createStatement();
		ResultSet ResultSetObj;
		try {
			ResultSetObj=statementObj.executeQuery(query);
		} catch (SQLException e) {
			ResultSetObj=null;
			System.out.println("Data not found");
			}
		return ResultSetObj;
	}

	@Override
	public int updateQuery(String query, Student studentObj) {
		PreparedStatement preparedStatementObj=createPreparedStatement(query);
		int count=0;
		
		try {
			preparedStatementObj.setInt(2, studentObj.getRollno());
			preparedStatementObj.setString(1, studentObj.getName());
			count=preparedStatementObj.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Data not found");
		}
		
		return count;
	}
	

	@Override
	public int deleteQuery(String query) {
		Statement statementObj=createStatement();
		int count=0;
		try {
			count=statementObj.executeUpdate(query);
		} catch (SQLException e) {
			count=0;	
			System.out.println("Invalid data");
		}
		return count;
	}

}
