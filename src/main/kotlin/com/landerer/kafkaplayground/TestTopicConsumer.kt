package com.landerer.kafkaplayground

import com.landerer.kafkaplayground.avro.TestAvroMessage
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

private val LOGGER = LoggerFactory.getLogger(TestTopicConsumer::class.java)

@Service
class TestTopicConsumer {

    @KafkaListener(
        id = "kafka-playground-consumer-group-1",
        topics = ["avro_topic"],
        groupId = "kafka-playground-consumer-group-1")
    fun listen(record: ConsumerRecord<String, TestAvroMessage>) {
        val avroMessage = record.value()
        KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG
        LOGGER.info("Received message: ${avroMessage.value} with key: ${record.key()}")
    }
}