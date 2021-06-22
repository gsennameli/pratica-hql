package com.example.praticahql.services;

import com.example.praticahql.dtos.UserPasswordDTO;
import com.example.praticahql.models.User;
import com.example.praticahql.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User updateUserPassword(UserPasswordDTO userPasswordDTO){
        userRepository.updateUserPassword(userPasswordDTO);
        return userRepository.findById(userPasswordDTO.getId()).orElse(null);
    }

    public String removeUser(Long id){
        userRepository.deleteById(id);
        return "Usuario removido";
    }

    public List<User> findByNameContains(String nameSubstring){
        return userRepository.findByNameContains(nameSubstring);
    }
}
