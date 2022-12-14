package com.example.Digital_Video_Store_Assig2.contollers;

import com.example.Digital_Video_Store_Assig2.CustomizedResponse;
import com.example.Digital_Video_Store_Assig2.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins={"http://localhost:3000","https://movie-app-klaus.herokuapp.com/"})
@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping(value = "/auth",consumes ={
            MediaType.APPLICATION_JSON_VALUE

    })
    public ResponseEntity logIn(@RequestBody UserModel user){

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
            var response = new CustomizedResponse("You Logged In Successfully", null);
            return  new ResponseEntity(response, HttpStatus.OK);

        }catch (BadCredentialsException ex) {
            var response = new CustomizedResponse("You  username/password were entered incorrectly.", null);
            return  new ResponseEntity(response, HttpStatus.UNAUTHORIZED);
        }

    }
}
