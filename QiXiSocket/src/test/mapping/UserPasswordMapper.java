package test.mapping;

import java.util.Map;

import test.domain.UserPassword;
import test.domain.Users;

public interface UserPasswordMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserPassword record);

    int insertSelective(UserPassword record);

    UserPassword selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserPassword record);

    int updateByPrimaryKey(UserPassword record);

	Users findUserPassword(Map<String,String> map);
}