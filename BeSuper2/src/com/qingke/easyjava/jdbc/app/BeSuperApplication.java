package com.qingke.easyjava.jdbc.app;

import com.qingke.easyjava.jdbc.command.Command;
import com.qingke.easyjava.jdbc.command.CommandFactory;
import com.qingke.easyjava.jdbcapp.pojo.Player;
import com.qingke.easyjava.jdbcapp.util.QingkeConsole;

public class BeSuperApplication {
    
    // singleton
    private static BeSuperApplication instance = null;

    private BeSuperApplication() {
    }

    public static synchronized BeSuperApplication getInstance() {

        if (instance == null) {
            instance = new BeSuperApplication();
        }

        return instance;
    }

    private Player playerProfile;

    public static void main(String[] args) {

        // start
        QingkeConsole.println("You can use the \"HELP\" for command usage. Have fun!");

        while (true) {
            String cmd = QingkeConsole.askUserInput("cmd");
            CommandFactory factory = new CommandFactory();
            
            Command command = factory.buildCommand(cmd);
            command.execute();
        }
    }

    public Player getPlayerProfile() {
        
        return playerProfile;
    }

    public void setPlayerProfile(Player player) {
        this.playerProfile = player;
    }
}
