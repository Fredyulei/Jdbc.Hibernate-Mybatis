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
		QingkeConsole.println("请输入支付方式：");
		String sr = s.nextLine();
		if (sr.equals("支付宝")) {
			QingkeConsole.println("使用支付宝支付");
		} else {
			QingkeConsole.println("使用其他方式支付");
		}
		QingkeConsole.println("请输入要购买的商品：");
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
				QingkeConsole.println("支付成功，余额还有：" + a);
			} else {
				QingkeConsole.println("余额不足，待支付");
				QingkeConsole.println("请输入正确商品名字");
			}
		}
	}

	@Override
	public void executeClientCommand() {
		// TODO Auto-generated method stub
	}

}
