package com.example.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T,ID> {

    Map<ID,T> map = new HashMap<>();

    public T findById(ID id){
        return map.get(id);
    }

    public T save(ID id, T object){
        return map.put(id,object);
    }

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }
}
