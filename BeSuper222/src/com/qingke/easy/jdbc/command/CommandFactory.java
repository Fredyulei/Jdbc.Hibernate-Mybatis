package com.qingke.easy.jdbc.command;

import com.qingke.easy.Player;
//方法，获得抽象工厂里的东西
public abstract class CommandFactory {
	public static enum CommandCode{
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
		if(player==null){
			return new SystemCommandFactory();
		}
		return new PlayerCommandFactory(player);
	}
//定义一个老板
	//public abstract Command buildCommand(String cmd);
	public abstract Command buildCommand(CommandCode cmd);
}
