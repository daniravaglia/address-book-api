package com.dani.addressBook.service;

import java.util.List;
import java.util.stream.Collectors;

import com.dani.addressBook.domain.Contact;
import com.dani.addressBook.dto.ContactDTO;
import com.dani.addressBook.repository.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.glasnost.orika.MapperFacade;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private MapperFacade orikaMapperFacade;

    public ContactDTO getContact(Long id) {
        return orikaMapperFacade.map(contactRepository.findById(id).orElseThrow(), ContactDTO.class) ;
    }

    public List<ContactDTO> getAllContacts() {
        return contactRepository.findAll()
                        .stream()
                        .map(contact -> {return orikaMapperFacade.map(contact, ContactDTO.class);})
                        .collect(Collectors.toList());
    }

    public Long createContact(ContactDTO contactDTO) {
        return contactRepository.save(
            orikaMapperFacade.map(contactDTO, Contact.class)
        ).getId();
    }

    public void updateContact(ContactDTO contactDTO) {
        contactRepository.save(
            orikaMapperFacade.map(contactDTO, Contact.class)
        );
    }

    public void deleteContactById(Long id) {
        contactRepository.deleteById(
            getContact(id).getId()
        );
    }
}
