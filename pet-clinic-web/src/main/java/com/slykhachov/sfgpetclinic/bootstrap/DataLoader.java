package com.slykhachov.sfgpetclinic.bootstrap;

import com.slykhachov.sfgpetclinic.model.Owner;
import com.slykhachov.sfgpetclinic.model.Vet;
import com.slykhachov.sfgpetclinic.services.OwnerService;
import com.slykhachov.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Preston");

        this.ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Robert");
        owner2.setLastName("Gremmy");

        this.ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Dennis");
        vet1.setLastName("Brooks");

        this.vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jake");
        vet2.setLastName("Adami");

        this.vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
