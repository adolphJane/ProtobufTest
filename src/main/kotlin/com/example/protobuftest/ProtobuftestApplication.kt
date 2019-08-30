package com.example.protobuftest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class ProtobuftestApplication

fun main(args: Array<String>) {
    runApplication<ProtobuftestApplication>(*args)
}
