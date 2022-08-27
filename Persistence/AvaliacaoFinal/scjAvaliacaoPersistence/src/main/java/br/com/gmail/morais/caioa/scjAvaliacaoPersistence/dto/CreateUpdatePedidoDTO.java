package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdatePedidoDTO {
    private String nome;
    private LocalDate dataPedido;
    private Long idCliente;
    private List<ProdutoPedidoDTO> produtos;
}
