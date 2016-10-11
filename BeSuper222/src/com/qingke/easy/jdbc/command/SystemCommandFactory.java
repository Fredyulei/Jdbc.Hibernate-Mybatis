package com.qingke.easy.jdbc.command;

import java.util.HashMap;
import java.util.Map;

import com.qingke.easy.jdbc.command.impl.AcceptCommand;
import com.qingke.easy.jdbc.command.impl.AnswerCommand;
import com.qingke.easy.jdbc.command.impl.ExitCommand;
import com.qingke.easy.jdbc.command.impl.HelpCommand;
import com.qingke.easy.jdbc.command.impl.ListCommand;
import com.qingke.easy.jdbc.command.impl.LoginCommand;
import com.qingke.easy.jdbc.command.impl.ScoreCommand;
import com.qingke.easy.jdbc.command.impl.SignCommand;

public class SystemCommandFactory extends CommandFactory {

	private static Map<CommandCode, Class<? extends Command>> commandMap = new HashMap<>();

	static {
		commandMap.put(CommandCode.EXIT, ExitCommand.class);
		commandMap.put(CommandCode.HELP, HelpCommand.class);
		commandMap.put(CommandCode.LOGIN, LoginCommand.class);
		commandMap.put(CommandCode.SIGNUP, SignCommand.class);
		commandMap.put(CommandCode.SCORE, ScoreCommand.class);
		commandMap.put(CommandCode.LIST, ListCommand.class);
		commandMap.put(CommandCode.ANSWER, AnswerCommand.class);
		commandMap.put(CommandCode.ACCEPT, AcceptCommand.class);		
	}

	public Command buildCommand(CommandCode cmdCode) {
		Class<? extends Command> cmdClass = commandMap.get(cmdCode);

		Command command = null;
		try {
			command = cmdClass.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return command;
	}
}
