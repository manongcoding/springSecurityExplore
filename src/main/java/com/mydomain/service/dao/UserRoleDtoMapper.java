package com.mydomain.service.dao;

import com.mydomain.service.model.UserRoleDto;

import java.util.List;

public interface UserRoleDtoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserRoleDto record);

    int insertSelective(UserRoleDto record);

    UserRoleDto selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRoleDto record);

    int updateByPrimaryKey(UserRoleDto record);

    List<UserRoleDto>  queryByUserId(Long userId);
}