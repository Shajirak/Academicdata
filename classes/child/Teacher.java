package child;
import parent.Person;

public class Teacher extends Person{
    private String  subject;
    private double  salary;

public Teacher(String name, int age, String subject,double salary){
    super(name,age);
    this.subject=subject;
    this.salary=salary;
	}
	
public String getSubject(){
   return subject;
}
public double getSalary(){
   return salary;
}   

@Override
public String getRole (){
    return"Teacher";
	}
	
@Override
public String toString(){
    return super.toString()+" , Subject:"+subject +" , Salary:"+salary;	
}	
}	
   
   