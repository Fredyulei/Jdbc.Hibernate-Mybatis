package com.qingke.command;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.qingke.command.impl.AlterCommand;
import com.qingke.command.impl.LookCommand;

import test.domain.Users;

public class UserCommandFactory extends SystemCommandFactory {
		
		private Users user;
		
		public UserCommandFactory(Users user) {
			this.setUser(user);
			System.out.println(user);
		}
		
		private static Map<CommandCode, Class<? extends Command>> commandMap = new HashMap<>();
		
		static {
			commandMap.put(CommandCode.ALTER, AlterCommand.class);
			commandMap.put(CommandCode.LOOK, LookCommand.class);
		}

		@Override
		public Command buildCommand(CommandCode cmd) {
			Class<? extends Command> comm = commandMap.get(cmd);
			Command command = null;
			if (comm != null) {
				try {
					command = comm.getConstructor(Users.class).newInstance(user);
				} catch (InstantiationException | IllegalAccessException
						| IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
			}
			
			if (comm == null) {
				command = super.buildCommand(cmd);
			}
			return command;
		}

		public Users getUser() {
			return user;
		}

		public void setUser(Users user) {
			this.user = user;
		}

	}
