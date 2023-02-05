package com.example.bootstrap;

import com.example.model.*;
import com.example.services.OwnerService;
import com.example.services.PetTypeService;
import com.example.services.SpecialityService;
import com.example.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    public void loadData() {
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");


        PetType dogPetType = new PetType();
        dogPetType.setName("Dog");
        petTypeService.save(dogPetType);

        PetType catPetType = new PetType();
        dogPetType.setName("Cat");
        petTypeService.save(catPetType);


        PetType dog = new PetType();
        dog.setName("Dog");
        PetType cat = new PetType();
        cat.setName("Cat");
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Main St");
        owner1.setCity("Mountain");
        owner1.setTelephone("123123123");
        Pet mikesPet = new Pet();
        mikesPet.setOwner(owner1);
        mikesPet.setPetType(dogPetType);
        mikesPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Main St");
        owner2.setCity("Mountain");
        owner2.setTelephone("123123123");
        Pet fionasCat = new Pet();
        fionasCat.setOwner(owner2);
        fionasCat.setPetType(catPetType);
        fionasCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(fionasCat);
        ownerService.save(owner2);
        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(radiology);
        specialityService.save(radiology);
        vetService.save(vet1);
        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(dentistry);
        vet2.getSpecialities().add(surgery);
        specialityService.save(dentistry);
        specialityService.save(surgery);
        vetService.save(vet2);
        System.out.println("Loaded Vets....");
    }
}
