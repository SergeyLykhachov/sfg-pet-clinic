package com.slykhachov.sfgpetclinic.services;

import com.slykhachov.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
