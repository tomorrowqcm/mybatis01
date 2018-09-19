package com.qcm.mapper;

import com.qcm.pojo.User;

import java.util.List;

public interface UserMapper {

    public User findById(Integer id);

    public List<User> findByName(String name);

    public void insertUser(User user);

}
