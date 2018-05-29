package com.izu.hatavar.services;

import com.izu.hatavar.models.User;

import java.util.List;

public interface UserService
{
    List<User> findByPasswordAndUserEmail(String password, String userEmail);
    User save(User user);
}
