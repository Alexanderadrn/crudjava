package com.api.crud.Services;

import com.api.crud.Models.UsersModels;
import com.api.crud.Repositories.IUserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepositorie userRepository;

    public ArrayList<UsersModels> getUsers(){
        return (ArrayList<UsersModels>) userRepository.findAll();
    }
    public UsersModels saveUser(UsersModels user){
        return userRepository.save(user);
    }

    public Optional<UsersModels> getById(Long id){
        return userRepository.findById(id);
    }
    public UsersModels updateById(UsersModels request, Long id){
        UsersModels user = userRepository.findById(id).get();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        userRepository.save(user);
        return user;
    }

    public boolean deleteUser (Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

}
