package com.dani.addressBook.service;

import java.util.List;

import com.dani.addressBook.domain.Contact;
import com.dani.addressBook.repository.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    
    @Autowired
    private ContactRepository contactRepository;

    public Contact getContact(Long id){
        return contactRepository.findById(id).orElseThrow();
    }

    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    public Long createContact(Contact contact){
       return contactRepository.save(contact).getId();
    }

    public void updateContact(Contact contact){
        contactRepository.save(contact);
    }

    public void deleteContactById(Long id){
        contactRepository.deleteById(getContact(id).getId());
    }
}
