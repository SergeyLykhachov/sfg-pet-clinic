package com.slykhachov.sfgpetclinic.services.map;

import com.slykhachov.sfgpetclinic.model.Vet;
import com.slykhachov.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.finfById(id);
    }

    @Override
    public Vet save(Vet obj) {
        return super.save(obj.getId(), obj);
    }

    @Override
    public void delete(Vet obj) {
        super.delete(obj);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
