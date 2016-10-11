package com.qingke.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.qingke.command.impl.AlterCommand;
import test.domain.Interest;
import test.domain.Invitation;
import test.domain.UserPassword;
import test.domain.Users;
import test.mapping.InterestMapper;
import test.mapping.InvitationMapper;
import test.mapping.UserPasswordMapper;
import test.mapping.UsersMapper;

public class TestMyBatis extends AlterCommand {

	public TestMyBatis(Users user) {
		super(user);
	}

	private SqlSessionFactory sqlSessionFactory;

	public void init() {
		String resource = "mybatis_conf.xml";
		InputStream stream;
		try {
			stream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 判断用户是否在数据库中
	public boolean isUsernameExit(String username) {
		init();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UsersMapper uMapper = sqlSession.getMapper(UsersMapper.class);
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", username);
		Users user = uMapper.selectByUsername(map);
		if (user != null) {
			return true;
		}
		return false;
	}

	// 登录系统
	public Users login(String username, String password) {
		init();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserPasswordMapper upMapper = sqlSession.getMapper(UserPasswordMapper.class);
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", username);
		map.put("password", password);
		Users user = upMapper.findUserPassword(map);
		return user;
	}

	// 用户注册
	public Users signup(String username, String password, String name, String age, String height, String weight,
			String gender, String phone) {
		init();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UsersMapper uMapper = sqlSession.getMapper(UsersMapper.class);
		UserPasswordMapper upMapper = sqlSession.getMapper(UserPasswordMapper.class);
		Users user = new Users();
		UserPassword userPassword = new UserPassword();
		user.setUsername(username);
		user.setName(name);
		user.setAge(age);
		user.setHeight(height);
		user.setGender(gender);
		user.setPhone(phone);
		uMapper.insertSelective(user);
		System.out.println(user.getId());
		userPassword.setUserId(user.getId());
		userPassword.setPassword(password);
		upMapper.insertSelective(userPassword);
		sqlSession.commit();
		return user;
	}

	// 修改用户手机号，身高， 体重
	public void updateUser(String phone, String height, String weight) {
		init();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UsersMapper uMapper = sqlSession.getMapper(UsersMapper.class);
		user.setPhone(phone);
		user.setHeight(height);
		user.setWeight(weight);
		uMapper.updateByPrimaryKeySelective(user);
		sqlSession.commit();
	}
	
	//查询兴趣爱好
	public List<Interest> findInterest() {
		init();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		InterestMapper iMapper = sqlSession.getMapper(InterestMapper.class);
		List<Interest> interests = iMapper.selectByUserId(user.getId());
		return interests;
	}

	// 给用户添加兴趣以及兴趣程度
	public void insertUserInterest(String name, Integer level) {
		init();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		InterestMapper iMapper = sqlSession.getMapper(InterestMapper.class);
		Interest interest = new Interest();
		interest.setName(name);
		interest.setLevel(level);
		interest.setUserId(user.getId());		
		iMapper.insertSelective(interest);
		sqlSession.commit();
		System.out.println(user.getName());
	}

	// 给用户修改兴趣以及兴趣程度
	public void updateUserInterest(int index, String name, Integer level) {
		init();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		InterestMapper iMapper = sqlSession.getMapper(InterestMapper.class);
		List<Interest> interests = iMapper.selectByUserId(user.getId());
		Interest interest = interests.get(index);
		interest.setName(name);
		interest.setLevel(level);		
		iMapper.updateByPrimaryKeySelective(interest);		
		sqlSession.commit();
	}
	//根据条件查找用户
	public List<Users> findConditionUser(Map<String, String> map) {
		init();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UsersMapper uMapper = sqlSession.getMapper(UsersMapper.class);
		List<Users> users = uMapper.selectConditionUser(map);
		return users;
	}

	//查找自己的邀请信息
	public List<Invitation> findByInviter() {
		init();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		InvitationMapper iMapper = sqlSession.getMapper(InvitationMapper.class);
		List<Invitation> invitation = iMapper.selectByInviterUserId(user.getId());
		return invitation;
	}
	
}
