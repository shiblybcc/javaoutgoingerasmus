package com.example.outgoing.Service;


import com.example.outgoing.Entity.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findById(Integer id);
    public User findByUsername(String username);

    public User save(User user);
//    public User update(User user);
    public void destroy(User user);
}
