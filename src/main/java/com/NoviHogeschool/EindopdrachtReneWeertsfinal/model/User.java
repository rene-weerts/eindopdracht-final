package com.NoviHogeschool.EindopdrachtReneWeertsfinal.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity //het is een entiteit
@Getter
@Setter
@Table(name="users") //in meervoud
public class User {
    @Id //door @Id wordt username en wachtwoord gekozen als identifier
    private String username; //door @Id is deze string een unieke username

    private String password; //wachtwoord is automatisch onderdeel van de entiteit

    @ManyToMany(fetch = FetchType.EAGER) //fetchType.EAGER zorgt ervoor dat uit het user object de rollen uitgelezen worden
    private Collection<Role> roles; //heeft een many to many relatie naar het lijstje van roles


}
