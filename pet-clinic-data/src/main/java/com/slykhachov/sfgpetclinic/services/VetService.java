package com.slykhachov.sfgpetclinic.services;

import com.slykhachov.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet ovner);
    Set<Vet> findAll();
}
