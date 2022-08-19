package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_PRODUTOS")
@NoArgsConstructor
@Data
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;
    @Column
    private String nome;
    private Long quantidade;
    private Double valor;

    @ManyToMany(mappedBy = "produtos", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PedidoEntity> pedidos;
}
