package com.mydomain.service.dao;

import com.mydomain.service.model.RoleResourceDto;

import java.util.List;

public interface RoleResourceDtoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleResourceDto record);

    int insertSelective(RoleResourceDto record);

    RoleResourceDto selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleResourceDto record);

    int updateByPrimaryKey(RoleResourceDto record);

    List<RoleResourceDto> queryByRoleId(Long roleId);
}