package com.qingke.easyjava.jdbc.command;

import com.qingke.easyjava.jdbcapp.pojo.Player;

public abstract class PlayerCommand implements Command {
	
	protected Player player;
	
	public PlayerCommand(Player player) {
		this.player = player;
	}
	
}
