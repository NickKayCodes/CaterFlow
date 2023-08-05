package com.krath.CaterFlowBackEnd.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.krath.CaterFlowBackEnd.deserializers.UserRoleDeserializer;
import com.krath.CaterFlowBackEnd.user.enums.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfiguration {
    //object mapper is responsible for serialization/deserialization of the JSONs in the app
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        objectMapper.registerModule(new SimpleModule().addDeserializer(UserRole.class, new UserRoleDeserializer()));
        return objectMapper;
    }
}
