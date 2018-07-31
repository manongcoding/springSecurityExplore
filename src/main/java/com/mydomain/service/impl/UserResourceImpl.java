package com.mydomain.service.impl;

import com.mydomain.service.UserResource;
import com.mydomain.service.dao.ResourceDtoMapper;
import com.mydomain.service.dao.RoleResourceDtoMapper;
import com.mydomain.service.dao.UserRoleDtoMapper;
import com.mydomain.service.model.ResourceDto;
import com.mydomain.service.model.RoleResourceDto;
import com.mydomain.service.model.UserRoleDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service("userResource")
public class UserResourceImpl implements UserResource {

    @Resource
    private UserRoleDtoMapper     userRoleDtoMapper;

    @Resource
    private RoleResourceDtoMapper roleResourceDtoMapper;

    @Resource
    private ResourceDtoMapper     resourceDtoMapper;

    @Override
    public List<String> loadUserResources(Long userId) {

        List<String> resources = new LinkedList<>();

        List<UserRoleDto> roleDtos = userRoleDtoMapper.queryByUserId(userId);
        if (roleDtos == null || roleDtos.size() == 0) {
            return resources;
        }

        Set<Long> set = new HashSet<>();
        for (UserRoleDto ur : roleDtos) {
            List<RoleResourceDto> rrs = roleResourceDtoMapper.queryByRoleId(ur.getRoleId());
            for (RoleResourceDto rr : rrs) {
                set.add(rr.getResourceId());
            }
        }

        for (Long id : set) {
            ResourceDto resourceDto = resourceDtoMapper.selectByPrimaryKey(id);
            resources.add(resourceDto.getPath());
        }

        return resources;
    }
}
