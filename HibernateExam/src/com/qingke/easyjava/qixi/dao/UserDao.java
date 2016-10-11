package com.qingke.easyjava.qixi.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.qingke.easyjava.qixi.bean.User;

public class UserDao extends BaseDao {

    public UserDao(Session session) {
        super(session);
    }
    
    public User getUserById(int id) {
       
        return session.get(User.class, id);
    }

    public List<User> getUsersByCriteria(Map<String, String> criteria) {
        // Criteria map is an key-value mapping of property name to property value
        // The key of the map is a property name
        // The value of the map is a property value
        // TODO: complete the criteria search logic
        
        DetachedCriteria dc = DetachedCriteria.forClass(User.class);
        dc.add(Restrictions.allEq(criteria));
        
        Criteria c = dc.getExecutableCriteria(session);
        
        return c.list();
    }
    
    public void createUser(User user) {
        // TODO: add the create logic
        Transaction tx = session.beginTransaction();
        session.save(user);
        session.flush();
        tx.commit();
    }
    
    public void updateUser(User user) {
        Transaction tx = session.beginTransaction();
        session.update(user);
        session.flush();
        tx.commit();
    }
    
    public User deleteUser(User user) {
        Transaction tx = session.beginTransaction();
        session.delete(user);
        session.flush();
        session.clear();
        tx.commit();
        return user;
    }
}
