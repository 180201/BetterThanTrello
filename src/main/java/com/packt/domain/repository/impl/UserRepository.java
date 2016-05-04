package com.packt.domain.repository.impl;

import com.packt.domain.Trollo_users;

/**
 * Created by WP on 17.04.2016.
 */
public interface UserRepository {
    void create(Trollo_users user);
    Trollo_users read(String Login);
    void update(long userId,Trollo_users user);
    void delete(long UserId);
}
