package com.example.PruebaDB.repository;

import com.example.PruebaDB.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
