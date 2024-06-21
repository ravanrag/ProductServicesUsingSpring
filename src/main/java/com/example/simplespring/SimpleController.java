package com.example.simplespring;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/samples")
public class SimpleController {
    @GetMapping("/Hello")
    public String sun(){
        return "now changed";
    }
    @GetMapping("/no/{name}/{last}")
    public String no(@PathVariable String name, @PathVariable String last){
        String name1 = last+","+name ;
        return name1;
    }

}
