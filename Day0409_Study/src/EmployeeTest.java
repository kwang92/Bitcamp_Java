
public class EmployeeTest {
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.name = "홍길동";
		emp.dept = "영업";
		emp.salary = 2000;
		
		System.out.println("hong1");
		emp.printEmployee();
		
		
		Employee emp2 = new Employee();
		emp2.setInfo(emp);
		System.out.println("copy");
		emp2.printEmployee();
		
		System.out.println("hong2");
		emp.printEmployee();
	}
}