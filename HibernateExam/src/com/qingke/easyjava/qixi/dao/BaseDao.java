package com.qingke.easyjava.qixi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

public abstract class BaseDao {

    protected Session session;

    protected BaseDao(Session session) {
        this.session = session;
    }

    public List<?> executeDetachedCriteria(DetachedCriteria criteria) {
        Criteria c = criteria.getExecutableCriteria(session);
        
        return c.list();
    }
}
