package com.practica_Spring_Angular.practica.services;

import com.practica_Spring_Angular.practica.dto.ContactDTO;
import com.practica_Spring_Angular.practica.entity.Contact;
import com.practica_Spring_Angular.practica.exception.ResourceNotFoundException;
import com.practica_Spring_Angular.practica.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private  final ModelMapper mapper;


    public Iterable<Contact> list() {
        return contactRepository.findAll();
    }

    public Contact searchContact(Integer id) {
        return contactRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Contact create(ContactDTO contactDTO){
        //con la libreria ModelMapper mapeo las clases para compartir atributos.
        Contact contact =  mapper.map(contactDTO, Contact.class);
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public Contact update(Integer id, ContactDTO contactDTO){
        Contact contactFromBD = searchContact(id);
        mapper.map(contactDTO, contactFromBD);

        return contactRepository.save(contactFromBD);
    }

    public void delete(Integer id) {
        Contact contactFromBD = searchContact(id);
        contactRepository.delete(contactFromBD);
    }

}
