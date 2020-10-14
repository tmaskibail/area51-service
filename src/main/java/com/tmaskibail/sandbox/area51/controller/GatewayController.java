package com.tmaskibail.sandbox.area51.controller;


import com.tmaskibail.sandbox.area51.util.SecretsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GatewayController {

    public static final Logger LOG = LoggerFactory.getLogger(GatewayController.class);

    @GetMapping(value = "/health")
    public ResponseEntity<String> health() {
        //TODO: implement deep checks

        LOG.info("Health check triggered");
        return ResponseEntity.ok("OK");
    }

    /**
     * Dummy endpoint to test secrets feature. Not for use in production!
     *
     * @return dummy secret
     */
    @GetMapping(value = "/secret")
    public ResponseEntity<String> printSecrets() {
        String secret = null;
        try {
            secret = SecretsUtil.accessVersion();
        } catch (IOException e) {
            LOG.error("Error occurred while loading secret", e);
        }
        return ResponseEntity.ok(secret);
    }
}
