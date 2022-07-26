package com.example.hello.get.controller;


import com.example.hello.get.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path="/hello")  // http://localhost:9090/api/get/hello
    public String Hello(){
        return "get Hello";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET)  // get http://localhost:9090/api/get/hi
    public String hi() {
        return "hi";
    }


    // http://localhost:9090/api/get/pathvariable/{name}
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name ="name") String pathName){

        System.out.println("PathVariable :" + pathName);
        return pathName;
    }

    // search?q = intellij
    // &oq = int
    // &aqs = chrome.4.69i57j35i39l2j46i199i433i465i512j0i433i512j0i131i433i512j69i60l2.4738j0j9
    // &sourceid = chrome
    // &ie = UTF-8

    // ?key=value&key2=value2

    // http://localhost:9090/pai/get/query-param?user=steve&email=steve@gmail.com&age30

    @GetMapping(path= "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){


        StringBuilder sb = new StringBuilder();


        queryParam.entrySet().forEach(entry ->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+" = "+ entry.getValue() + "\n");

        });

        return sb.toString();

    }

    @GetMapping("query-param02")
    public String queryParam02(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam int age
    ){

        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name +" " + email +" "+ age;

    }

    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){

        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();

    }


}
