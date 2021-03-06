package com.intech.telecom.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<PK extends Serializable, T> {

	void persist(T entity);

    T getByKey(PK id);

    List<T> getAll();

    void update(T group);

}
