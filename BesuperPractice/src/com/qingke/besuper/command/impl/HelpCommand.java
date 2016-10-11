package com.qingke.besuper.command.impl;

import com.qingke.besuper.command.SystemCommand;
import com.qingke.besuper.util.QingkeConsole;

public class HelpCommand extends SystemCommand {
	public void execute() {
		QingkeConsole.println("------------- I want to be Ba commands -------------");
		QingkeConsole.println("= EXIT  - Exit the application");
		QingkeConsole.println("= HELP  - Print command usage");
		QingkeConsole.println("= LOGIN  - Login the appllication");
		QingkeConsole.println("= SIGNUP  - Sign up an player account");
		QingkeConsole.println("= LIST  - Ask a question");
		QingkeConsole.println("= ANSWER  - Answer a question");
		QingkeConsole.println("= ACCEPT  - set best answer for a question");
		QingkeConsole.println("= SCORE  - Show palyer's score");
	}
}
