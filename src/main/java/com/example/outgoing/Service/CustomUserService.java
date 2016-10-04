package com.example.outgoing.Service;


import com.example.outgoing.Entity.User;

public interface CustomUserService {

    User findByUsername(String username);
}
