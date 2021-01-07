package work12;

import java.util.*;

public class subject2 {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Set<Student> students = new TreeSet<Student>();
        
        while(true){
        	System.out.println("请输入学生信息(学号/姓名/年龄)：");
            String id = input.next();
            if("exit".equals(id))
                break;
            String name = input.next();
            int age = input.nextInt();
            Student x = new Student(id,name,age);
            students.add(x);
        }
        for (Student student : students)
            System.out.println(student.toString());
    }
}

class Student implements Comparable<Student>{
	private String id;
	private String name;
	private int age;
	
	public Student() {
		super();
	}
	
    public Student(String id,String name,int age){
    	super();
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public int compareTo(Student stu) {
		return this.age-stu.age;
	}
    
	public String toString() {
		return "Student [ 学号：" + id + " 姓名：" + name + " 年龄：" + age + "]";
	}
}