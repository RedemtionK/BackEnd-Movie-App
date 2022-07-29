package com.example.Digital_Video_Store_Assig2.services;

import com.example.Digital_Video_Store_Assig2.models.MovieModel;
import com.example.Digital_Video_Store_Assig2.models.UserModel;
import com.example.Digital_Video_Store_Assig2.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserModel addUser(UserModel user) throws Exception {
        if(user.getEmail().isEmpty()||user.getFirstName().isEmpty()||user.getPassword().isEmpty()||user.getLastName().isEmpty()){
            throw new Exception("The information Entered is incorrect");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        UserModel insertedUser = userRepository.insert(user);

        return insertedUser;
    }

    public List<UserModel> getUsers()
    {
        return userRepository.findAll();
    }
    public Optional<UserModel> getAUser(String id) throws Exception {
        if(id.length()<22||id.contains("!")||id.contains("@")||id.contains("#")||id.contains("$")||id.contains("%")||id.contains("^")||id.contains("&")||id.contains("*")||id.contains("(")||id.contains(")")||id.contains("-")
                ||id.contains("_")||id.contains("+")||id.contains("=")||id.contains(";")||id.contains(":")||id.contains("'")
                ||id.contains("<")||id.contains(">")||id.contains(",")||id.contains(".")||id.contains("/")||id.contains("?")
                ||id.contains("|")||id.contains("~")||id.contains("`")){
            throw  new Exception("Entered Id is not Valid");
        }
        Optional<UserModel> user = userRepository.findById(id);
        if (!user.isPresent()){
            throw  new Exception("User with id: "+id+" is not found");
        }
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserModel foundUser = userRepository.findByEmail(email);
        String email1 =foundUser.getEmail();
        String password = foundUser.getPassword();

        return  new User(email1,password,new ArrayList<>());

    }
}
