package com.turksat.mpasecurity.controller;

import com.turksat.mpasecurity.domain.Authority;
import com.turksat.mpasecurity.domain.RoleResult;
import com.turksat.mpasecurity.services.AuthorityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class AuthorityController {
    @PostMapping("/api/1.0/auth")
    void handleAuthentication(@RequestHeader(name = "Authorization") String authorization) {
        log.info(authorization);
    }

    @Autowired
    AuthorityService authorityService;

    @GetMapping("/api/1.0/roles")
    RoleResult getRoleList(){
        RoleResult roleResult = new RoleResult();
        roleResult.setData(authorityService.findAll());
        return roleResult;
    }

    @PostMapping("/api/1.0/role")
    boolean setRole(@RequestBody Authority authority){
        Authority result = authorityService.save(authority); //Todo Düzeltilecek
        if (result != null)
            return true;
        return false;
    }
}
