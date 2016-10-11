package com.qingke.easyjava.qixi.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.qingke.easyjava.qixi.bean.Invitation;

public class InvitationDao extends BaseDao {

    public InvitationDao(Session session) {
        super(session);
    }

    public void createInvitation(Invitation invitation) {
        Transaction tx = session.beginTransaction();
        session.save(invitation);
        session.flush();
        tx.commit();
    }
    
    public void updateInvitation(Invitation invitation) {

        Transaction tx = session.beginTransaction();
        session.update(invitation);
        session.flush();
        tx.commit();
    }
    
    public Invitation getInvitationById(int id) {
        return session.get(Invitation.class, id);
    }
    
    public List<Invitation> getInvitations(Map<String, String> criteria) {
        // Criteria map is an key-value mapping of property name to property value
        // The key of the map is a property name
        // The value of the map is a property value
        // TODO: complete the criteria search logic
        
        DetachedCriteria dc = DetachedCriteria.forClass(Invitation.class);
        dc.add(Restrictions.allEq(criteria));

        Criteria c = dc.getExecutableCriteria(session);
        return c.list();
    }

    public Invitation deleteInvitation(Invitation invitation) {

        Transaction tx = session.beginTransaction();
        session.delete(invitation);
        session.flush();
        tx.commit();
        return invitation;
    }
}
