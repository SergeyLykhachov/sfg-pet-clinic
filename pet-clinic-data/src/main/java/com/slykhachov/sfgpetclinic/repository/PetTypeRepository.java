package com.slykhachov.sfgpetclinic.repository;

import com.slykhachov.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long > {
}
