package com.landerer.kafkaplayground

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.kafka.annotation.EnableKafka

@SpringBootApplication
@EnableKafka
class Main

fun main(args: Array<String>) {
    SpringApplication.run(Main::class.java, *args)
}