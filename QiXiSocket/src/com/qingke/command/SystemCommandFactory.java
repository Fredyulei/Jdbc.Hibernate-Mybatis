package com.qingke.command;

import java.util.HashMap;
import java.util.Map;

import com.qingke.command.impl.ExitCommand;
import com.qingke.command.impl.HelpCommand;
import com.qingke.command.impl.LoginCommand;
import com.qingke.command.impl.SignupCommand;
public class SystemCommandFactory extends CommandFactory {

	private static Map<CommandCode,Class<? extends Command>> commandMap = new HashMap<>();
	
	static {
		commandMap.put(CommandCode.EXIT, ExitCommand.class);
		commandMap.put(CommandCode.HELP, HelpCommand.class);
		commandMap.put(CommandCode.LOGIN, LoginCommand.class);
		commandMap.put(CommandCode.SIGNUP, SignupCommand.class);
	}

	@Override
	public Command buildCommand(CommandCode cmd) {
		Class<? extends Command> comm = commandMap.get(cmd);
		
		if (comm != null) {
			try {
				return comm.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
