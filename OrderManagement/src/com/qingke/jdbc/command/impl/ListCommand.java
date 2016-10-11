package com.qingke.jdbc.command.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qingke.jdbc.app.OrderManagementDao;
import com.qingke.jdbc.command.ClientCommand;
import com.qingke.jdbc.content.Client;
import com.qingke.jdbc.content.Order;
import com.qingke.jdbc.content.Production;
import com.qingke.jdbc.util.QingkeConsole;

public class ListCommand extends ClientCommand{
	
	SessionFactory sf = new Configuration().configure("xmlfolder/hibernate.xml").buildSessionFactory();
	Session session = sf.openSession();

	public ListCommand(Client client) {
		super(client);
	
	}

	@Override
	public void execute() {
	String listMode=QingkeConsole.askUserInput("��ѡ����Ҫ�������Ʒ(��������/�ճ��ٻ�/ʳ��/����)");
		OrderManagementDao dao=new OrderManagementDao(session);
		if(!"��������/�ճ��ٻ�/ʳ��/����".contains(listMode)){
			QingkeConsole.askUserInput("��ʹ��֧�ֵ�ģʽ");
			return;
		}
		List<Order>orders=new ArrayList<Order>();
		if("��������/�ճ��ٻ�/ʳ��/����".contains(listMode)){
			List<Order> tmpList = dao.getOrders();
			List<Production> products=dao.getproduction();
			for(Production p:products){
				System.out.println(p.getName()+":"+p.getDescription()+":"+p.getPrize()+p.getClient_id());
			}
			for (Order order : tmpList) {
				
					orders.add(order);
			QingkeConsole.println(order.getCreate_datetime());
			
			}
		}
	}

	@Override
	public void executeClientCommand() {
		// TODO Auto-generated method stub
		
	}

}
