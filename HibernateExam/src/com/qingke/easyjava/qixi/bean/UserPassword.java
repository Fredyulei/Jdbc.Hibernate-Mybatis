package com.qingke.easyjava.qixi.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "user_password")
public class UserPassword {

    @Id
    @GenericGenerator(name="pkGenerator",strategy="foreign",parameters={@Parameter(name="property",value="user")})
    @GeneratedValue(generator="pkGenerator")
    @Column(name = "user_id")
    private int id;

    @Column(name = "password")
    private String value;

    @OneToOne(mappedBy = "password", cascade = CascadeType.ALL)
    private User user;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
