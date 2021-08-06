package com.turksat.mpasecurity.services;

import com.turksat.mpasecurity.domain.Authority;
import com.turksat.mpasecurity.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService implements IAuthorityService {

    @Autowired
    AuthorityRepository authorityRepository;

    @Override
    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }

    @Override
    public Authority save(Authority authority) {
        Authority savedAuthority = authorityRepository.save(authority);
        return savedAuthority;
    }
}
