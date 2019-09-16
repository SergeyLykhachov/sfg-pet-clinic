package com.slykhachov.sfgpetclinic.services.map;

import com.slykhachov.sfgpetclinic.model.Specialty;
import com.slykhachov.sfgpetclinic.model.Vet;
import com.slykhachov.sfgpetclinic.services.SpecialtyService;
import com.slykhachov.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet obj) {
        if (obj.getSpecialities().size() > 0) {
            obj.getSpecialities().forEach(specialty -> {
                if (specialty.getId() == null) {
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(obj);
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
