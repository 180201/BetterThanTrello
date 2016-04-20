package com.packt.domain.repository.impl;

import com.packt.domain.Uzytkownik;

/**
 * Created by WP on 17.04.2016.
 */
public interface UserRepository {
    void create(Uzytkownik user);
    Uzytkownik read(long userId);
    void update(long userId,Uzytkownik user);
    void delete(long UserId);
}
