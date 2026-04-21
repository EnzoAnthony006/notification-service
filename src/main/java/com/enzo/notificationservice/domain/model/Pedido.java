package com.enzo.notificationservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    private String id;
    private String cliente;
    private String produto;
    private Double valor;

}
