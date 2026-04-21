package com.enzo.notificationservice.application.usecase;

import com.enzo.notificationservice.domain.model.Pedido;

public interface EnviarNotificacaoUseCase {

    void executar(Pedido pedido);

}