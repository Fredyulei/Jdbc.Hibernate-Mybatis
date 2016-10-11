package com.qingke.besuper.util;

import java.util.Scanner;

public class QingkeConsole {
	
	public QingkeConsole() {
	}
	public static void println(String str) {
		System.out.println(str);
	}
	public static void println(Object obj){
		System.out.println(obj);
	}
	private static Scanner scanner = new Scanner(System.in);

	public static String askuserInput(String prompt) {
		System.out.println(prompt + ">");
		String input = null;
		while (true) {
			input = scanner.nextLine();
			if (input.trim().equals("")) {
				System.out.println("������һ���ǿ�����");
			}
			break;
		}
		return input;
	}
	public static int askuserInputInt(String prompt){
		int result=-1;
		while(true){
			String out=askuserInput(prompt);
			try {
				//ת��
				int a = Integer.parseInt(out);
				return a;
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
	public static int askuserInputInt(String prompt,boolean isRequire){
		if(isRequire){
			return askuserInputInt(prompt);
		}
		try{
		  System.out.println(prompt+":");
		  String str=scanner.nextLine();
		  return Integer.parseInt(str);
		}catch(Exception e){
			println("���Ϸ����֣�Ĭ��������0");
		}
		return 0;
	}
	public static void terminate(){
		println("�ټ�");
		System.exit(0);
	}

}