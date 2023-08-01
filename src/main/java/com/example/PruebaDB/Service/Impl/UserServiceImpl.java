package com.example.PruebaDB.Service.Impl;

import com.example.PruebaDB.Service.UserService;
import com.example.PruebaDB.model.User;
import com.example.PruebaDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repositorio;

    public List<User> ListarUsers(){
        return repositorio.findAll();
    }

    public void GuardarUser(User usuario){
        repositorio.save(usuario);
    }

    public User GetUser(Integer id){
        return repositorio.findById(id).get();
    }

    public void DeleteUser(Integer id){
        repositorio.deleteById(id);
    }
}
