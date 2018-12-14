package io.khasang.auction.service;

import io.khasang.auction.entity.Bird;

import java.util.List;

public interface BirdService {
    /**
     * method for adding entity to DB
     *
     * @param bird - entity for adding
     * @return created bird
     *
     *
     * */

    Bird add(Bird bird);

    /**
     * method for getting bird by id
     *
     * @param id - bird's id for adding
     * @return birds by id
     *
     * */
    Bird getById(long id);

    /**
     * method for getting all birds
     *
     *
     * @return all birds
     *
     * */
    List<Bird> getAll();

    /**
     * method for updating bird in DB
     *
     * @param entity - bird for updating
     * @return updated bird
     *
     * */

    Bird update(Bird bird);

    /**
     * method for deletion bird from DB
     *
     * @param id - bird's id for deletion
     * @return deleted bird
     *
     * */

    Bird delete(long id);
}
