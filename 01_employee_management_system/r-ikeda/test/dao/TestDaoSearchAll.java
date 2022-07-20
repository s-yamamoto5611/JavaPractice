package dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dao.employeeDao;
import entity.employee;

public class TestDaoSearchAll {

	public static void main(String[] args) {
		employeeDao dao = new employeeDao();

		//社員全件データの取得
		List<employee> empList = dao.searchAll();

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
		}else{
			System.out.println("null");
		}
	}
}
