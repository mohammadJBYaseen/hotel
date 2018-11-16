package com.myaseen.hotel.dao;

import com.myaseen.hotel.exception.DataException;
import com.myaseen.hotel.exception.EntityNotFoundException;
import com.myaseen.hotel.model.Provider;
import com.myaseen.hotel.util.IDGenerator;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProviderDummyDaoImpl extends AbstractDummyDaoImpl<Provider> implements ProviderDao{

    Map<String,Provider> codeToProvide = new HashMap<>();

    public ProviderDummyDaoImpl(IDGenerator idGenerator) {
        super(idGenerator);
    }

    @Override
    public Provider findByCode(String code) throws DataException {
        Provider provider = codeToProvide.getOrDefault(code, null);
        if(provider == null){
            throw new EntityNotFoundException("Can't find provider with code "+code);
        }
        return provider;
    }

    @Override
    protected void saveExtra(Provider provider) {
        codeToProvide.put(provider.getCode(),provider);
    }

    @Override
    protected void deleteExtra(Provider provider) {
        codeToProvide.remove(provider.getCode());
    }
}
