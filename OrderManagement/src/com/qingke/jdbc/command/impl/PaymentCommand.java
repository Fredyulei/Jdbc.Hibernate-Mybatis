package com.qingke.jdbc.command.impl;

import java.util.Scanner;

import org.hibernate.Session;

import com.qingke.jdbc.app.OrderManagementDao;
import com.qingke.jdbc.command.ClientCommand;
import com.qingke.jdbc.content.Client;
import com.qingke.jdbc.content.Production;
import com.qingke.jdbc.util.QingkeConsole;

public class PaymentCommand extends ClientCommand {

	private Client client;

	public PaymentCommand(Client client) {
		this.client = client;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

		OrderManagementDao dao = new OrderManagementDao(session);
		Scanner s = new Scanner(System.in);

		Production p = null;
		QingkeConsole.println("������֧����ʽ��");
		String sr = s.nextLine();
		if (sr.equals("֧����")) {
			QingkeConsole.println("ʹ��֧����֧��");
		} else {
			QingkeConsole.println("ʹ��������ʽ֧��");
		}
		QingkeConsole.println("������Ҫ�������Ʒ��");
		String r = s.nextLine();
		System.out.println(r);

		System.out.println("+++++++++++");

		p = dao.getProductByName(r);

		System.out.println(p.getPrize());
		System.out.println("================");
		if (dao.isProductExit(r)) {
			System.out.println("---------------");
			double balance = client.getBalance();
			double a = balance - p.getPrize();
			if (a > 0) {
				QingkeConsole.println("֧���ɹ������У�" + a);
			} else {
				QingkeConsole.println("���㣬��֧��");
				QingkeConsole.println("��������ȷ��Ʒ����");
			}
		}
	}

	@Override
	public void executeClientCommand() {
		// TODO Auto-generated method stub
	}

}
