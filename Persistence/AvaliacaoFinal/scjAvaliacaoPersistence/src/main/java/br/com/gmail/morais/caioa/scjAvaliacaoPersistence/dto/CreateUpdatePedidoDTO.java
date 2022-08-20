package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdatePedidoDTO {
    private String nome;
    private Double valorPedido;
    private LocalDate dataPedido;
    private Long idCliente;
}
