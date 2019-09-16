package com.slykhachov.sfgpetclinic.services.map;

import com.slykhachov.sfgpetclinic.model.BaseEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T obj) {
       if (obj != null) {
           if (obj.getId() == null) {
                obj.setId(getNextId());
           }
           map.put(obj.getId(), obj);
       } else {
            throw new RuntimeException("Objects can not be null");
       }
       return obj;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T obj) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(obj));
    }

    private long getNextId() {
        long id;
        try {
            id = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            id = 1L;
        }
        return id;
    }

}

