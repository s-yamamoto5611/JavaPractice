package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.department;
import entity.employee;

public class employeeDao {

	// 全件検索
	public List<employee> searchAll() {
		List<employee> empList = new ArrayList<employee>();
		String sql = "SELECT employee.emp_id , employee.emp_pass , employee.emp_name , employee.gender , employee.address , employee.birthday , employee.dept_id , department.dept_name FROM employee JOIN department ON employee.dept_id = department.dept_id;";

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/practice",
				"root", "r-ikeda"); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			// System.out.println("Connected");

			while (rs.next()) {
				employee emp = new employee();
				emp.setEmp_id(rs.getInt("emp_id"));
				emp.setEmp_pass(rs.getString("emp_pass"));
				emp.setEmp_name(rs.getString("emp_name"));
				emp.setGender(rs.getInt("gender"));
				emp.setAddress(rs.getString("address"));
				emp.setBirthday(rs.getDate("birthday"));
				emp.setDept_id(rs.getInt("dept_id"));
				emp.setDept_name(rs.getString("dept_name"));
				empList.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print("DB接続に失敗しました");
		}
		return empList;
	}

	
	//ID検索
	public employee searchById(int id) {
		employee emp = new employee();
		String sql = "SELECT employee.emp_id , employee.emp_pass , employee.emp_name , employee.gender , employee.address , employee.birthday , employee.dept_id , department.dept_name FROM employee JOIN department ON employee.dept_id = department.dept_id WHERE emp_id = ? ;";

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/practice",
				"root", "r-ikeda"); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				emp.setEmp_id(rs.getInt("emp_id"));
				emp.setEmp_pass(rs.getString("emp_pass"));
				emp.setEmp_name(rs.getString("emp_name"));
				emp.setGender(rs.getInt("gender"));
				emp.setAddress(rs.getString("address"));
				emp.setBirthday(rs.getDate("birthday"));
				emp.setDept_id(rs.getInt("dept_id"));
				emp.setDept_name(rs.getString("dept_name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print("DB接続に失敗しました");
		}
		return emp;
	}

	
	//名前部分一致検索
	public List<employee> searchByName(String name) {
		List<employee> empList = new ArrayList<employee>();
		String sql = "SELECT employee.emp_id , employee.emp_pass , employee.emp_name , employee.gender , employee.address , employee.birthday , employee.dept_id , department.dept_name FROM employee JOIN department ON employee.dept_id = department.dept_id WHERE emp_name LIKE ?;";

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/practice",
				"root", "r-ikeda"); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, "%" + name + "%");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				employee emp = new employee();
				emp.setEmp_id(rs.getInt("emp_id"));
				emp.setEmp_pass(rs.getString("emp_pass"));
				emp.setEmp_name(rs.getString("emp_name"));
				emp.setGender(rs.getInt("gender"));
				emp.setAddress(rs.getString("address"));
				emp.setBirthday(rs.getDate("birthday"));
				emp.setDept_id(rs.getInt("dept_id"));
				emp.setDept_name(rs.getString("dept_name"));
				empList.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print("DB接続に失敗しました");
		}
		return empList;
	}

	
	//部署ID検索
	public List<employee> searchByDeptId(int dept_id) {
		List<employee> empList = new ArrayList<employee>();
		String sql = "SELECT employee.emp_id , employee.emp_pass , employee.emp_name , employee.gender , employee.address , employee.birthday , employee.dept_id , department.dept_name FROM employee JOIN department ON employee.dept_id = department.dept_id WHERE department.dept_id = ? ;";

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/practice",
				"root", "r-ikeda"); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, dept_id);
			ResultSet rs = pstmt.executeQuery();
			// System.out.println("Connected");

			while (rs.next()) {
				employee emp = new employee();
				emp.setEmp_id(rs.getInt("emp_id"));
				emp.setEmp_pass(rs.getString("emp_pass"));
				emp.setEmp_name(rs.getString("emp_name"));
				emp.setGender(rs.getInt("gender"));
				emp.setAddress(rs.getString("address"));
				emp.setBirthday(rs.getDate("birthday"));
				emp.setDept_id(rs.getInt("dept_id"));
				emp.setDept_name(rs.getString("dept_name"));
				empList.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print("DB接続に失敗しました");
		}
		return empList;

	}
}