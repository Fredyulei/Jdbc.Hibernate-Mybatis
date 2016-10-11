package test.mapping;

import java.util.List;

import test.domain.Education;
import test.domain.Users;

public interface EducationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Education record);

    int insertSelective(Education record);

    Education selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Education record);

    int updateByPrimaryKey(Education record);
    
    List<Users> findUserEducation(String name);
}