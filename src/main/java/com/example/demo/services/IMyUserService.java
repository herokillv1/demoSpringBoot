package com.example.demo.services;

import com.example.demo.models.MyUser;

import java.util.List;
import java.util.Optional;

public interface IMyUserService {

    List<MyUser> getUserList();

    MyUser findById(Long id);

    void save(MyUser user);
}
