package com.slykhachov.sfgpetclinic.services.map;

import com.slykhachov.sfgpetclinic.model.Specialty;
import com.slykhachov.sfgpetclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialtyService {
    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Specialty obj) {
        super.delete(obj);
    }

    @Override
    public Specialty save(Specialty obj) {
        return super.save(obj);
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }
}
