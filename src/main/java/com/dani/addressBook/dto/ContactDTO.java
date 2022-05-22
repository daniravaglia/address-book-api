package com.dani.addressBook.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDTO {

    private Long id;

    @NotNull
    private String name;

    private String surename;

    @NotNull
    private String phoneNumber;

    private String email;
}
