package com.myaseen.hotel.dao;

import com.myaseen.hotel.exception.DataException;
import com.myaseen.hotel.exception.EntityNotFoundException;

public interface Dao<K,E> {
    /**
     * <p>Save/Update entity</p>
     * @param e entity to be saved
     * @return saved entity object;
     */
    E save(E e) throws DataException;

    /**
     * <p>Delete entity</p>
     * @param e entity to be deleted
     */
    void delete(E e);

    /**
     * <p>Load entity by it's pk</p>
     * @param k  entity pk
     * @return
     */
    E getByPk(K k) throws DataException;
}
