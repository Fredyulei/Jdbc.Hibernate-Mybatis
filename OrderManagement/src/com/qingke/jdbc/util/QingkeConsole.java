package com.qingke.jdbc.util;

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
		System.out.println(prompt + ">");
		String input = null;
		while (true) {
			input = scanner.nextLine();
			if (!input.trim().equals("")) {
				break;
			}
			System.out.println("请输入一个非空集合");
		}
		return input;
	}

	public static int askUserInputInt(String prompt) {
		int result = -1;
		while (true) {
			String out = askUserInput(prompt);
			try {
				result = Integer.parseInt(out);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				println("请输入一个正确的数字 ");
			}
			if (result != -1) {
				break;
			}
		}
		return result;
	}
	public static void terminate() {
		println("再见！");
		System.exit(0);
	}
}
