package com.enzo.notificationservice.adapters.controller;

import com.enzo.notificationservice.application.usecase.EnviarNotificacaoUseCase;
import com.enzo.notificationservice.domain.model.Pedido;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final EnviarNotificacaoUseCase enviarNotificacaoUseCase;

    public PedidoController(EnviarNotificacaoUseCase enviarNotificacaoUseCase) {
        this.enviarNotificacaoUseCase = enviarNotificacaoUseCase;
    }
    @PostMapping
    public ResponseEntity<String> criarPedido(@RequestBody Pedido pedido) {
        enviarNotificacaoUseCase.executar(pedido);
        return ResponseEntity.ok("Pedido recebido com sucesso!");
    }
}
