package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "TB_PEDIDOS")
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @ManyToMany(mappedBy = "pedido")
    private List<ProdutoEntity> produtos;
}
