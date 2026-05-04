import java.util.Scanner;
import parent.Person;
import child.Teacher; 
import child.Student;
public class Tdd{
public static void main(String[]args){
	
	Person p=new Person("Shajira",18);
	
    Teacher t=new Teacher(p.getName(),p.getAge(),"Maths",5000);
	//System.out.println("Name:"+t.name+" " +"Age:"+t.age+" "+"Subject:" +t.subject+" "+"Salary:"+t.salary);
	
	//System.out.println(p.getRole() + " " + t.getRole());
	Person p2=new Student("Sabira",23,89,1876);
	System.out.println(p2);
	
	System.out.println(t);
	
	Student s=new Student(p.getName(),p.getAge(),95,1648);
	System.out.println(s);
	
	p.showAge();
	
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter your Name:");  //used print instead of println to not to see in next line
	String name=sc.nextLine();
	
	Student s2=new Student();
	s2.setName(name);
	s2.setAge(18);
	s2.setMark(98);
	s2.setAdmno(1783);
	System.out.println(s2);

}	
}

