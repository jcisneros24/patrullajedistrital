package com.patrullajedistrital.infraestructure.config;

import com.patrullajedistrital.infraestructure.event.RutaEventListener;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventConfig {
  /*@Bean
  public ApplicationListener<ApplicationEvent> customEventListener() {
    return event -> {
      // Personalizar el evento antes de enviarlo a Spring Boot Admin
      System.out.println("Evento recibido: " + event);
    };
  }*/
/*
  @Bean
  public CustomApplicationListener customApplicationListener() {
    return new CustomApplicationListener();
  }

  @Bean
  public RutaEventListener rutaEventListener() {
    return new RutaEventListener();
  }

  public static class CustomApplicationListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
      // Personaliza aquí la gestión de eventos genérica si es necesario
      System.out.println("Evento genérico recibido: " + event);
    }

    */
  }
