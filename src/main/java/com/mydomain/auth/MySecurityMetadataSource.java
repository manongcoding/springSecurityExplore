package com.mydomain.auth;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.mydomain.service.dao.ResourceDtoMapper;
import com.mydomain.service.model.ResourceDto;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import javax.annotation.Resource;

public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource, InitializingBean {

    @Resource
    private ResourceDtoMapper                    resourceDtoMapper;

    HashMap<String, Collection<ConfigAttribute>> attributes = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        this.loadPermission();
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        if (attributes.containsKey(requestUrl)) {
            return attributes.get(requestUrl);
        }

        Collection<ConfigAttribute> configAttributes = new HashSet<>();
        configAttributes.add(new SecurityConfig("PERMISSION_NONE"));
        return configAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    private void loadPermission() {
        List<ResourceDto> resourceDtos = resourceDtoMapper.query();
        for (ResourceDto resourceDto : resourceDtos) {
            Collection<ConfigAttribute> configAttributes = new HashSet<>();
            configAttributes.add(new SecurityConfig(resourceDto.getPath()));
            attributes.put(resourceDto.getPath(), configAttributes);
        }
    }
}
