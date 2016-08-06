package com.stwitter.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by A.Shcherbina
 * on 31.07.2016.
 */
public interface GenericDao<T, PK extends Serializable> {
    T findById(PK id);

    List<T> findAll();

    PK save(T value);

    void update(T value);

    void delete(T value);
    
}
