package com.packt.domain.repository.impl;

import com.packt.domain.TrolloBoard;
import com.packt.domain.TrolloColumn;
import com.packt.domain.TrolloUsers;

import java.util.List;

/**
 * Created by Winiu on 20-05-2016.
 */
public interface ColumnRepository {
    void createColumn(TrolloBoard trolloBoard, TrolloColumn trolloColumn, TrolloUsers trolloUsers);
    List<TrolloColumn> readAllColumn(TrolloBoard trolloBoard);
    TrolloColumn readOneColumn (TrolloBoard trolloBoard, long idColumn);
    void update (long idColumn, String titleColumn);
    void delete (long idColumn);
}
