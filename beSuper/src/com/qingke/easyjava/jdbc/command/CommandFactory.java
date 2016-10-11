package com.qingke.easyjava.jdbc.command;

import com.qingke.easyjava.jdbcapp.pojo.Player;

public abstract class CommandFactory {

	public static enum CommandCode {
		//system
		EXIT,
		HELP,
		LOGIN,
		SIGNUP,
		
		//player
		ASK,
		ANSWER,
		SCORE,
		LIST,
		ACCEPT
	}
	public static CommandFactory getFactory(Player player) {
		if (player == null) {
			return new SystemCommandFactory();
		}
		return new PlayerCommandFactory(player);
	}

	//public abstract Command buildCommand(String cmd);
	public abstract Command buildCommand(CommandCode cmd);
}
