package com.qingke.command.impl;

import com.qingke.command.Command;
import com.qingke.util.Console;

public class HelpCommand implements Command {
	@Override
	public void execute() {
		Console.println("命令操作字符如下，请输入一下操作,获取信息");
		Console.println("-> \"HELP\"  提示命令功能");
		Console.println("-> \"EXIT\"  退出系统");
		Console.println("-> \"LOGIN\"  登录系统");
		Console.println("-> \"SIGNUP\"  用戶注册");
		Console.println("-> \"LOOK\"  查看记录");
	}
}
