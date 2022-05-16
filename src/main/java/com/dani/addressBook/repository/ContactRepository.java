package com.dani.addressBook.repository;

import com.dani.addressBook.domain.Contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{
    
}
