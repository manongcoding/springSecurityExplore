package com.mydomain.service.dao;

import com.mydomain.service.model.ResourceDto;

import java.util.List;

public interface ResourceDtoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResourceDto record);

    int insertSelective(ResourceDto record);

    ResourceDto selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResourceDto record);

    int updateByPrimaryKey(ResourceDto record);

    List<ResourceDto> query();
}