package com.qingke.command;

import test.domain.Users;

public abstract class CommandFactory {

	public static enum CommandCode {
		// system
		EXIT, HELP, LOGIN, SIGNUP,

		// client
		BUY, RELEASE, MANAGE, REGISTER, LOOK, ALTER
	}

	public static CommandFactory getFactory(Users user) {
		if (user == null) {
			return new SystemCommandFactory();
		}
		return new UserCommandFactory(user);
	}

	public abstract Command buildCommand(CommandCode cmd);

}
