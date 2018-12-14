package io.khasang.auction.dao;

import java.util.List;

public interface BasicDao<T> {
/**
 * method for adding entity to DB
 *
 * @param entity - entity for adding
 * @return created entity
 *
 * */

    T add(T entity);

    /**
     * method for getting entity by id
     *
     * @param id - entity's id for adding
     * @return entity by entity
     *
     * */
    T getById(long id);

    /**
     * method for getting all entities
     *
     *
     * @return all entities
     *
     * */
    List<T> getAll();

    /**
     * method for updating entity in DB
     *
     * @param entity - entity for updating
     * @return updated entity
     *
     * */

    T update(T entity);

    /**
     * method for deletion entity from DB
     *
     * @param entity - entity for deletion
     * @return deleted entity
     *
     * */

    T delete(T entity);
}
