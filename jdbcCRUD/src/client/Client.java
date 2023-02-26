package client;

import services.StudentService;
import services.StudentServiceImpl;
import java.util.*;

import entities.Student;

public class Client {

	public static void main(String[] args) {
		int choice;
		StudentService service=new StudentServiceImpl();
		Scanner in=new Scanner(System.in);
		do {
			System.out.println("Enter your choice\n");
			System.out.println("1-Retrive a specific record\n2-Retrive all data\n3-Delete\n4-Insert\n5-Update\n0-Exit");
			choice=in.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter the Rollno you want to retrive");
				Student student;
				try {
				student=service.getStudent(in.nextInt());
				}
				catch(Exception e) {
					student=null;
				}
				if(student!=null)
					System.out.println(student);
				else
					System.out.println("Student not found");
			break;
			case 2:
				List<Student>obj=service.getAll();
				for(Student s:obj)
				{
					System.out.println(s);
				}
			break;
			case 3:
				System.out.println("Enter the Rollno you want to delete");
				boolean success=service.deleteStudent(in.nextInt());
				if(success)
					System.out.println("Data deleted successfully");
				else
					System.out.println("Details not found");
			break;
			case 4:
				System.out.println("Enter the details of the student");
				Student stud= new Student(in.nextInt(),in.nextLine());
				if(service.addStudent(stud))
					System.out.println("Data added successfully");
				else
					System.out.println("Error in insertion");
			break;
			case 5:
				System.out.println("Enter the Rollno you want to update");
				Student stud1=new Student();
				stud1.setRollno(in.nextInt());
				System.out.println("Enter the updated details");
				in.nextLine();
				stud1.setName(in.nextLine());
				Student s=service.updateStudent(stud1);
				if(s!=null)
					System.out.println("s");
				else
					System.out.println("Error in updating");
			break;
			case 0:
				System.out.println("Exiting!!");
			break;
			
		}
		}while(choice>0);
	}
}
