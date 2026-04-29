package com.enzo.notificationservice.infrastructure.kafka;

import com.enzo.notificationservice.domain.model.Pedido;
import com.enzo.notificationservice.infrastructure.kafka.config.PedidoProducer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PedidoProducerTest {

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @InjectMocks
    private PedidoProducer pedidoProducer;

    @Test
    @DisplayName("Deve enviar mensagem ao Kafka ao receber um pedido")
    void enviar_DevePublicarMensagemNoKafka() {
        Pedido pedido = new Pedido("1", "Enzo", "Notebook", 4500.00);

        pedidoProducer.enviar(pedido);

        verify(kafkaTemplate, times(1)).send(
                "pedidos",
                "1",
                "Cliente: Enzo | Produto: Notebook | Valor: R$4500.0"
        );
    }
}