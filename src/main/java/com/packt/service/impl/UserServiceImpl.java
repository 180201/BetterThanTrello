package com.packt.service.impl;

import com.packt.domain.Uzytkownik;
import com.packt.domain.repository.impl.UserRepository;
import com.packt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by WP on 21.04.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    @Transactional
    public void create(Uzytkownik user) {
        userRepository.create(user);
    }

    @Transactional
    public Uzytkownik read(long userId) {
        return userRepository.read(userId);
    }

    @Override
    public void update(long userId, Uzytkownik user) {
        //userRepository.update(use);
    }

    @Override
    public void delete(long UserId) {

    }
}
