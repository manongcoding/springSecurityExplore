package com.mydomain.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mydomain.service.model.User;

@Repository
public interface IUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> query(Integer id);

    User queryByUsername(String username);
}
