package com.slykhachov.sfgpetclinic.repository;

import com.slykhachov.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
