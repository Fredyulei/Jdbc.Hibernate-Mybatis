package com.qingke.command.impl;

import java.util.List;
import com.qingke.app.TestMyBatis;
import com.qingke.command.UserCommand;
import com.qingke.util.Console;
import test.domain.Interest;
import test.domain.Users;

public class AlterCommand extends UserCommand {

	public AlterCommand(Users user) {
		super(user);
	}

	@Override
	public void executPlayerCommand() {
		TestMyBatis test = new TestMyBatis(user);

		String listMode = Console.Input("选择你要更改的内容(updateUser/insertInterest/updateInterest)");
		if (!"updateUser / insertInterest / updateInterest".contains(listMode)) {
			Console.Input("请输入支持的模式");
			return;
		}

		if ("updateUser".equalsIgnoreCase(listMode)) {
			Console.println("选择你要修改的内容");
			String phone = Console.Input("请输入你的手机号");
			String height = Console.Input("请输入你的身高");
			String weight = Console.Input("请输入你的体重");
			test.updateUser(phone, height, weight);
			
		}else if ("insertInterest".equalsIgnoreCase(listMode)) {
			Console.println("请根据你之前的兴趣爱好添加");
			List<Interest> interests = test.findInterest();
			for (Interest interest : interests) {
				Console.println(interest);
			}
			String name = Console.Input("请输入你的兴趣爱好");
			int level = Console.InputInt("请输入你的兴趣程度");
			test.insertUserInterest(name,level);
			
		}else if ("updateInterest".equalsIgnoreCase(listMode)) {
			Console.println(test.findInterest());
			int index = Console.InputInt("请输入你要修改的兴趣Id值");
			String name = Console.Input("请修改你需要更改兴趣爱好");
			int level = Console.InputInt("请输入你的兴趣程度");
			test.updateUserInterest(index,name,level);
		}
	}
}
