package com.slykhachov.sfgpetclinic.services.map;

import com.slykhachov.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T finfById(ID id) {
        return map.get(id);
    }

    T save(T obj) {
       if (obj != null) {
           if (obj.getId() == null) {
                obj.setId(getNextID());
           }
           map.put(getNextID(), obj);
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

    private long getNextID() {
        Long id = null;
        try {
            id = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            id = 1L;
        }
        return id;
    }
}
