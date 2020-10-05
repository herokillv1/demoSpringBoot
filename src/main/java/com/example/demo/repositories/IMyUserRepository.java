package com.example.demo.repositories;

import com.example.demo.models.MyUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;

@Qualifier("myUserRepository")
public interface IMyUserRepository extends CrudRepository<MyUser, Long> {
    MyUser findByUsername(String username);
}
