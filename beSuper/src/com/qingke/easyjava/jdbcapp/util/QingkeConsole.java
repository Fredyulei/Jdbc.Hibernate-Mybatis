package com.qingke.easyjava.jdbcapp.util;

import java.util.Scanner;

public class QingkeConsole {

	public QingkeConsole() {

	}

	public static void println(String str) {
		System.out.println(str);
	}

	public static void println(Object obj) {
		System.out.println(obj);
	}

	private static Scanner scanner = new Scanner(System.in);

	public static String askUserInput(String prompt) {
		String input = null;

		while (true) {
			System.out.println(prompt + ">");
			input = scanner.nextLine();
			// exit
			if (!input.trim().equals("")) {
				break;
			}
			System.out.println("请输入一个非空的内容!");
		}
		return input;
	}

	public static int askUserInputInt(String prompt) {
		int result = -1;
		while (true) {
			String out = askUserInput(prompt);
			try {
			result = Integer.parseInt(out);
			} catch (Exception e){
				println("请输入合法数字!");
			}
			if (result != -1) {
				break;
			}
		}
		return result;		
	}
}
