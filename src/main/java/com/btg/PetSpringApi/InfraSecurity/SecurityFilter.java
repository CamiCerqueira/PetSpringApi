package com.btg.PetSpringApi.InfraSecurity;

import com.btg.PetSpringApi.repository.ICustomer;
import com.btg.PetSpringApi.repository.IUserEmployee;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    @Autowired
    ICustomer customerRepository;
    //IUserEmployee userEmployeeRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token =  getToken(request);
        if(token != null){
            String subject = tokenService.getSubject(token);
            authenticate(subject);
        }

        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if(token == null || !token.startsWith("Bearer ")){
            return null;
        }
        return token.substring(7);
    }

    private void authenticate(String subject) {
        UserDetails customer = customerRepository.findByEmail(subject);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(customer, null, customer.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

       // UserDetails userEmployee = userEmployeeRepository.findByEmail(subject);
       // UsernamePasswordAuthenticationToken authenticationTokenUserEmployee = new UsernamePasswordAuthenticationToken(userEmployee, null, userEmployee.getAuthorities());
       // SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }
}