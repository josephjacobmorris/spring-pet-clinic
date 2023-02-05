package com.example.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = {"pets"}, callSuper = false)
@Table(name = "owners")
public class Owner extends Person{
    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "pets")
    @OneToMany(cascade = CascadeType.ALL, mappedBy ="owner")
    private Set<Pet> pets = new HashSet<Pet>();

}
