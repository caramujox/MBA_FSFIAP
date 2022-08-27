package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoPedidoDTO {
    private Long idProduto;
    private Long quantidade;
}
