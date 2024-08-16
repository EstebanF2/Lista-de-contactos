package com.practica_Spring_Angular.practica;

import com.practica_Spring_Angular.practica.entity.Contact;
import com.practica_Spring_Angular.practica.repository.ContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PracticaSpringAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticaSpringAngularApplication.class, args);
	}

	//Esto es para tener datos en la BD de h2 al momento de iniciar la app.
	@Bean
	CommandLineRunner runner(ContactRepository contactRepository) {
		return args -> {
            List<Contact> contacts = Arrays.asList(
                    new Contact("Carlos", "carlos@gmail.com", LocalDateTime.now()),
                    new Contact("Jose", "jose@gmail.com", LocalDateTime.now()),
                    new Contact("Pedro", "pepe@gmail.com", LocalDateTime.now()),
                    new Contact("Marcos", "marcos@gmail.com", LocalDateTime.now()),
                    new Contact("Leo", "leo@gmail.com", LocalDateTime.now())
            );
            contactRepository.saveAll(contacts);
        };
	}

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
