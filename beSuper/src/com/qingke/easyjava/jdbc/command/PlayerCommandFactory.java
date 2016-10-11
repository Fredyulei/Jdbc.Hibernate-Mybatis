package com.qingke.easyjava.jdbc.command;

import com.qingke.easyjava.jdbc.command.impl.AskCommand;
import com.qingke.easyjava.jdbcapp.pojo.Player;

public class PlayerCommandFactory extends SystemCommandFactory {
	// public class PlayerCommandFactory extends CommandFactory{

	private Player player;

	public PlayerCommandFactory(Player player) {
		this.player = player;
	}

	@Override
	//public Command buildCommand(String cmd) {
	public Command buildCommand(CommandCode cmdCode) {
		Command command = null;
//		if (cmdCode.equalsIgnoreCase("ask")) {
//			// return new AskCommand(player);
//			command = new AskCommand(player);
//		}
//
//		if (command == null) {
//			command = super.buildCommand(cmdCode);
//		}

		//return null;
		return command;
	}
}
