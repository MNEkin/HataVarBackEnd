package com.izu.hatavar.repositories;

import com.izu.hatavar.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Long>
{
    List <User> findByPasswordAndUserEmail(String password, String userEmail);

    User save(User user);

    User findFirstByUserEmailAndPassword(String userEmail, String password);


}
