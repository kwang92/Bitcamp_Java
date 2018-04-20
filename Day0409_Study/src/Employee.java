
public class Employee {
	String name;
	String dept;
	int salary;
	
	public void printEmployee() {
		System.out.println("이름 : "+name);
		System.out.println("부서 : "+dept);
		System.out.println("연봉 : "+salary);
	}
	public void setInfo(Employee e) {
		name = e.name;
		salary = e.salary;
		dept = e.dept;
		
		e.name = "완료";
		e.salary = 0;
		e.dept = "완료";
	}
	
}

