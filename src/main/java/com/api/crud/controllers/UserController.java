package com.api.crud.controllers;

import com.api.crud.Models.UsersModels;
import com.api.crud.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
@Autowired
private UserService userService;
@GetMapping
    public ArrayList<UsersModels> getUsers(){
    return this.userService.getUsers();
}
@PostMapping
    public UsersModels saveUser(@RequestBody UsersModels user){
        return this.userService.saveUser(user);
}
@GetMapping(path = "/{id}")
public Optional<UsersModels> getUserById(@PathVariable Long id){
    return this.userService.getById(id);
}

@PutMapping(path = "/{id}")
    public UsersModels updateUserById(@RequestBody UsersModels request,@PathVariable("id") Long id){
    return this.userService.updateById(request, id);
}

@DeleteMapping(path = "/{id}")
    public  String deleteById(@PathVariable("id") Long id ){
    boolean ok = this.userService.deleteUser(id);

    if(ok){
        return "Usuario con id " + id + " borrado con existo";
    }else{
        return "Error, tuvimos un problema eliminando el usuario con usuario " + id;
    }
}
}


