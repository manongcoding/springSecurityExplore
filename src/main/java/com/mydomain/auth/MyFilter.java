package com.mydomain.auth;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author jyl25609
 * @version Id: MyFilter, v 0.1 2018-05-17 15:45:36 jyl25609 Exp $
 */
public class MyFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(request);
        chain.doFilter(request, response);
    }
}
