package com.dani.addressBook.resource;

import java.util.List;
import java.util.NoSuchElementException;

import com.dani.addressBook.domain.Contact;
import com.dani.addressBook.dto.ContactDTO;
import com.dani.addressBook.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/contact/")
public class ContactResource {
    
    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<ContactDTO> getAllContacts(){
        return contactService.getAllContacts();
    }

    @GetMapping("{contactId}/")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable(name = "contactId") Long contactId){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(contactService.getContact(contactId));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        
    }

    @PostMapping
    public Long createContact(@RequestBody ContactDTO contact){
        return contactService.createContact(contact);
    }

    @PutMapping
    public void updateContact(@RequestBody ContactDTO contact){
        contactService.updateContact(contact);
    }

    @DeleteMapping("{contactId}/")
    public void deleteContactById(@PathVariable(name = "contactId") Long contactId){
        contactService.deleteContactById(contactId);
    }

}
