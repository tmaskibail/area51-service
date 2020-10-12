package com.tmaskibail.sandbox.area51.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

    public static final Logger LOG = LoggerFactory.getLogger(GatewayController.class);

    @GetMapping(value = "/health")
    public ResponseEntity<String> health() {
        //TODO: implement deep checks

        LOG.debug("Health check triggered");
        return ResponseEntity.ok("OK");
    }
}
