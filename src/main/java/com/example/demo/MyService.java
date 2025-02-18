package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MyService {
    @Autowired
    private MyRepository myRepository;

    public void saveCourse(MyModel model) {
        model.setDate(LocalDateTime.now());
        myRepository.save(model);
    }

    public List<MyModel> getAllStudents(){

        return  myRepository.findAll();
    }


}
