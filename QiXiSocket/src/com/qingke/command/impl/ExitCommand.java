package com.qingke.command.impl;

import com.qingke.command.Command;

public class ExitCommand implements Command {
	@Override
	public void execute() {
		System.out.println("欢迎再次使用本系统,再见");
	}
}
