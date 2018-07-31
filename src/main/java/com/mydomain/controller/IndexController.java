package com.mydomain.controller;

import java.util.*;

import javax.annotation.Resource;

import com.mydomain.event.TestEvent;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mydomain.service.dao.IUserMapper;
import com.mydomain.service.model.User;

/**
 * @author jyl25609
 * @version Id: IndexController, v 0.1 2018-05-14 10:24:12 jyl25609 Exp $
 */
@Controller
public class IndexController implements BeanFactoryAware {

    @Resource
    private IUserMapper        iUserMapper;

    @Resource
    private PasswordEncoder    passwordEncoder;

    @Resource
    private ApplicationContext applicationContext;
    BeanFactory beanFactory;
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @RequestMapping("/")
    public String index() {

        List<User> user = iUserMapper.query(0);
        System.out.println(user);




        TestEvent event = new TestEvent(this);
        event.setMessage("index");
        applicationContext.publishEvent(event);

        return "index/index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "index/logout";
    }

    @RequestMapping("/json")
    @ResponseBody
    public List<Object> json() {
        List<Object> list = new ArrayList<>();
        list.add("a");
        list.add(1);
        list.add(new Date());
        return list;
    }

    @RequestMapping("/reset")
    @ResponseBody
    public Map<String, Boolean> reset() {
        List<User> users = iUserMapper.query(0);
        for (User user : users) {
            String pw = passwordEncoder.encode("123456");
            user.setPassword(pw);
            iUserMapper.updateByPrimaryKey(user);
        }

        Map<String, Boolean> res = new HashMap<>();
        res.put("success", true);
        return res;
    }
}
