package test.mapping;

import java.util.List;

import test.domain.Invitation;

public interface InvitationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Invitation record);

    int insertSelective(Invitation record);

    Invitation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Invitation record);

    int updateByPrimaryKey(Invitation record);
    
    List<Invitation> selectByInviterUserId(Integer id);
}