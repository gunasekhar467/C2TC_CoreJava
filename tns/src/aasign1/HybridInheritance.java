package aasign1;
import java.util.*;

class School
{
	Scanner in=new Scanner(System.in);
	String schoolname="CapGemini";
 public void school_func()
 {
	 
   System.out.println("This is School class "+schoolname);
 }
}
 
class Principal extends School
{
	String principalname="B-42";
 public void principal_func()
 {
	 
   System.out.println("This is Principal class "+principalname);
 }
}
 
class Teacher1 extends Principal
{
 public void Teacher1_func()
 {
	 System.out.println("Enter Teacher1 name");
	 String teacher1name=in.nextLine();
   System.out.println("Inside the Teacher1 Class "+teacher1name);
	 Teacher1 ob=new Teacher1();
   System.out.println("Teacher1 class has inherited "+ob.principalname+" class");
 }
}
 
class Teacher2 extends Principal
{

	
 
 public void Teacher2_func()
 {
	 System.out.println("Enter Teacher2 name");
	 String teacher2name=in.nextLine();
   System.out.println("Inside the Teacher1 Class "+teacher2name);
	 Teacher2 ob1=new Teacher2();
	   System.out.println("Teacher2 class has inherited "+ob1.principalname+" class");
 }
}


public class HybridInheritance
{
 public static void main(String[]args)
 {
   Teacher1 obj = new Teacher1();
   obj.Teacher1_func();  // Accessing teacher1 class method
   obj.principal_func();  // Accessing principal class method
   obj.school_func();  // Accessing school class method
   System.out.println("===================================================");
   Teacher2 obj1 = new Teacher2();
   obj1.Teacher2_func();  // Accessing teacher1 class method
   obj1.principal_func();  // Accessing principal class method
   obj1.school_func();  // Accessing school class method
 }
}
