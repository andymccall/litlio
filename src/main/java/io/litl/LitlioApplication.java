package io.litl;

import io.litl.model.LitlioEntryCount;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LitlioApplication {

    public static LitlioEntryCount count = new LitlioEntryCount();

    public static void main(String[] args) {
        SpringApplication.run(LitlioApplication.class, args);
    }
}