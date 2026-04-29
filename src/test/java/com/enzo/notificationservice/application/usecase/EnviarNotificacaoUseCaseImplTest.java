package com.enzo.notificationservice.application.usecase;

import com.enzo.notificationservice.domain.model.Pedido;
import com.enzo.notificationservice.infrastructure.kafka.config.PedidoProducer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EnviarNotificacaoUseCaseImplTest {

    @Mock
    private PedidoProducer pedidoProducer;

    @InjectMocks
    private EnviarNotificacaoUseCaseImpl useCase;

    @Test
    @DisplayName("Deve chamar o producer ao executar o caso de uso")
    void executar_DeveEnviarPedidoAoProducer() {
        Pedido pedido = new Pedido("1", "Enzo", "Notebook", 4500.00);

        useCase.executar(pedido);

        verify(pedidoProducer, times(1)).enviar(pedido);
    }
}