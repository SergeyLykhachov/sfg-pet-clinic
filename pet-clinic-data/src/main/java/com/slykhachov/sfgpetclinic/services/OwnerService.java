package com.slykhachov.sfgpetclinic.services;

import com.slykhachov.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findByLastNeme(String lastName);
    Owner findById(Long id);
    Owner save(Owner ovner);
    Set<Owner> findAll();
}
