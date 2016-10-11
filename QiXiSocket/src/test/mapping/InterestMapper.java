package test.mapping;

import java.util.List;

import test.domain.Interest;

public interface InterestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Interest record);

    int insertSelective(Interest record);

    Interest selectByPrimaryKey(Integer id);
    
    List<Interest> selectByUserId(Integer id);

    int updateByPrimaryKeySelective(Interest record);

    int updateByPrimaryKey(Interest record);
}