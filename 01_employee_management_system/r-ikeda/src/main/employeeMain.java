package main;

import java.util.Scanner;

import service.searchByDeptId;
import service.searchById;
import service.searchByName;
import service.searchAll;

public class employeeMain {

	public static void main(String[] args) {
		// TODO-[r-ikeda] Auto-generated method stub

		while (true) {
			// メニューの表示
			System.out.println("===社員管理システム===");
			System.out.println("1.全件表示");
			System.out.println("2.社員IDによる検索");
			System.out.println("3.社員名による検索");
			System.out.println("4.部署IDによる検索");
			System.out.println("5.終了");

			System.out.print("メニュー番号を入力しください：");
			Scanner s = new Scanner(System.in);
			int menuNumber = s.nextInt();

			if (menuNumber == 1) {
				searchAll searchAll = new searchAll();
				searchAll.execute();

			} else if (menuNumber == 2) {
				System.out.print("社員IDを入力してください：");
				int id = s.nextInt();
				searchById searchById = new searchById();
				searchById.execute(id);

			} else if (menuNumber == 3) {
				System.out.print("社員名を入力してください：");
				String name = s.next();
				searchByName searchByName = new searchByName();
				searchByName.execute(name);

			} else if (menuNumber == 4) {
				System.out.print("部署ID(1：営業部、2：経理部、3：総務部)を入力してください：");
				int dept_id = s.nextInt();
				searchByDeptId searchByDeptId = new searchByDeptId();
				searchByDeptId.execute(dept_id);

			} else if (menuNumber == 5) {
				System.out.println("システムを終了します");
				break;
				
			} else {
				System.out.println("存在しないメニュー番号です\r\n");
			}
		}
	}
}
