package com.packt.service;

import com.packt.domain.Uzytkownik;

/**
 * Created by WP on 21.04.2016.
 */
public interface UserService {

    void create(Uzytkownik user);
    Uzytkownik read(long userId);
    void update(long userId,Uzytkownik user);
    void delete(long UserId);
}
