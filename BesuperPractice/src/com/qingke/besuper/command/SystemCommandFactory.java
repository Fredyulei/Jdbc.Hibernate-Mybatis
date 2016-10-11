package com.qingke.besuper.command;

import java.util.HashMap;
import java.util.Map;

import com.qingke.besuper.command.impl.ExitCommand;


public class SystemCommandFactory extends CommandFactory {
	private static Map<CommandCode,Class<?extends Command>>commandmap=new HashMap<>();
	static{
		commandmap.put(CommandCode.EXIT, ExitCommand.class);
//		commandMap.put(CommandCode.HELP, HelpCommand.class);
//		commandMap.put(CommandCode.LOGIN, LoginCommand.class);
//		commandMap.put(CommandCode.SIGNUP, SignCommand.class);
//		commandMap.put(CommandCode.SCORE, ScoreCommand.class);
//		commandMap.put(CommandCode.LIST, ListCommand.class);
//		commandMap.put(CommandCode.ANSWER, AnswerCommand.class);
//		commandMap.put(CommandCode.ACCEPT, AcceptCommand.class);
	}
	public Command buildCommand(CommandCode cmdCode) {
		// TODO Auto-generated method stub
	Class<?extends Command>cmdClass=commandmap.get(cmdCode);
	Command command=null;
	try {
		command=cmdClass.newInstance();
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
