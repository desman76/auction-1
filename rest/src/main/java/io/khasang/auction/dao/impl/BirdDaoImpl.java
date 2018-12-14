package io.khasang.auction.dao.impl;

import io.khasang.auction.dao.BirdDao;
import io.khasang.auction.entity.Bird;

public class BirdDaoImpl extends BasicDaoImpl<Bird> implements BirdDao {
    public BirdDaoImpl(Class<Bird> entityClass) {
        super(entityClass);
    }
}
