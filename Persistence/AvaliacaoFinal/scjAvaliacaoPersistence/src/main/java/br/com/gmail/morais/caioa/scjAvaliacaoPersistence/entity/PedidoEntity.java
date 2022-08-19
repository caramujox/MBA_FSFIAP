package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "TB_PEDIDOS")
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    private Double valorPedido;
    private LocalDate dataPedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "produto_pedido",
            joinColumns = {
                    @JoinColumn(name = "id_pedido")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id_produto")
            }
    )
    private List<ProdutoEntity> produtos;
}
