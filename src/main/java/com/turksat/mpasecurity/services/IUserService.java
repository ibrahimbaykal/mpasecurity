package com.turksat.mpasecurity.services;

import com.turksat.mpasecurity.domain.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
}
