package com.spring.practice.controller;

import com.spring.practice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class StudentController {
    @Autowired
    private Map<String, Student> studentMap;

    @Autowired
    private List<Student> studentList;

    @PostMapping(value = "/add/student", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addStudent(@RequestBody Student student) {
        if (studentMap.containsKey(student.getId())) {
            return "false";
        }
        studentList.add(student);
        return "true";
    }

    @GetMapping(value = "/get/all", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getAll(){

        return this.studentList;
    }

    @GetMapping(value = "/delete/all", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteStudents(){
        studentList.clear();
        int retval = studentList.size();
        if(retval==0){
            return "true";
        }else{
            return "false";
        }
    }

    @PostMapping(value="/delete/student/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteStudent(@PathVariable String id)
    {
        studentList.remove(id);
        return ResponseEntity.noContent().build();


    }
}
