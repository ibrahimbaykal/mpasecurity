package com.turksat.mpasecurity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AuthController {

    @PostMapping("/api/1.0/auth")
    void handleAuthentication(@RequestHeader(name = "Authorization") String authorization) {
        log.info(authorization);
    }
}
