package ru.aloeok.wrtask;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootConfiguration
@EnableJpaRepositories(
        basePackages = {
                "ru.aloeok.wrtask.repository"
        }
)
@EntityScan(
        basePackages = {
                "ru.aloeok.wrtask.entity"
        }
)
public class Configuration {
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
