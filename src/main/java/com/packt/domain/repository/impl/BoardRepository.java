package com.packt.domain.repository.impl;

import com.packt.domain.TrolloBoard;
import com.packt.domain.TrolloUsers;

import java.util.List;

/**
 * Created by Winiu on 05-05-2016.
 */
public interface BoardRepository {
    void createBoard(TrolloBoard trolloBoard, TrolloUsers trolloUsers);
    List<TrolloBoard> readAllBoard(TrolloUsers trolloUsers);
    TrolloBoard readOneBoard (TrolloUsers trolloUsers, long idBoard);
    void update (long idBoard, String titleBoard);
    void delete (long idBoard);
}
