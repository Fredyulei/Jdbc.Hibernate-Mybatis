package com.qingke.command.impl;

import com.qingke.command.Command;
import com.qingke.util.Console;

public class HelpCommand implements Command {
	@Override
	public void execute() {
		Console.println("��������ַ����£�������һ�²���,��ȡ��Ϣ");
		Console.println("-> \"HELP\"  ��ʾ�����");
		Console.println("-> \"EXIT\"  �˳�ϵͳ");
		Console.println("-> \"LOGIN\"  ��¼ϵͳ");
		Console.println("-> \"SIGNUP\"  �Ñ�ע��");
		Console.println("-> \"LOOK\"  �鿴��¼");
	}
}
