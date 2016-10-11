package com.qingke.easyjava.qixi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.qingke.easyjava.qixi.bean.Constants;
import com.qingke.easyjava.qixi.bean.Education;
import com.qingke.easyjava.qixi.bean.Interest;
import com.qingke.easyjava.qixi.bean.Invitation;
import com.qingke.easyjava.qixi.bean.User;
import com.qingke.easyjava.qixi.dao.InvitationDao;
import com.qingke.easyjava.qixi.dao.UserDao;

public class QixiService {
    
    private Session session = null;
    
    private UserDao userDao;
    private InvitationDao invitationDao;
    
    public QixiService() {
        try {
            SessionFactory sf =
                new Configuration().configure().buildSessionFactory();

            session = sf.openSession();
            
            userDao = new UserDao(session);
            invitationDao = new InvitationDao(session);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    
    public User login(String username, String password) {
        Map<String, String> criteria = new HashMap<>();
        criteria.put("username", username);
        List<User> users = userDao.getUsersByCriteria(criteria);
        
        if (users == null || users.size() != 1) {
            return null;
        }
        
        User user = users.get(0);
        String rightPsw = user.getPassword().getValue();
        if (password.equals(rightPsw)) {
            return user;
        }
        
        return null;
    }

    public User createUser(User user) {
        userDao.createUser(user);
        
        return user;
    }
    
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
    
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    
    public Invitation createInvitation(Invitation invitation) {
        invitationDao.createInvitation(invitation);
        return invitation;
    }
    
    public void updateInvitation(Invitation invitation) {
        invitationDao.updateInvitation(invitation);
    }
    
    public void deleteInvitation(Invitation invitation) {
        invitationDao.deleteInvitation(invitation);
    }
    
    public List<User> getUserByUniversity(String universityName) {
        // TODO: get the users for the given university name
        DetachedCriteria dc = DetachedCriteria.forClass(Education.class);
        dc.add(Restrictions.eq("school", universityName));
        
        List<?> list = userDao.executeDetachedCriteria(dc);
        List<User> users = new ArrayList<User>();
        for (Object obj : list) {
            if (obj instanceof Education) {
                Education ed = (Education)obj;
                
                User user = ed.getUser();
                
                if (!users.contains(user)) {
                    users.add(user);
                }
            }
        }
        
        return users;
    }
    
    public List<User> getMaleUserByAge() {
        DetachedCriteria dc = DetachedCriteria.forClass(User.class);
        dc.add(Restrictions.between("age", 15, 30));
        dc.add(Restrictions.eq("gender", "M"));
        
        List<User> result = (List<User>) userDao.executeDetachedCriteria(dc);
        return result;
    }
    
    public List<User> getUserByHeight() {
        // TODO: get the female users who's height is between 165 and 175
        DetachedCriteria dc = DetachedCriteria.forClass(User.class);
        
        dc.add(Restrictions.eq("gender", "F"));
        dc.add(Restrictions.between("height", 165, 175));
        
        List<User> result = (List<User>)userDao.executeDetachedCriteria(dc);
        
        return result;
    }
    
    public List<User> getUserByIntrest() {
        // TODO: get the users who have any interest is over 8 degree, print user and interest info

        DetachedCriteria dc = DetachedCriteria.forClass(Interest.class);
        dc.add(Restrictions.ge("level", 8));
        
        List<?> results = userDao.executeDetachedCriteria(dc);
        List<User> users = new ArrayList<>();
        for (Object obj : results) {
            if (obj instanceof Interest) {
                Interest i = (Interest)obj;
                
                User user = i.getUser();
                if (!users.contains(user)) {
                    users.add(user);
                }
            }
        }
        
        return users;
    }
    
    public List<String> getInfoOfUsers() {
        List<String> outputs = new ArrayList<>();
        // TODO: list out the invitation info in String format, sorting the result by date time
        DetachedCriteria dc = DetachedCriteria.forClass(User.class);
        
        List<?> users = userDao.executeDetachedCriteria(dc);
        for (Object obj : users) {
            if (obj instanceof User) {
                User i = (User)obj;
                outputs.add(i.toString());
            }
        }
        
        return outputs;
    }
    
    public List<User> getNonItFemale(String universityName) {
        // TODO: get the female users who are not the IT major in given university

        DetachedCriteria dc = DetachedCriteria.forClass(Education.class);
        dc.add(Restrictions.eq("school", universityName));
        dc.add(Restrictions.ne("major", "IT"));
        
        dc = dc.createCriteria("user");
        dc.add(Restrictions.eq("gender", "F"));
        
        List<?> results = userDao.executeDetachedCriteria(dc);
        List<User> users = new ArrayList<>();
        
        for (Object obj : results) {
            if (obj instanceof Education) {
                Education e = (Education)obj;
                
                User user = e.getUser();
                
                if (!users.contains(user)) {
                    users.add(user);
                }
            }
        }
        
        return users;
    }
    
    public User getMostPopularMale() {
        // TODO: get the male user who has received the most invitations

        DetachedCriteria dc = DetachedCriteria.forClass(Invitation.class);
        
        ProjectionList projList = Projections.projectionList();
        projList.add(Projections.countDistinct("id").as("count"));
        projList.add(Projections.groupProperty("invitee"));
        
        dc.setProjection(projList);
        dc = dc.createCriteria("invitee");
        dc.add(Restrictions.eq("gender", Constants.GENDER_MALE));
        dc.addOrder(Order.desc("count"));
        
        List<?> results = invitationDao.executeDetachedCriteria(dc);
        User user = null;
        if (results.size() > 0) {
            Object[] objs = (Object[])results.get(0);
            
            String count = objs[0].toString();
            user = (User)objs[1];
        }
        
        return user;
    }
    
    public User getMostPopularFemale() {

        DetachedCriteria dc = DetachedCriteria.forClass(Invitation.class);
        
        ProjectionList projList = Projections.projectionList();
        projList.add(Projections.countDistinct("id").as("count"));
        projList.add(Projections.groupProperty("invitee"));
        
        dc.setProjection(projList);
        dc = dc.createCriteria("invitee");
        dc.add(Restrictions.eq("gender", Constants.GENDER_FEMALE));
        dc.addOrder(Order.desc("count"));
        
        List<?> results = invitationDao.executeDetachedCriteria(dc);
        User user = null;
        if (results.size() > 0) {
            Object[] objs = (Object[])results.get(0);
            
            String count = objs[0].toString();
            user = (User)objs[1];
        }
        
        return user;
    }
    
    public List<String> getInfoOfInvitation() {
        List<String> outputs = new ArrayList<>();
        // TODO: list out the invitation info in String format, sorting the result by date time
        DetachedCriteria dc = DetachedCriteria.forClass(Invitation.class);
        
        List<?> invitations = invitationDao.executeDetachedCriteria(dc);
        for (Object obj : invitations) {
            if (obj instanceof Invitation) {
                Invitation i = (Invitation)obj;
                outputs.add(i.toString());
            }
        }
        
        return outputs;
    }
    
    public List<User> listMaleUsersOrderByInvitation() {
        // TODO: get male user list and sort by invitations
        
        DetachedCriteria dc = DetachedCriteria.forClass(Invitation.class);
        
        ProjectionList projList = Projections.projectionList();
        projList.add(Projections.countDistinct("id").as("count"));
        projList.add(Projections.groupProperty("invitee"));
        
        dc.setProjection(projList);
        dc.addOrder(Order.desc("count"));
        
        dc = dc.createCriteria("invitee");
        dc.add(Restrictions.eq("gender", Constants.GENDER_MALE));
        
        List<?> results = userDao.executeDetachedCriteria(dc);
        List<User> users = new ArrayList<>();
        for (Object obj : results) {
            Object[] objArray = (Object[])obj;
            
            User user = (User)objArray[1];
            users.add(user);
        }
        return users;
    }
    
    public List<User> listFemaleUsersOrderByInvitation() {
        DetachedCriteria dc = DetachedCriteria.forClass(Invitation.class);
        
        ProjectionList projList = Projections.projectionList();
        projList.add(Projections.countDistinct("id").as("count"));
        projList.add(Projections.groupProperty("invitee"));
        
        dc.setProjection(projList);
        dc.addOrder(Order.desc("count"));
        
        dc = dc.createCriteria("invitee");
        dc.add(Restrictions.eq("gender", Constants.GENDER_FEMALE));
        
        List<?> results = userDao.executeDetachedCriteria(dc);
        List<User> users = new ArrayList<>();
        for (Object obj : results) {
            Object[] objArray = (Object[])obj;
            
            User user = (User)objArray[1];
            users.add(user);
        }
        return users;
    }

    public void shutdown() {
        if (session != null) {
            session.close();
        }
    }
}
