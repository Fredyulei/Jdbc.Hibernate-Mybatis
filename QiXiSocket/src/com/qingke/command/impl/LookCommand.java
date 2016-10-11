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

		String listMode = Console.Input("ѡ����Ҫ�鿴������(findUser/findInvitation)");
		if (!"findUser / findInvitation".contains(listMode)) {
			Console.Input("������֧�ֵ�ģʽ");
			return;
		}
		if ("findUser".equalsIgnoreCase(listMode)) {
			Map<String, String> map = new HashMap<String, String>();
			Console.println("��������Ҫ��ѯ������");
			String maxAge = Console.Input("�������������䷶Χ,Ĭ��������#����");
			String minAge = Console.Input("��������С�����䷶Χ,Ĭ��������#����");
			String maxHeight = Console.Input("������������߷�Χ,Ĭ��������#����");
			String minHeight = Console.Input("��������С����߷�Χ,Ĭ��������#����");
			String maxWeight = Console.Input("�������������ط�Χ,Ĭ��������#����");
			String minWeight = Console.Input("�������������ط�Χ,Ĭ��������#����");
			String gender = Console.Input("�������Ա�,Ĭ��������#����");
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
