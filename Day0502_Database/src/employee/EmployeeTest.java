package employee;

import java.util.List;

public class EmployeeTest {
	public static void main(String[] args) {
		EmployeeDAO emp = new EmployeeDAO();
		List<Employee> show;
		
	// insert Test
	//	emp.insertEmployee(new Employee(1,"류광민",1,10000000));
		
	// delete Test
	//	emp.deleteEmployee(3);
		
	// update Test
	//	emp.updateEmployee(new Employee(2,"홍길도롱",3,500000));
		
	// selectAll Test
		show = emp.selectAll();
		for(int i = 0; i < show.size(); i++) {
			System.out.println(show.get(i));
		}
	
	// selectOne Test
		System.out.println("====================================================");
		System.out.println(emp.selectOne(1));
		
	}
}
