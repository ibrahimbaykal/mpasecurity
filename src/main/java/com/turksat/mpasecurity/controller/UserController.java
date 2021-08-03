package com.turksat.mpasecurity.controller;

import com.turksat.mpasecurity.domain.UsersResult;
import com.turksat.mpasecurity.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/api/1.0/users")
    UsersResult getUserList() {
        log.info("user list");
        UsersResult result = new UsersResult();
        result.setData(userService.findAll());
        return result;
    }
}