package com.enzo.notificationservice.infrastructure.kafka.config;

import com.enzo.notificationservice.domain.model.Pedido;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PedidoProducer {

    private static final String TOPICO = "pedidos";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public PedidoProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void enviar(Pedido pedido) {
        String mensagem =  "Cliente: " + pedido.getCliente() +
                " | Produto: " + pedido.getProduto() +
                " | Valor: R$" + pedido.getValor();

        kafkaTemplate.send(TOPICO, pedido.getId(), mensagem);
        System.out.println("Enviando pedido com sucesso!");
    }
}
