package service;

import java.util.Scanner;

public abstract class TestSearchByName {

	public static void main(String[] args) {
		System.out.print("社員名を入力してください：");
		Scanner s = new Scanner(System.in);
		String name = s.next();
		searchByName searchByName = new searchByName();
		searchByName.execute(name);
	}

}
