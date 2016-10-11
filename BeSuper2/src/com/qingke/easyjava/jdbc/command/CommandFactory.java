package com.qingke.easyjava.jdbc.command;

import com.qingke.easyjava.jdbc.command.impl.ExitCommand;

public class CommandFactory {

    public Command buildCommand(String cmd) {
        if (cmd.equalsIgnoreCase("exit")) {
            return new ExitCommand();
        }
        
        return null;
    }
    

}
