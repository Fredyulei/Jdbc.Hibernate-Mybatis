package com.qingke.easy.jdbc.app;

import com.qingke.easy.Player;
import com.qingke.easy.jdbc.command.Command;
import com.qingke.easy.jdbc.command.CommandFactory;
import com.qingke.easy.jdbc.command.CommandFactory.CommandCode;
import com.qingke.easy.jdbc.command.impl.HelpCommand;
import com.qingke.easy.jdbc.command.impl.LoginCommand;
import com.qingke.easy.jdbc.command.impl.SignCommand;
import com.qingke.jdbcapp.util.QingkeConsole;

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

	private static Player playerProfile;

	public static void main(String[] args) {
		// start
		QingkeConsole.println("You can use the \"HELP\" for command usage. Have fun!");
		while (true) {
			String cmd = QingkeConsole.askUserInput("cmd");
			CommandCode cmdCode = null;
			try {
				cmdCode = CommandCode.valueOf(cmd.toUpperCase());
			} catch (Exception e) {
				QingkeConsole.println("你输入了一个不合法的命令,请使用  Help 查看帮助");
				continue;
			}
			CommandFactory cFactory = CommandFactory.getFactory(BeSuperApplication.getPlayerProfile());
			// System.out.println(cFactory);
			Command command = cFactory.buildCommand(cmdCode);
			// System.out.println(command);
			command.execute();
		}
	}
	private static void execute() {
	}
	public static Player getPlayerProfile() {
		return playerProfile;
	}

	public void setPlayerProfile(Player player) {
		this.playerProfile = player;
	}

}
