package com.mixamum.carallauto.util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@Slf4j
public class LogController {

    // creating a logger
    public static final Logger logger = LoggerFactory.getLogger(LogController.class);

    public void logError(HttpClientErrorException e) {
        String message = "Service Call Failed: --- " + e.toString();
        logger.error(message);
    }

    public void logError(String error) {
        String message = "Service Call Failed: --- " + error;
        logger.error(message);
    }

    public void logInfo(String e) {
        logger.info(e);
    }

}
