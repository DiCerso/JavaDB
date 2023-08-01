package com.example.PruebaDB.Controller;

import com.example.PruebaDB.Service.Impl.UserServiceImpl;
import com.example.PruebaDB.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl servicio;

    @GetMapping("/Users")
    public List<User> ListarUsers(){
        return servicio.ListarUsers();
    }

    @GetMapping("/Users/{id}")
    public ResponseEntity<User> GetUser(@PathVariable Integer id){
        try {
            User usuario = servicio.GetUser(id);
            return new ResponseEntity<User>(usuario,HttpStatus.ACCEPTED);
        }catch(Exception exception){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/Users")
    public ResponseEntity<User> CreateUser(@RequestBody User user){
        try {
            servicio.GuardarUser(user);
            return new ResponseEntity<User>(HttpStatus.ACCEPTED);
        }catch (Exception exception){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/Users/{id}")
    public ResponseEntity<?> ActualizarUser(@RequestBody User user, @PathVariable Integer id){
        try {
            User usuario = servicio.GetUser(id);//busco el usuario
            usuario.setName(user.getName());
            usuario.setLastname(user.getLastname()); //cambio los datos viejos por los nuevos
            servicio.GuardarUser(usuario);//guardo el usuario devuelta
            return new ResponseEntity<User>(usuario,HttpStatus.ACCEPTED);
        }catch (Exception exception){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/Users/{id}")
    public ResponseEntity<?> DeleteUser(@PathVariable Integer id){
        try {
            User usuario = servicio.GetUser(id);
            if(usuario != null){
                servicio.DeleteUser(id);
            }
            return new ResponseEntity<User>(HttpStatus.ACCEPTED);
        }catch (Exception exception){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }


}
