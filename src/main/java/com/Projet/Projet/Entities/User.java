package com.Projet.Projet.Entities;

import com.Projet.Projet.Enum.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String mdp;
    @Enumerated
    private Role role;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_discussion",
            joinColumns =  @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "discussion_id", referencedColumnName = "id"))
    @JsonIgnore
    private List<Discussion> discussions = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Message> messages = new ArrayList<>();
}
