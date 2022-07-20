package dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entity.employee;

public class TestDaoSearchByDeptId {

	public static void main(String[] args) {
		employeeDao dao = new employeeDao();

		// 標準入力
		System.out.print("部署ID(1：営業部、2：経理部、3：総務部)を入力してください：");
		Scanner s = new Scanner(System.in);
		int dept_id = s.nextInt();

		// 該当社員のデータ取得
		List<employee> empList = dao.searchByDeptId(dept_id);

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
