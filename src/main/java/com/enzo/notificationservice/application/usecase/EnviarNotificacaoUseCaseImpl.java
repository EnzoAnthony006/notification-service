package com.enzo.notificationservice.application.usecase;

import com.enzo.notificationservice.domain.model.Pedido;
import com.enzo.notificationservice.infrastructure.kafka.config.PedidoProducer;
import org.springframework.stereotype.Service;

@Service
public class EnviarNotificacaoUseCaseImpl implements EnviarNotificacaoUseCase {

    private final PedidoProducer pedidoProducer;

    public EnviarNotificacaoUseCaseImpl(PedidoProducer pedidoProducer) {
        this.pedidoProducer = pedidoProducer;
    }
    @Override
    public void executar(Pedido pedido) {
        pedidoProducer.enviar(pedido);
    }

}