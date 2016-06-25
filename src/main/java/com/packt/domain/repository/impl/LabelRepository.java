package com.packt.domain.repository.impl;

import com.packt.domain.Label;
import com.packt.domain.TrolloBoard;

import java.util.List;

/**
 * Created by Winiu on 24-06-2016.
 */
public interface LabelRepository {

    void create(Label label,TrolloBoard trolloBoard);
    List<Label> readAllLabel(TrolloBoard trolloBoard);
    Label readOneLabel(long idLabel);
    void update(long idLabel,String color);
    void updateName(long idLabel,String name);
    void delete(long idLabel);
}
