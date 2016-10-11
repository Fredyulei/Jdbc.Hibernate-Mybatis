package com.qingke.easyjava.qixi.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "height")
    private int height;

    @Column(name = "phone")
    private String phone;
    
    @OneToMany(mappedBy = "inviter", fetch = FetchType.LAZY)
    private List<Invitation> myInvitations = new ArrayList<>();

    @OneToMany(mappedBy = "invitee", fetch = FetchType.LAZY)
    private List<Invitation> receivedInvitations = new ArrayList<>();
    
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Interest> interests = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Education> educations = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserPassword password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Invitation> getMyInvitations() {
        return myInvitations;
    }

    public void setMyInvitations(List<Invitation> myInvitations) {
        this.myInvitations = myInvitations;
    }

    public List<Invitation> getReceivedInvitations() {
        return receivedInvitations;
    }

    public void setReceivedInvitations(List<Invitation> receivedInvitations) {
        this.receivedInvitations = receivedInvitations;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public UserPassword getPassword() {
        return password;
    }

    public void setPassword(UserPassword password) {
        this.password = password;
    }

    public static void main(String[] args) {
        SessionFactory sf =
                new Configuration().configure().buildSessionFactory();
        
        Session session = sf.openSession();
        
        User user = session.get(User.class, 1);
        System.out.println(user);
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if (obj instanceof User) {
            User user2 = (User)obj;
            
            return id == user2.getId();
        }
       
        return false;
    }
}
