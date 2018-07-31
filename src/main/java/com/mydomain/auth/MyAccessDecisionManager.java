package com.mydomain.auth;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class MyAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if (configAttributes == null || configAttributes.size() == 0) {
            return;
        }

        Collection<? extends GrantedAuthority> grantedAuthorities = authentication.getAuthorities();
        if (grantedAuthorities == null || grantedAuthorities.size() == 0) {
            return;
        }

        for (ConfigAttribute sc : configAttributes) {
            for (GrantedAuthority g : grantedAuthorities) {
                if (g.getAuthority().equals(sc.getAttribute())) {
                    return;
                }
            }
        }

        throw new AccessDeniedException("没有权限访问！");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
