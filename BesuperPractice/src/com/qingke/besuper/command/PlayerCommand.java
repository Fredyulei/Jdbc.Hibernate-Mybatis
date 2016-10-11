package com.qingke.besuper.command;

import com.qingke.besuper.content.Player;
import com.qingke.besuper.util.QingkeConsole;

public abstract class PlayerCommand implements Command {
	protected Player player;
	public PlayerCommand(Player player){
		this.player=player;
	}
	public void execute(){
		if(player==null){
			QingkeConsole.println("用户不存在");
		}
		executePlayerCommand();
	}
	public abstract void executePlayerCommand();
}
