package com.packt.domain.repository.impl;

import com.packt.domain.TrolloUsers;

/**
 * Created by WP on 17.04.2016.
 */
public interface UserRepository {
    void create(TrolloUsers user);
    TrolloUsers read(String Login);
    void update (long userId, TrolloUsers user);
    void delete(long UserId);
}
