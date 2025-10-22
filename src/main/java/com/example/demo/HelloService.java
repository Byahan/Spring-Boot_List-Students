package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    
    public List<String> getUsers(){
        return List.of("Ahmad", "Budi", "Chandra");
    }
}
