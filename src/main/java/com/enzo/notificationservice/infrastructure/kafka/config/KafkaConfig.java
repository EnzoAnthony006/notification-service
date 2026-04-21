package com.enzo.notificationservice.infrastructure.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic topicosPedidos() {
        return new NewTopic("pedidos", 1, (short) 1);
    }
}
