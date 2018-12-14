package io.khasang.auction.service.impl;

import io.khasang.auction.dao.BirdDao;
import io.khasang.auction.entity.Bird;
import io.khasang.auction.service.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BirdServiceImpl implements BirdService {
    @Autowired
    private BirdDao birdDao;

    @Override
    public Bird add(Bird bird) {
        return birdDao.add(bird);
    }

    @Override
    public Bird getById(long id) {
        return birdDao.getById(id);
    }

    @Override
    public List<Bird> getAll() {
        return birdDao.getAll();
    }

    @Override
    public Bird update(Bird bird) {
        return birdDao.update(bird);
    }

    @Override
    public Bird delete(long id) {
        return birdDao.delete(getById(id));
    }
}
