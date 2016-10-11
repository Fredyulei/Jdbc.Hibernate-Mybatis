package com.qingke.easyjava.jdbc.command;

import java.util.HashMap;
import java.util.Map;

import com.qingke.easyjava.jdbc.command.impl.ExitCommand;
import com.qingke.easyjava.jdbc.command.impl.HelpCommand;
import com.qingke.easyjava.jdbc.command.impl.LoginCommand;
import com.qingke.easyjava.jdbc.command.impl.SignCommand;

public class SystemCommandFactory extends CommandFactory {

	private static Map<CommandCode,Class<? extends Command>> commandMap = new HashMap<>();
	
	static {
		commandMap.put(CommandCode.EXIT, ExitCommand.class);
		commandMap.put(CommandCode.HELP, HelpCommand.class);
		commandMap.put(CommandCode.LOGIN, LoginCommand.class);
		commandMap.put(CommandCode.SIGNUP, SignCommand.class);
	}
	@Override
	public Command buildCommand(CommandCode cmdCode) {
		Class<? extends Command> cmdClass = commandMap.get(cmdCode);
		
		if (cmdCode != null) {
			
		}
		return null;
	}

}
		
		
////	public Command buliCommand(String identifier) {		
////	if (identifier.equalsIgnoreCase("exit")) { 
////			return new ExitCommand();
////		} else if (identifier.equalsIgnoreCase("help")) {
////			return new HelpCommand();
////		}
////		return null;
////	}
////
////	@Override
////	public Command buildCommand(String cmd) {
////		return null;
////	}
////		return null;
////	}
////}
//public class CommandFactory {
//
//	public Command buliCommand(String identifier) {
//		if (identifier.equalsIgnoreCase("exit")) { 
//			return new ExitCommand();
//		} else if (identifier.equalsIgnoreCase("help")) {
//			return new HelpCommand();
//		}
//		
//		return null;
//	}
//}