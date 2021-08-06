package com.turksat.mpasecurity.services;

import com.turksat.mpasecurity.domain.Authority;

import java.util.List;

public interface IAuthorityService {
    List<Authority> findAll();
    Authority save(Authority authority);
}
