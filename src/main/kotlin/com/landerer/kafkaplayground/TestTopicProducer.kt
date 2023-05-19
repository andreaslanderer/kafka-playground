package com.landerer.kafkaplayground

import com.landerer.kafkaplayground.avro.TestAvroMessage
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

private const val TOPIC = "avro_topic"
private val LOGGER = LoggerFactory.getLogger(TestTopicProducer::class.java)

@Service
class TestTopicProducer(private val kafkaTemplate: KafkaTemplate<String, TestAvroMessage>) {

    fun send(key: String, message: String, luckyNumber: Long) {
        LOGGER.info("Sending message: $message with key: $key to topic: $TOPIC")
        kafkaTemplate.send(TOPIC, key, TestAvroMessage(message, luckyNumber))
    }
}