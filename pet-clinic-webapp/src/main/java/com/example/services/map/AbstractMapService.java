package com.example.services.map;

import com.example.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    Map<Long, T> map = new HashMap<>();

    public T findById(Long id) {
        return map.get(id);
    }

    public T save( T object) {
        Long id = null;
        if (object == null) {
            throw new IllegalArgumentException("Object cannot be null");
        }
        if ( object.getId() == null) {
            id = getNextId();
            object.setId(id);
        }
        return map.put(object.getId(), object);
    }

    public Long getNextId() {
        Long nextId;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (Exception e) {
            nextId = 1L;
        }
        return nextId;
    }

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }
}
