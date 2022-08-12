package br.com.cursojava.petshop.configuration;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//TODO criar bean para modelmapper
@Configuration
@Slf4j
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper defaultModelMapper() {
        return new ModelMapper();
    }

}
