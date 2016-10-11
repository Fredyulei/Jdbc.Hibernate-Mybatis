package com.qingke.easyjava.jdbc.command.impl;

import com.qingke.easyjava.jdbc.command.PlayerCommand;
import com.qingke.easyjava.jdbcapp.pojo.Player;
import com.qingke.easyjava.jdbcapp.util.QingkeConsole;

public class AskCommand extends PlayerCommand {
	
	private Player player;

	public AskCommand(Player player) {
		super(player);		
	}

	@Override
	public void execute() {
		if(player == null) {
			QingkeConsole.println("用户没有登陆");
			return;
		}
		
	}

}
