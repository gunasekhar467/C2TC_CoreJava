package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Student;
import repository.StudentRepository;
import repository.StudentRepositoryImpl;

public class StudentServiceImpl implements StudentService {

	@Override
	public boolean addStudent(Student studentObj) {
		String query="INSERT INTO STUDENT VALUES(?,?)";
		StudentRepository repo=new StudentRepositoryImpl();
		int count=repo.addQuery(query, studentObj);
		if(count==1)
			return true;
		return false;
	}

	@Override
	public Student updateStudent(Student studentObj) {
		String query="UPDATE STUDENT SET name = WHERE (rollno=?)";
		StudentRepository repo=new StudentRepositoryImpl();
		int count=repo.updateQuery(query, studentObj);
		if(count==1)
		{	
			Student s=getStudent(studentObj.getRollno());
			return s;
		}
		else
			return null;
	}

	@Override
	public Student getStudent(int rollno) {
		Student studentObj= new Student();
		StudentRepository repo=new StudentRepositoryImpl();
		String query="SELECT * FROM STUDENT WHERE rollno="+rollno;
		ResultSet ResultSetObj=repo.retriveQuery(query);
		
		try {
			ResultSetObj.next();
			studentObj.setRollno(ResultSetObj.getInt(1));
			studentObj.setName(ResultSetObj.getString(2));
		} catch (SQLException e) {
			System.out.println("Data not found");
		}
		
		return studentObj;
	}

	@Override
	public boolean deleteStudent(int rollno) {
		String query="DELETE FROM STUDENT WHERE rollno="+rollno;
		StudentRepository repo=new StudentRepositoryImpl();
		int count=repo.deleteQuery(query);
		if(count==1) 
			return true;
		return false;
	}

	@Override
	public List<Student> getAll() {
		List<Student> obj= new ArrayList<Student>();
		StudentRepository repo=new StudentRepositoryImpl();
		String query="SELECT * FROM STUDENT";
		ResultSet ResultSetObj=repo.retriveQuery(query);
		
		try {
			while(ResultSetObj.next())
			{
				Student studentObj=new Student();
				studentObj.setRollno(ResultSetObj.getInt(1));
				studentObj.setName(ResultSetObj.getString(2));
				obj.add(studentObj);
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return obj;
	}

}
