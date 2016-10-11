package com.qingke.besuper.command;

import com.qingke.besuper.content.Player;

public abstract class CommandFactory {
	public static enum CommandCode{
		//sysytem
		HELP,
		EXIT,
		LOGIN,
		SIGNUP,
		//PLAYER
		ANSWER,
		ASK,
		ACCEPT,
		SCORE,
		LIST,
	}
	public static CommandFactory getFactory(Player player){
		if(player==null){
			return new SystemCommandFactory();
		}
		return new PlayerCommandFactory(player);
	}
	public abstract Command buildCommand(CommandCode cmd);
	
}
