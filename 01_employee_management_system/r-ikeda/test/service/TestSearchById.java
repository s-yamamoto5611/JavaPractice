package service;

import java.util.Scanner;

public class TestSearchById {

	public static void main(String[] args) {
		System.out.print("社員IDを入力してください：");
		Scanner s = new Scanner(System.in);
		int id = s.nextInt();
		searchById searchById = new searchById();
		searchById.execute(id);
	}

}
