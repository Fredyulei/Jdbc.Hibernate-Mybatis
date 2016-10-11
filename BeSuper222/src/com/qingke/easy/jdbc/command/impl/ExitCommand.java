package com.qingke.easy.jdbc.command.impl;

import com.qingke.easy.jdbc.command.Command;

public class ExitCommand implements Command {

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.exit(0);
	}

}
