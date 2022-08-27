package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto;

import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity.PedidoEntity;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.repository.ClienteRepository;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.service.interfaces.ClienteService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
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
