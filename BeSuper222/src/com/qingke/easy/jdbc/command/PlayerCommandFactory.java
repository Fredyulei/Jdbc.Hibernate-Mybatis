package com.qingke.easy.jdbc.command;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.qingke.easy.Player;
import com.qingke.easy.jdbc.command.impl.AcceptCommand;
import com.qingke.easy.jdbc.command.impl.AnswerCommand;
import com.qingke.easy.jdbc.command.impl.AskCommand;
import com.qingke.easy.jdbc.command.impl.ExitCommand;
import com.qingke.easy.jdbc.command.impl.HelpCommand;
import com.qingke.easy.jdbc.command.impl.ListCommand;
import com.qingke.easy.jdbc.command.impl.ScoreCommand;

public class PlayerCommandFactory extends SystemCommandFactory {
	//类的变量static,不是对象的。
	private static Map<CommandCode, Class<? extends Command>> commandMap = new HashMap<>();
	static {
		commandMap.put(CommandCode.LIST, ListCommand.class);
		commandMap.put(CommandCode.SCORE, ScoreCommand.class);
		commandMap.put(CommandCode.ASK, AskCommand.class);
		commandMap.put(CommandCode.ACCEPT, AcceptCommand.class);
		commandMap.put(CommandCode.ANSWER, AnswerCommand.class);
	}
	private Player player;

	public PlayerCommandFactory(Player player) {
		this.player = player;
	}

	@Override
	public Command buildCommand(CommandCode cmdCode) {
		Command command = null;
		Class<? extends Command> cmdClass = commandMap.get(cmdCode);
		if (cmdClass != null) {
			try {
				command = cmdClass.getConstructor(Player.class).newInstance(player);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (command == null) {
			command = super.buildCommand(cmdCode);
		}
		return command;

	}

}
