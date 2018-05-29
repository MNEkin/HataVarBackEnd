package com.izu.hatavar.services;

import com.izu.hatavar.models.User;
import com.izu.hatavar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findByPasswordAndUserEmail(String password, String userEmail)
    {
        return userRepository.findByPasswordAndUserEmail(password, userEmail);
    }

    @Override
    public User save(User user)
    {
        return userRepository.save(user);
    }
}
