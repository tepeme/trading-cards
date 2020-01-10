package com.tepe.trendyol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication public class Application implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        LOG.info("Starting The Game");
        SpringApplication.run(Application.class, args);
        LOG.info("Game Finished");
    }

    @Override public void run(String... args) throws Exception {

    }
}
