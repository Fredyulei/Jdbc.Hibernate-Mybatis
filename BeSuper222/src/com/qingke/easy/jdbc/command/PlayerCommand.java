package com.qingke.easy.jdbc.command;

import com.qingke.easy.Player;
import com.qingke.jdbcapp.util.QingkeConsole;

public abstract class PlayerCommand implements Command {
	protected Player player;
	// ����player
	public PlayerCommand(Player player) {
		this.player = player;
	}
	public void execute() {
		if (player == null) {
			QingkeConsole.println("ϵͳ�û�������");
		}
		executePlayerCommand();
	}
	public abstract void executePlayerCommand();
}
