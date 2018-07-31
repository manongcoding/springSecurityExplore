package com.mydomain.service.dao;

import com.mydomain.service.model.RoleDto;

public interface RoleDtoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleDto record);

    int insertSelective(RoleDto record);

    RoleDto selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleDto record);

    int updateByPrimaryKey(RoleDto record);
}