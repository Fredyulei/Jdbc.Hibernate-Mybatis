package com.qingke.easy.jdbc.command;

import com.qingke.easy.Player;
//��������ó��󹤳���Ķ���
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
//����һ���ϰ�
	//public abstract Command buildCommand(String cmd);
	public abstract Command buildCommand(CommandCode cmd);
}
