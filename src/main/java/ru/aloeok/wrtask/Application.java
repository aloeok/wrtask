package ru.aloeok.wrtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication(
        scanBasePackages = {
                "ru.aloeok.wrtask"
        },
        exclude = {
                JacksonAutoConfiguration.class
        }
)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
