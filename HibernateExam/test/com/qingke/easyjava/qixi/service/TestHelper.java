package com.qingke.easyjava.qixi.service;

import java.util.Date;

import com.qingke.easyjava.qixi.bean.Constants;
import com.qingke.easyjava.qixi.bean.Education;
import com.qingke.easyjava.qixi.bean.Interest;
import com.qingke.easyjava.qixi.bean.Invitation;
import com.qingke.easyjava.qixi.bean.User;
import com.qingke.easyjava.qixi.bean.UserPassword;

public class TestHelper {

    public static User createTestUser(){
        User user = new User();
        user.setAge(getRandomInt(10, 50));
        user.setGender(getRandomItem(Constants.GENDERS));
        user.setHeight(getRandomInt(145, 198));
        user.setName(getRandomName());
        user.setUsername(getRandomName());
        user.setPassword(new UserPassword());
        user.getPassword().setValue(String.valueOf(getRandomName()));
        user.getPassword().setUser(user);
        user.setPhone(String.valueOf(getRandomLong(13000000000l, 13900000000l)));
        
        Interest i = new Interest();
        i.setLevel(getRandomInt(5, 10));
        i.setName(getRandomItem(Constants.INTERESTS));
        i.setUser(user);
        
        user.getInterests().add(i);
        
        Education e = new Education();
        e.setSchool(getRandomItem(Constants.SCHOOLS));
        e.setMajor(getRandomItem(Constants.MAJORS));
        e.setDegree(getRandomItem(Constants.DEGREES));
        e.setUser(user);
        user.getEducations().add(e);
        
        return user;
    }
    
    public static Invitation createTestInvitation(){
        Invitation invitation = new Invitation();
        
        User inviter = createTestUser();
        User invitee = createTestUser();

        invitation.setDate(getRandomDate(new Date()));
        invitation.setInviter(inviter);
        invitation.setInvitee(invitee);
        invitation.setIsAccepted(getRandomItem(Constants.BOOLEANS));
        
        inviter.getMyInvitations().add(invitation);
        invitee.getReceivedInvitations().add(invitation);
        
        return invitation;
    }

    public static String getRandomName(){
        String character = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        int length = (int)(Math.random() * 10) + 5;
        StringBuilder sb = new StringBuilder();
        while (length-- > 0) {
            int index = (int)(Math.random() * character.length());
            char c = character.charAt(index);
            sb.append(c);
        }

        return sb.toString();
    }

    public static String getRandomGender(){
        return getRandomItem(Constants.GENDERS);
    }

    public static int getRandomInt(int min, int max) {
        if (max < min) {
            max = Integer.MAX_VALUE;
        }
        return (int)(Math.random() * (max - min)) + min;
    }
    
    public static long getRandomLong(long min, long max) {
        if (max < min) {
            max = Integer.MAX_VALUE;
        }
        return (long)(Math.random() * (max - min)) + min;
    }
    
    public static String getRandomItem(String[] items) {
        int index = (int)(Math.random() * items.length);
        
        return items[index];
    }
    
    public static Date getRandomDate(Date since) {
        long l = getRandomLong(100000l, 100000000l);
        Date date = new Date(since.getTime() + l);

        return date;
    }
}
