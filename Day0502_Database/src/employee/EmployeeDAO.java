package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER = "kwangmin";
	private static final String PWD = "1";
	private Connection conn;

	public EmployeeDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL,USER,PWD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Employee selectOne(int empNum) {
		String sql = "select * from employee"+
				" where enum = "+empNum;

		Employee emp = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if(rs.next()) {
				emp = new Employee(rs.getInt("enum"), rs.getString("ename"),
						rs.getInt("deptno"),rs.getInt("salary"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return emp;
	}
	public List<Employee> selectAll(){
		List<Employee> emps = new ArrayList<Employee>();
		String sql = "select * from employee";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				emps.add(new Employee(rs.getInt("enum"),rs.getString("ename"),
						rs.getInt("deptno"),rs.getInt("salary")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return emps;
	}
	public int deleteEmployee(int empNum) {
		int result = 0;
		String sql = "delete from employee"+
				" where enum = "+empNum;
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public int updateEmployee(Employee emp) {
		int result = 0;
		String sql = "update employee set "+
				"ename = '"+emp.getEname()+"',"+
				"deptno = "+emp.getDeptno()+","+
				"salary = "+emp.getSalary()+
				" where enum = "+emp.getEmpNum();

		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public int insertEmployee(Employee emp) {
		int result = 0;
		String sql = "insert into employee values("+
				emp.getEmpNum()+",'"+
				emp.getEname()+"',"+
				emp.getDeptno()+","+
				emp.getSalary()+")";

		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}
