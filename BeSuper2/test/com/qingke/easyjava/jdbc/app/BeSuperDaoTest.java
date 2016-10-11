package com.qingke.easyjava.jdbc.app;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qingke.easyjava.jdbcapp.pojo.Player;


public class BeSuperDaoTest {
    
    private static BeSuperDao dao;
    private static String username;
    private static String password;
    private static String nickname;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        dao = new BeSuperDao();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        
        username = "qingke1000";
        password = "123";
        nickname = "qingke1000";
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSignup() {
        //
        
        Player player = dao.signup(username, password, nickname);
        
        Assert.assertNull(player);
    }

}
