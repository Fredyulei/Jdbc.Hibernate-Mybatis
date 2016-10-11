package test.mapping;

import java.util.List;
import java.util.Map;

import test.domain.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
    
    Users selectByUsername(Map<String,String> map);
    
    Users selectUser();

	List<Users> selectConditionUser(Map<String, String> map);

}