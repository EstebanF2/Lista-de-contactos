package com.practica_Spring_Angular.practica.controller;

import com.practica_Spring_Angular.practica.dto.ContactDTO;
import com.practica_Spring_Angular.practica.entity.Contact;
import com.practica_Spring_Angular.practica.services.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/contacts")
@RestController
public class ContactController {

    private final ContactService contactService;

    //muestro la lista.
    @GetMapping
    public Iterable<Contact> list() {
        return contactService.list();
    }

    //buscar por id
    @GetMapping("/{id}")
    public Contact getContact(@PathVariable Integer id) {
        return contactService.searchContact(id);
    }

    //crear
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contact createContact(@Validated @RequestBody ContactDTO contactDTO){
        return contactService.create(contactDTO);
    }

    //actualizar
    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable Integer id,
                                 @Validated @RequestBody ContactDTO contactDTO){
        return contactService.update(id,contactDTO);
    }

    //eliminar
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Integer id) {
        contactService.delete(id);
    }

}
