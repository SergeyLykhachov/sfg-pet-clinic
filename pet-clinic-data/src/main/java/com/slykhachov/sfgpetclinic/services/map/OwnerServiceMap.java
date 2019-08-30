package com.slykhachov.sfgpetclinic.services.map;

import com.slykhachov.sfgpetclinic.model.Owner;
import com.slykhachov.sfgpetclinic.model.Pet;
import com.slykhachov.sfgpetclinic.model.PetType;
import com.slykhachov.sfgpetclinic.services.OwnerService;
import com.slykhachov.sfgpetclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeMapService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeMapService petTypeMapService) {
        this.petService = petService;
        this.petTypeService = petTypeMapService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.finfById(id);
    }

    @Override
    public Owner save(Owner obj) {
        if (obj != null) {
            if (obj.getPets() != null) {
                obj.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type Must Not Be null");
                    }
                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(obj);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Owner obj) {
        super.delete(obj);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastNeme(String lastName) {
        return null;
    }
}
