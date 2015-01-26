package com.triadic.nexgeno.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by psramkumar on 9/28/2014.
 *
 */
@Service
public class ApplicationServices {

    @Autowired
    private MongoOperations mongoOperations;

    public void removeModel(String id, Class<?> o){
        mongoOperations.remove(o, id);
    }

    public void saveUpdateModel(Object o){
        mongoOperations.save(o);
    }

    public List findAll(Class<?> o){
        return mongoOperations.findAll(o);
    }
    public Object findById(String id, Class<?> o){
        return mongoOperations.findById(id, o);
    }



}
