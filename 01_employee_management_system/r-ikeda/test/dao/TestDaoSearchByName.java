package dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entity.employee;

public class TestDaoSearchByName {

	public static void main(String[] args) {
		
		// 標準入力
		System.out.print("社員名を入力してください：");
		Scanner s = new Scanner(System.in);
		String name = s.next();

		employeeDao dao = new employeeDao();
		List<employee> empList = dao.searchByName(name);

		if (!empList.isEmpty()) {

			// 拡張for文による繰り返し表示
			for (employee emp : empList) {

				// それぞれの値を表示する
				System.out.print(emp.getEmp_id() + "\t");
				System.out.print(emp.getEmp_pass() + "\t");
				System.out.print(emp.getEmp_name() + "\t");
				System.out.print(emp.getGender() + "\t");
				System.out.print(emp.getAddress() + "\t");
				System.out.print(emp.getBirthday() + "\t");
				System.out.println(emp.getDept_name() + "\t");
			}
			
		} else {
			System.out.println("null");
		}
	}
}
