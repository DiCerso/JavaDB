package com.example.PruebaDB.Service;

import com.example.PruebaDB.model.User;
import com.example.PruebaDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {
    public List<User> ListarUsers();

    public void GuardarUser(User usuario);

    public User GetUser(Integer id);

    public void DeleteUser(Integer id);
}
