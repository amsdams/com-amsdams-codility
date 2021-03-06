package com.amsdams;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StartTaskApplication {

    // start everything
    public static void main(String[] args) {
        SpringApplication.run(StartTaskApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(TaskRepository repository) {
        return args -> {
            repository.save(new Task("This is a description", 1L));
            repository.save(new Task("This is a description 1", 2L));
           };
    }
}