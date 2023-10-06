package com.btg.PetSpringApi.controller;

import com.btg.PetSpringApi.controller.dto.LoginRequest;
import com.btg.PetSpringApi.controller.dto.TokenResponse;
import com.btg.PetSpringApi.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.token.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid LoginRequest loginRequest){

        var authenticate = new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );

        var authentication = authenticationManager.authenticate(authenticate);
        var token = tokenService.tokenGenerate((Customer) authentication.getPrincipal());

        return ResponseEntity.ok().body(new TokenResponse(token));
    }
}
