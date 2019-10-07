package com.spring.practice.config;

import com.spring.practice.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class MapConfig {
    @Bean
    public Map<String, Student> studentMap() {
        return new HashMap<>();
    }

    @Bean
    public List<Student> studentList(){
        return new ArrayList<>();
    }
}
