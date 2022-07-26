package com.example.hello.aop.controller;


import com.example.hello.annotation.Decode;
import com.example.hello.annotation.Timer;
import com.example.hello.aop.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api01")
public class RestApiController02 {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name){
        return id + " " + name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user){

        return user;

    }
    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {
        //db logic
        Thread.sleep( 1000 * 2);
    }
    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user) {

        System.out.println("put");
        System.out.println(user);
        return user;
    }


}
