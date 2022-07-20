package service;

import java.util.Scanner;

public class TestSearchByDeptId {

	public static void main(String[] args) {
		System.out.print("部署ID(1：営業部、2：経理部、3：総務部)を入力してください：");
		Scanner s = new Scanner(System.in);
		int dept_id = s.nextInt();
		searchByDeptId searchByDeptId = new searchByDeptId();
		searchByDeptId.execute(dept_id);
	}

}
