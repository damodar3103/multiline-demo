package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/success")
    public String success() {
        logger.info("Success endpoint hit");
        return "This is a successful response!";
    }

    @GetMapping("/error")
    public String error() {
        logger.info("Error endpoint hit");
        try {
            throw new RuntimeException("Intentional Exception for Logging");
        } catch (RuntimeException e) {
            logger.error("An error occurred", e);
            throw e;
        }
    }
}
