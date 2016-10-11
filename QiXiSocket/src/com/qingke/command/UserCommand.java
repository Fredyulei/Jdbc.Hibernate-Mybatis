package com.qingke.command;

import com.qingke.util.Console;

import test.domain.Users;

public abstract class UserCommand implements Command {
	protected Users user;

	public UserCommand(Users user) {
		this.user = user;
	}
	
	@Override
	public void execute() {
		if (user == null) {
			Console.println("系统用户不存在！");
			return;
		}
		executPlayerCommand();
	}

	public abstract void executPlayerCommand();

}
