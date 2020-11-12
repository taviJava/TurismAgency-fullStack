package com.example.ProjectTogether;

import com.example.ProjectTogether.model.ContinentModel;
import com.example.ProjectTogether.repository.ContinentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ProjectTogetherApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProjectTogetherApplication.class, args);
  }

//  @Bean
//  CommandLineRunner init(ContinentRepository continentRepository) {
//    return args -> {
//      Stream.of("Asia", "Europa", "America", "Australia", "Africa").forEach(name -> {
//
//        ContinentModel continentModel = new ContinentModel(name);
//        continentRepository.save(continentModel);
//
//      });
//      continentRepository.findAll().forEach(System.out::println);
//    };
//  }
}


