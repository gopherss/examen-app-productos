package com.nttdata.orden_ms.service;

import com.nttdata.orden_ms.model.entity.User;

import java.util.List;

public interface UserService {

    public List<User> listAll();

    public User findById(Long id);

    public User save(User user);

    public User updateById(Long id, User user);

    public void deleteById(Long id);
}
