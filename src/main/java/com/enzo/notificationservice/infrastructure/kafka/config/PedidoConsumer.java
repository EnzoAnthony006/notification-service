package com.enzo.notificationservice.infrastructure.kafka.config;

import com.enzo.notificationservice.domain.model.Pedido;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PedidoConsumer {

    @KafkaListener ( topics = "pedidos" , groupId = "notification-group")
    public void consumir(String mensagem ) {
        System.out.println("Notificação Recebida: " + mensagem);
    }
}
