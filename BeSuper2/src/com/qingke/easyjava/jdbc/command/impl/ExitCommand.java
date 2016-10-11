package com.qingke.easyjava.jdbc.command.impl;

import com.qingke.easyjava.jdbc.command.Command;
import com.qingke.easyjava.jdbcapp.util.QingkeConsole;

public class ExitCommand implements Command {

    @Override
    public void execute() {
    	 QingkeConsole.terminate();
    }
}
