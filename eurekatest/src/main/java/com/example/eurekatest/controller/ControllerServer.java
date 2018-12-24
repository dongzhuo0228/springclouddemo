package com.example.eurekatest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/text")
public class ControllerServer {

    @RequestMapping("/msg")
    public List test(){
        List list  = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        return list;
    }

}
