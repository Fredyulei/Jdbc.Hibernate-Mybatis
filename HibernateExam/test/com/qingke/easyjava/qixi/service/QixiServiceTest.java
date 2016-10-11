package com.qingke.easyjava.qixi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qingke.easyjava.qixi.bean.Constants;
import com.qingke.easyjava.qixi.bean.Invitation;
import com.qingke.easyjava.qixi.bean.User;

public class QixiServiceTest {
    
    private static QixiService qixiService;
    private List<User> users;
    private List<Invitation> invitations;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // setup resource before class if needed
        qixiService = new QixiService();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        // clean resource after class if needed
        qixiService.shutdown();
    }

    @Before
    public void setUp() throws Exception {
        // setup resource before test if needed
        users = new ArrayList<>();
        for (int i = 0 ; i < 50; i++) {
            User user = TestHelper.createTestUser();
            user = qixiService.createUser(user);
            users.add(user);
        }
        
        invitations = new ArrayList<>();
        for (int i = 0 ; i < 20; i++) {
            Invitation invitation = TestHelper.createTestInvitation();
            invitation = qixiService.createInvitation(invitation);
            invitations.add(invitation);
        }
    }

    @After
    public void tearDown() throws Exception {
        // clean resource after class if needed
        
        for (User user : users) {
            qixiService.deleteUser(user);
        }
        
        for (Invitation i : invitations) {
            qixiService.deleteInvitation(i);
        }
    }

    @Test
    public void testCreateUser() {
 
        User user = TestHelper.createTestUser();
        user = qixiService.createUser(user);
        
        Assert.assertTrue(user.getId() > 0);
    }

    @Test
    public void testDeleteUser() {
        User user = TestHelper.createTestUser();
        user = qixiService.createUser(user);
        
        qixiService.deleteUser(user);
    }

    @Test
    public void testUpdateUser() {
        User user = TestHelper.createTestUser();

        qixiService.createUser(user);

        String username = user.getUsername();
        String name = user.getName();
        user.setName("updated_" + name);
        user.setUsername("updated_" + username);

        qixiService.updateUser(user);
    }

    @Test
    public void testGetZjutUser() {
        List<User> users = qixiService.getUserByUniversity(Constants.SCHOOL_ZJUT);
        Assert.assertNotNull(users);
    }

    @Test
    public void testGetMaleUserByAge() {
        List<User> users = qixiService.getMaleUserByAge();
        Assert.assertNotNull(users);
    }

    @Test
    public void testGetUserByHeight() {
        List<User> users = qixiService.getUserByHeight();
        Assert.assertNotNull(users);

    }

    @Test
    public void testGetUserByIntrest() {
        List<User> users = qixiService.getUserByIntrest();
        Assert.assertNotNull(users);
    }

    @Test
    public void testGetInfoOfUsers() {
        List<String> infos = qixiService.getInfoOfUsers();
        Assert.assertNotNull(infos);
    }

    @Test
    public void testGetNonItFemale() {
        List<User> users = qixiService.getNonItFemale(Constants.SCHOOL_ZJU);
        Assert.assertNotNull(users);
    }

    @Test
    public void testGetMostPopularMale() {
        User user = qixiService.getMostPopularMale();
        System.out.println(user);
        
        Assert.assertNotNull(user);
    }

    @Test
    public void testGetMostPopularFemale() {
        User user = qixiService.getMostPopularMale();
        System.out.println(user);
        
        Assert.assertNotNull(user);
    }

    @Test
    public void testCreateInvitation() {
        Invitation invitation = TestHelper.createTestInvitation();
        invitation = qixiService.createInvitation(invitation);
        Assert.assertNotNull(invitation);
    }

    @Test
    public void testUpdateInvitation() {
        Invitation invitation = TestHelper.createTestInvitation();
        invitation = qixiService.createInvitation(invitation);
        
        Date date = new Date();
        invitation.setDate(new Date());
        qixiService.updateInvitation(invitation);

        Assert.assertEquals(date, invitation.getDate());
    }

    @Test
    public void testDeleteInvitation() {
        Invitation invitation = TestHelper.createTestInvitation();
        invitation = qixiService.createInvitation(invitation);

        int id = invitation.getId();
        System.out.println("Created invitation with id: " + id);
        qixiService.deleteInvitation(invitation);

    }

    @Test
    public void testGetInfoOfInvitation() {
        List<String> infos = qixiService.getInfoOfUsers();
        Assert.assertNotNull(infos);
    }

    @Test
    public void testListMaleUsersOrderByInvitation() {
        List<User> users = qixiService.listMaleUsersOrderByInvitation();

        Assert.assertNotNull(users);
    }

    @Test
    public void testListFemaleUsersOrderByInvitation() {
        List<User> users = qixiService.listFemaleUsersOrderByInvitation();
        Assert.assertNotNull(users);
    }
}
