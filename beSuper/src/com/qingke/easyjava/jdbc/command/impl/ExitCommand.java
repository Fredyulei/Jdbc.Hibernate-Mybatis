package com.qingke.easyjava.jdbc.command.impl;

import com.qingke.easyjava.jdbc.command.Command;

public class ExitCommand implements Command {

	@Override
	public void execute() {
		System.exit(0);
	}

}
