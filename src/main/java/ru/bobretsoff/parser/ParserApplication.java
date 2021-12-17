package ru.bobretsoff.parser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**  указание на автоконфигурацию , сканирование компонентов и конфигурацию Spring Boot. */
@SpringBootApplication
@EnableScheduling
public class ParserApplication {

    /** запуск приложения. */
    public static void main(String[] args) {
        SpringApplication.run(ParserApplication.class, args);
    }

}
