
package com.qingke.jdbc.app;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.qingke.jdbc.content.Client;
import com.qingke.jdbc.content.Order;
import com.qingke.jdbc.content.Production;

public class OrderManagementDao {
	private Session session;

	public OrderManagementDao(Session session) {
		this.session = session;
	}

	public double getBalanceByClient(Client client) {
		Query<Client> c=session.createQuery("from Client where client like:balance ",Client.class);
		
		c.setParameter("balance", client);
		try {
			System.out.println(c.getSingleResult());
		     c.getSingleResult();
			// production.getPrize();
		} catch (Exception e) {
			System.out.println("-------------");
		}
		return 0;
		
	}



	public Production getdescription(long ids) {
		String sql = "SELECT id,description FROM production where id=? ";

		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		Production product = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setLong(1, ids);
			rs = statement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String des = rs.getString("description");
				product = new Production(id, des);

			}
			return product;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cleanup(conn, statement, rs);
		}

		return product;

	}

	public Production getProductByName(String description) {
		System.out.println("------2-------");
		
		
		Query<Production> q = session.createQuery("from Production where description like :descrip", Production.class);
		System.out.println("------2-------");
		q.setParameter("descrip", description);
		try {
			System.out.println(q.getSingleResult());
			return q.getSingleResult();
			// production.getPrize();
		} catch (Exception e) {
			System.out.println("-------------");
		}
		return null;
	}

	

	private Client getClient(long clientId) {
		String sql = "SELECT id, name,phone FROM client WHERE id = ?";

		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		Client client = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);

			statement.setLong(1, clientId);

			rs = statement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String name = rs.getString("name");
				// Double balance = rs.getDouble("balance");
				// String location = rs.getString("location");
				// String phone = rs.getString("phone");

				client = new Client();
			}
			return client;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cleanup(conn, statement, rs);
		}

		return client;

	}

	public List<Order> getOrdersFrom(Client client) {
		List<Order> orders = new ArrayList<Order>();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		String sql = "SELECT id ,create_datetime,order_status_id,client_id FROM order ";
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setLong(1, client.getId());
			rs = statement.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				String cd = rs.getString("create_datetime");
				long osi = rs.getLong("order_status_id");
				long clientId = rs.getLong("client_id");
				Client clients = this.getClient(clientId);

				Order order = new Order(id, cd, osi, client);
				List<Production> products = this.getProductionsFrom(clients);
				order.setProductions(products);
				orders.add(order);
			}
			return orders;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cleanup(conn, statement, rs);
		}
		return orders;

	}

	public List<Order> getOrders() {
		Query<Order> query = session.createQuery("from Order", Order.class);
		return query.getResultList();


	}

	public List<Production> getProductionsFrom(Client client) {
		List<Production> products = new ArrayList<Production>();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		String sql = "SELECT id, name,price, order_id FROM production where client_id = ?";
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);

			statement.setLong(1, client.getId());

			rs = statement.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				String name = rs.getString("name");
				Double prize = rs.getDouble("prize");

				long orderId = rs.getLong("order_id");
				String des = rs.getString("description");
				Production product = new Production(id, name, prize, des);

				products.add(product);
			}

			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cleanup(conn, statement, rs);
		}
		return products;
	}

	public List<Production> getProductionsFrom(Order order) {
		List<Production> products = new ArrayList<Production>();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		String sql = "SELECT id, name, prize, client_id,description FROM production ";
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);

			// statement.setLong(1, Order.getId());

			rs = statement.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				String name = rs.getString("name");
				Double prize = rs.getDouble("prize");
				String des = rs.getString("description");

				// Client client = this.getClient(clientId);
				Production product = new Production(id, name, prize, des);

				products.add(product);
			}

			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cleanup(conn, statement, rs);
		}
		return products;
	}

	private Production getProductions(long productId) {

		String sql = "SELECT id, name, prize, client_id FROM product WHERE id = ?";

		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		Production product = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);

			statement.setLong(1, productId);

			rs = statement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String name = rs.getString("name");
				Double prize = rs.getDouble("prize");
				long clientId = rs.getLong("client_id");
				String des = rs.getString("description");
				Client client = this.getClient(clientId);

				product = new Production(id, name, prize, des);
				List<Order> orders = this.getOrdersFrom(client);
				// product.setorders(orders);
			}
			return product;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cleanup(conn, statement, rs);
		}

		return product;
	}

	public boolean isProductExit(String description) {
		Query<Production> q=session.createQuery("from Production where description like:description",Production.class);
		q.setParameter("description",description);
		try{
		Production product=q.getSingleResult();
		    
		}catch(Exception e){
			return false;
		}
		return true;


	}

	public List<Client> getclient() {
		Query<Client> query = session.createQuery("from Client", Client.class);
		return query.getResultList();

		
	}

	public List<Production> getproduction() {
		Query<Production> p=session.createQuery("from Production",Production.class);
		return p.getResultList();

	}

	public Order getorder(long orderId) {
		Order order = null;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		String sql = "SELECT id ,create_datetime,order_status_id,client_id FROM order ";
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				String cd = rs.getString("create_datetime");
				long osi = rs.getLong("order_status_id");
				long clientId = rs.getLong("client_id");
				Client client = this.getClient(clientId);
				Order orders = new Order(id, cd, osi, client);
				List<Production> products = this.getProductionsFrom(orders);
				order.setProductions(products);

			}
			return order;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cleanup(conn, statement, rs);
		}

		return order;

	}

	
		
	public Client signup(String username, String password, String name, String gender, String location, String phone) {
		Transaction tc = session.beginTransaction();
		Client client = new Client();
		client.setUsername(username);
		client.setPassword(password);
		client.setName(name);
		client.setGender(gender);
		client.setLocation(location);
		client.setPhone(phone);
		session.save(client);
		tc.commit();		
		return client;

	}

	public Client login(String username, String password) {
		Query<Client> q=session.createQuery("from Client where username like£ºusename and password like:password",Client.class);
		q.setParameter(0, username);
		q.setParameter(1, password);
		try{
			return q.getSingleResult();
		}catch(Exception e){
			return null;
		}
		

	}

	public boolean isUsernameExists(String username, Session session) {

		Query<Client> a = session.createQuery("from Client where username like:username", Client.class);
		a.setParameter("username", username);
		try {
			Client client = a.getSingleResult();
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	private Double getaccountbalance(String name){
		Query<Client> query=session.createQuery("from Client",Client.class);
		List<Client> c=query.getResultList();
		for(Client a :c){
		return	a.getBalance();
		}
		return null;
	}
	private Connection getConnection() throws SQLException {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/order_management_system?useSSL=false";
		String username = "root";
		String password = "150102";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}

	private void cleanup(Connection conn, Statement statement, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
