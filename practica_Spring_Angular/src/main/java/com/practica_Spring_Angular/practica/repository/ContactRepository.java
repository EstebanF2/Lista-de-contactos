package com.practica_Spring_Angular.practica.repository;

import com.practica_Spring_Angular.practica.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
