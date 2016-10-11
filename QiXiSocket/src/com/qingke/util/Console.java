package com.qingke.util;

import java.util.Scanner;

public class Console {

	public Console() {

	}

	public static void println(String str) {
		System.out.println(str);
	}

	public static void println(Object obj) {
		System.out.println(obj);
	}

	private static Scanner sc = new Scanner(System.in);

	public static String Input(String promt) {
		String input = null;
		while (true) {
			System.out.print(promt + " : ");
			input = sc.nextLine();
			if (!input.trim().equals("")) {
				break;
			}
			println("������һ���ǿյ� ����!");
		}
		return input;
	}

	public static int InputInt(String promt) {
		int input = -1;
		while (true) {
			String out = Console.Input(promt);
			try {
				input = Integer.parseInt(out);
			} catch (Exception e) {
				println("������Ϸ�����!");
			}
			if (input != -1) {
				break;
			}
		}
		return input;
	}
}
