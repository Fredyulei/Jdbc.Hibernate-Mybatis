package com.qingke.easyjava.jdbcapp.pojo;

import java.util.Scanner;

public class Question {

	public Question() {
		
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
		
		while(true) {
			System.out.println(prompt + ">");
			input = scanner.nextLine();
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
