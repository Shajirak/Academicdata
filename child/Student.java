package child;
import parent.Person;

public class Student extends Person{
   private  float mark;
   private 	double admno;
	
public Student (String name,int age,float mark,double admno){
    super(name,age);
	this.mark=mark;
    this.admno=admno;
	}
	
public float getMark(){
    return mark;
}
public double getAdmno(){
    return admno;
}

public Student () {	
 super();
}
public void setMark(float mark){
	this.mark=mark;
}
public void setAdmno(double admno){
	this.admno=admno;
}

@Override
  public String getRole(){
  return "Student";
  }
  
@Override 
  public String toString(){
    return super.toString() + " , Mark:" + mark + ", Admno:" + admno;   
  
}  
}
	