package services;

import java.util.List;

import entities.Student;

public interface StudentService {
	
	public boolean addStudent(Student studentObj);
	public Student updateStudent(Student studentObj);
	public Student getStudent(int rollno);
	public boolean deleteStudent(int rollno);
	public List<Student> getAll();


}
