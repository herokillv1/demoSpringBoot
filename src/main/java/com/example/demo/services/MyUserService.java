package com.example.demo.services;

import com.example.demo.models.MyUser;
import com.example.demo.models.Role;
import com.example.demo.repositories.IMyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyUserService implements IMyUserService, UserDetailsService {

    @Autowired
    private IMyUserRepository myUserRepository;

    @Override
    public List<MyUser> getUserList() {
        return (List<MyUser>) myUserRepository.findAll();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MyUser myUser = myUserRepository.findByUsername(username);
        List<Role> myRole = new ArrayList<Role>();
        myRole.add(myUser.getRole());

        User user = new User(myUser.getUsername(), myUser.getPassword(), myRole);
        return user;
    }

    @Override
    public MyUser findById(Long id) {
        return  myUserRepository.findById(id).orElse(null);
    }

    @Override
    public void save(MyUser user) {
        myUserRepository.save(user);
    }
}
