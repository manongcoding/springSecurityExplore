package com.mydomain.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import com.mydomain.service.UserResource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mydomain.service.dao.IUserMapper;
import com.mydomain.service.model.User;

/**
 * @author jyl25609
 * @version Id: SecurityManagerSupport, v 0.1 2018-05-16 11:15:57 jyl25609 Exp $
 */
public class SecurityManagerSupport implements UserDetailsService {

    @Resource
    private IUserMapper  iUserMapper;

    @Resource
    private UserResource userResource;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = iUserMapper.queryByUsername(s);
        if (user != null && user.getUsername().equals(s)) {
            List<String> resources = userResource.loadUserResources(new Long(user.getId()));
            UserDetails userDetails = new UserDetails() {
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
                    resources.forEach(it -> list.add(new SimpleGrantedAuthority(it)));
                    return list;
                }

                @Override
                public String getPassword() {
                    return user.getPassword();
                }

                @Override
                public String getUsername() {
                    return user.getUsername();
                }

                @Override
                public boolean isAccountNonExpired() {
                    return true;
                }

                @Override
                public boolean isAccountNonLocked() {
                    return true;
                }

                @Override
                public boolean isCredentialsNonExpired() {
                    return true;
                }

                @Override
                public boolean isEnabled() {
                    return true;
                }
            };

            return userDetails;
        }

        return null;
    }
}
