package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
class HelloController {

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name) {
        return "<h1>Hello, " + name + "</h1>";
    }

//    @GetMapping("/increment/{number}")
//    public String increment(@PathVariable int number){
//        return number + " plus one is " + (number + 1);
//    }

}

