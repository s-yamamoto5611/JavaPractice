package dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entity.employee;

public class TestDaoSearchById {

	public static void main(String[] args) {
		employeeDao dao = new employeeDao();

		// 標準入力
		System.out.print("社員IDを入力してください：");
		Scanner s = new Scanner(System.in);
		int id = s.nextInt();

		// 該当社員のデータ取得
		employee emp = dao.searchById(id);

		if (emp.getEmp_id() != 0) {
			
			// それぞれの値を表示する
			System.out.print(emp.getEmp_id() + "\t");
			System.out.print(emp.getEmp_pass() + "\t");
			System.out.print(emp.getEmp_name() + "\t");
			System.out.print(emp.getGender() + "\t");
			System.out.print(emp.getAddress() + "\t");
			System.out.print(emp.getBirthday() + "\t");
			System.out.println(emp.getDept_name() + "\t");
			
		} else{
			System.out.println("null");
		}
	}
}
