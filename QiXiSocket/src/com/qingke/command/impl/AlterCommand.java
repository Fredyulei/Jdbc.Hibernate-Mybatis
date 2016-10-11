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

		String listMode = Console.Input("ѡ����Ҫ���ĵ�����(updateUser/insertInterest/updateInterest)");
		if (!"updateUser / insertInterest / updateInterest".contains(listMode)) {
			Console.Input("������֧�ֵ�ģʽ");
			return;
		}

		if ("updateUser".equalsIgnoreCase(listMode)) {
			Console.println("ѡ����Ҫ�޸ĵ�����");
			String phone = Console.Input("����������ֻ���");
			String height = Console.Input("������������");
			String weight = Console.Input("�������������");
			test.updateUser(phone, height, weight);
			
		}else if ("insertInterest".equalsIgnoreCase(listMode)) {
			Console.println("�������֮ǰ����Ȥ�������");
			List<Interest> interests = test.findInterest();
			for (Interest interest : interests) {
				Console.println(interest);
			}
			String name = Console.Input("�����������Ȥ����");
			int level = Console.InputInt("�����������Ȥ�̶�");
			test.insertUserInterest(name,level);
			
		}else if ("updateInterest".equalsIgnoreCase(listMode)) {
			Console.println(test.findInterest());
			int index = Console.InputInt("��������Ҫ�޸ĵ���ȤIdֵ");
			String name = Console.Input("���޸�����Ҫ������Ȥ����");
			int level = Console.InputInt("�����������Ȥ�̶�");
			test.updateUserInterest(index,name,level);
		}
	}
}
