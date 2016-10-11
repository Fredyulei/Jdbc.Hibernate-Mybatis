package com.qingke.jdbcapp.util;

import java.util.Scanner;
//一个控制台
public class QingkeConsole {
	//
	private QingkeConsole() {
	}

	public static void println(String str) {
		System.out.println(str);
	}
//对象输出
	public static void println(Object obj) {
		System.out.println(obj);
	}
//
	private static Scanner scanner = new Scanner(System.in);
//
	public static  String askUserInput(String prompt) {
		System.out.println(prompt + ">");
		String input = null;
		while (true) {
			input = scanner.nextLine();
			if (!input.trim().equals("")) {
				break;
			}
			println("请输入一个非空内容");
		}
		return input;
	}
	public static int askUserInputInt(String prompt) {	
		int result = -1;
		while (true) {
			String out = askUserInput(prompt);
			try {
				//转型
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
	public static int askUserInputInt(String prompt, boolean isRequired) {

		if (isRequired) {
			return askUserInputInt(prompt);
		}
		try {
			System.out.print(prompt + ": ");

			String str = scanner.nextLine();
			return Integer.parseInt(str);
		} catch (Exception e) {
			println("不合法的数字！默认使用0");
		}
		return 0;
	}
	public static void terminate() {
		println("再见！");
		System.exit(0);
	}
}
