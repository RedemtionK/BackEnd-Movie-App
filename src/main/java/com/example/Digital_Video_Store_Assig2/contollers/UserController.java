package com.example.Digital_Video_Store_Assig2.contollers;

import com.example.Digital_Video_Store_Assig2.CustomizedResponse;
import com.example.Digital_Video_Store_Assig2.models.UserModel;
import com.example.Digital_Video_Store_Assig2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity getUsers(){
        var response = new CustomizedResponse("A list of all users" ,userService.getUsers());
        return  new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity getUser(@PathVariable("id") String id)
    {
        CustomizedResponse response = null;
        try {
            response = new CustomizedResponse("User with Id : "+id , Collections.singletonList(userService.getAUser(id)));
        } catch (Exception e) {
            response = new CustomizedResponse(e.getMessage(),null);
            return  new ResponseEntity(response, HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity(response, HttpStatus.OK);
    }

    @PostMapping(value = "/users",consumes ={
            MediaType.APPLICATION_JSON_VALUE

    })
    public  ResponseEntity createUser(@RequestBody UserModel user){
        CustomizedResponse response = null;
        try {
            response = new CustomizedResponse("User created successfully: "+user.getId(), Collections.singletonList(userService.addUser(user)));
        } catch (Exception e) {
            response = new CustomizedResponse(e.getMessage(),null);
            return  new ResponseEntity(response, HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity(response, HttpStatus.OK);
    }
}
