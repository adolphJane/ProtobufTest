package com.example.protobuftest.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.logging.Logger

@RestController
class HelloController {

    @PostMapping("/hello")
    fun helloworld(@RequestParam name: String) : String{
        println(name)
        return name
    }
}