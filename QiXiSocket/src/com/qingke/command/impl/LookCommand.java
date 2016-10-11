package com.qingke.command.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qingke.app.TestMyBatis;
import com.qingke.command.UserCommand;
import com.qingke.util.Console;

import test.domain.Invitation;
import test.domain.Users;

public class LookCommand extends UserCommand {

	public LookCommand(Users user) {
		super(user);
	}

	@Override
	public void executPlayerCommand() {
		TestMyBatis test = new TestMyBatis(user);

		String listMode = Console.Input("选择你要查看的内容(findUser/findInvitation)");
		if (!"findUser / findInvitation".contains(listMode)) {
			Console.Input("请输入支持的模式");
			return;
		}
		if ("findUser".equalsIgnoreCase(listMode)) {
			Map<String, String> map = new HashMap<String, String>();
			Console.println("请输入你要查询的内容");
			String maxAge = Console.Input("请输入最大的年龄范围,默认请输入#结束");
			String minAge = Console.Input("请输入最小的年龄范围,默认请输入#结束");
			String maxHeight = Console.Input("请输入最大的身高范围,默认请输入#结束");
			String minHeight = Console.Input("请输入最小的身高范围,默认请输入#结束");
			String maxWeight = Console.Input("请输入最大的体重范围,默认请输入#结束");
			String minWeight = Console.Input("请输入最大的体重范围,默认请输入#结束");
			String gender = Console.Input("请输入性别,默认请输入#结束");
			if (!"#".equals(maxAge)) {
				map.put("maxAge", maxAge);
			}
			if (!"#".equals(minAge) && Integer.valueOf(maxAge) > Integer.valueOf(minAge)) {
				map.put("minAge", minAge);
			}
			if (!"#".equals(maxHeight)) {
				map.put("maxHeight", maxHeight);
			}
			if (!"#".equals(minHeight) && Integer.valueOf(maxHeight) > Integer.valueOf(minHeight)) {
				map.put("minHeight", minHeight);
			}
			if (!"#".equals(maxWeight)) {
				map.put("maxWeight", maxWeight);
			}
			if (!"#".equals(minWeight) && Integer.valueOf(maxWeight) > Integer.valueOf(minWeight)) {
				map.put("minWeight", minWeight);
			}
			if (!"#".equals(gender)) {
				map.put("gender", gender);
			}
			List<Users> users = test.findConditionUser(map);
			for (Users user1 : users) {
				Console.println(user1);
			}
		}else if ("findInvitation".equalsIgnoreCase(listMode)) {
			List<Invitation> invitations = test.findByInviter();
			for (Invitation invitation : invitations) {
				Console.println(invitation);
			}
		}
	}
}
