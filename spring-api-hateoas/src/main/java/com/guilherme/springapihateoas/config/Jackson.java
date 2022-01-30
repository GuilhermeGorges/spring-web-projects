package com.guilherme.springapihateoas.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.PackageVersion;
import com.guilherme.springapihateoas.enums.Breed;
import org.hibernate.secure.spi.JaccIntegrator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class Jackson {

    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        // Unable Unknown Properties
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // Unable Single Value as Array
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, false);
        // To receive Single Values as Array
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        objectMapper.registerModule(new JavaTimeModule());

        objectMapper.registerModule(breedModuleMapper());
        return objectMapper;
    }

    public SimpleModule breedModuleMapper(){
        SimpleModule dataModule = new SimpleModule("JSONBreedModule", PackageVersion.VERSION);
        dataModule.addSerializer(Breed.class, new BreedSerialize());
        dataModule.addDeserializer(Breed.class, new BreedDeserialize());
        return dataModule;
    }

    class BreedSerialize extends StdSerializer<Breed> {
        public BreedSerialize(){
            super(Breed.class);
        }

        @Override
        public void serialize(Breed breed, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException{
            jsonGenerator.writeString(breed.getValue());
        }
    }

    class BreedDeserialize extends StdDeserializer<Breed> {
        public BreedDeserialize(){
            super(Breed.class);
        }

        @Override
        public Breed deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return Breed.valueOf(jsonParser.getText());
        }
    }
}
