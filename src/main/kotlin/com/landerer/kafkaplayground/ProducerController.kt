package com.landerer.kafkaplayground

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/producer")
class ProducerController(private val testTopicProducer: TestTopicProducer) {

    @PostMapping
    fun produceNewMessage(@RequestBody message: Message) {
        this.testTopicProducer.send(message.key, message.value)
    }
}

data class Message(val key: String, val value: String)