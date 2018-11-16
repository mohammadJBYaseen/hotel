package com.myaseen.hotel.dao;

import com.myaseen.hotel.exception.DataException;
import com.myaseen.hotel.exception.DuplicateEntityException;
import com.myaseen.hotel.exception.EntityNotFoundException;
import com.myaseen.hotel.model.Entity;
import com.myaseen.hotel.util.IDGenerator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractDummyDaoImpl<E extends Entity> implements Dao<Long,E> {

    private IDGenerator idGenerator;
    private Map<Long,E> index = new HashMap<>();
    private Set<E> objects =new HashSet<>();

    public AbstractDummyDaoImpl(IDGenerator idGenerator){
        this.idGenerator = idGenerator;
    }

    @Override
    public final E save(E e) throws DataException {
       if(e.getId() == -1){
            if(objects.contains(e)){
                throw new DuplicateEntityException("duplicate raw "+e.toString());
            }
            e.setId(idGenerator.nextID());
            return saveImpl(e);
       }else{
           E entity = index.get(e.getId());
           if(entity != null) {
               objects.remove(entity);
           }
           return saveImpl(e);
       }
    }

    @Override
    public final void delete(E e) {
        if(e.getId() != -1){
            E entity = index.get(e.getId());
            deleteImpl(entity);
        }
    }

    private  E saveImpl(E e){
        index.put(e.getId(), e);
        objects.add(e);
        saveExtra(e);
        return e;
    }

    private void deleteImpl(E e){
        index.remove(e.getId());
        objects.remove(e);
        deleteExtra(e);
    }

    protected void saveExtra(E e){

    }

    protected void deleteExtra(E e){

    }



    public final E getByPk(Long key) throws DataException {
        E e = index.get(key);
        if(e != null){
            return e;
        }
        throw new EntityNotFoundException("can't find entity with key "+key);
    }

}
