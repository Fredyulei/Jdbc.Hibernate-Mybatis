package com.qingke.jdbcapp.util;

import java.util.Scanner;
//һ������̨
public class QingkeConsole {
	//
	private QingkeConsole() {
	}

	public static void println(String str) {
		System.out.println(str);
	}
//�������
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
			println("������һ���ǿ�����");
		}
		return input;
	}
	public static int askUserInputInt(String prompt) {	
		int result = -1;
		while (true) {
			String out = askUserInput(prompt);
			try {
				//ת��
				result = Integer.parseInt(out);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				println("������һ����ȷ������ ");
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
			println("���Ϸ������֣�Ĭ��ʹ��0");
		}
		return 0;
	}
	public static void terminate() {
		println("�ټ���");
		System.exit(0);
	}
}
