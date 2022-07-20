package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dao.employeeDao;
import entity.employee;

public class searchByDeptId {

	public void execute(int dept_id) {
		employeeDao dao = new employeeDao();

		// 入力チェック（存在する部署か）
		if (dept_id >= 1 && dept_id <= 3) {

			// 該当社員データの取得
			List<employee> empList = dao.searchByDeptId(dept_id);

			if (!empList.isEmpty()) {
				System.out.println(
						"社員ID\t" + "パスワード\t" + "社員名\t" + "性別\t" + "住所\t" + "生年月日\t" + "部署名\t");

				// 拡張for文による繰り返し表示
				for (employee emp : empList) {

					// 性別を日本語で表現
					String gender;
					if (emp.getGender() == 1) {
						gender = "男性";
					} else {
						gender = "女性";
					}

					// dateのフォーマット指定
					Date bday = emp.getBirthday();
					SimpleDateFormat sdf = new SimpleDateFormat("y/M/d");

					// それぞれの値を表示する
					System.out.print(emp.getEmp_id() + "\t");
					System.out.print(emp.getEmp_pass() + "\t");
					System.out.print(emp.getEmp_name() + "\t");
					System.out.print(gender + "\t");
					System.out.print(emp.getAddress() + "\t");
					System.out.print(sdf.format(bday) + "\t");
					System.out.println(emp.getDept_name() + "\t");
				}
				
			} else {
				System.out.println("該当する社員は存在しません");
			}

		} else {
			System.out.println("該当する部署は存在しません");
		}

	}

}
