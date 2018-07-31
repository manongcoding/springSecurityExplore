package com.mydomain.auth;

import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author jyl25609
 * @version Id: MyFilterSecurityInterceptor, v 0.1 2018-05-18 09:36:55 jyl25609 Exp $
 */

public class MyFilterSecurityInterceptor extends FilterSecurityInterceptor {
    @Override
    public void invoke(FilterInvocation fi) throws IOException, ServletException {
        super.invoke(fi);
    }
}
