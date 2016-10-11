package com.qingke.besuper.command;

import java.util.HashMap;
import java.util.Map;

import com.qingke.besuper.content.Player;

public class PlayerCommandFactory extends SystemCommandFactory{
	private static Map<CommandCode, Class<? extends Command>> commandMap = new HashMap<>();
	static {
//		commandMap.put(CommandCode.LIST, ListCommand.class);
//		commandMap.put(CommandCode.SCORE, ScoreCommand.class);
//		commandMap.put(CommandCode.ASK, AskCommand.class);
//		commandMap.put(CommandCode.ACCEPT, AcceptCommand.class);
//		commandMap.put(CommandCode.ANSWER, AnswerCommand.class);
	}
	private Player player;

	public PlayerCommandFactory(Player player) {
		this.player = player;
	}
}
