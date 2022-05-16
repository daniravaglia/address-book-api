package com.dani.addressBook.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Contact {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private String name;

    @Column
    private String surename;

    @Column
    @NonNull
    private String phoneNumber;

    @Column
    private String email;
}
