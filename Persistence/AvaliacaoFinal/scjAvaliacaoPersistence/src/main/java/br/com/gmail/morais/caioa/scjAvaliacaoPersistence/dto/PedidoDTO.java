package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto;

import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity.PedidoEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PedidoDTO {
    private Long id;
    private Double valor;
    private LocalDate data;
    private Long idCliente;

    public PedidoDTO(PedidoEntity entity){
        this.id = entity.getIdPedido();
        this.idCliente = entity.getCliente().getIdCliente();
        this.valor = entity.getValorPedido();
        this.data = entity.getDataPedido();
    }
}
