package com.qingke.jdbc.command.impl;

import com.qingke.jdbc.command.SystemCommand;
import com.qingke.jdbc.util.QingkeConsole;

public class HelpCommand extends SystemCommand{
public void execute(){
	QingkeConsole.println("------------- I want to be Ba commands -------------");
	QingkeConsole.println("= EXIT  - Exit the application");
	QingkeConsole.println("= HELP  - Print command usage");
	QingkeConsole.println("= LOGIN  - Login the appllication");
	QingkeConsole.println("= SIGNUP  - Sign up an client account");
	QingkeConsole.println("= LIST  -select production");
	QingkeConsole.println("= PAYMENT -select PAYMENT");
	
}
}
