package com.turksat.mpasecurity.controller;

import com.turksat.mpasecurity.domain.Authority;
import com.turksat.mpasecurity.domain.RoleResult;
import com.turksat.mpasecurity.services.AuthorityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class AuthorityController {
    @Autowired
    AuthorityService authorityService;

    @GetMapping("/api/1.0/roles")
    RoleResult getRoleList(){
        log.info("role list");
        RoleResult roleResult = new RoleResult();
        roleResult.setData(authorityService.findAll());
        return roleResult;
    }
}
