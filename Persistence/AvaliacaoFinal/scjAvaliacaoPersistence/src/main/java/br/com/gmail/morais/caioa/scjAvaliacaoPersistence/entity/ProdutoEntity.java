package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TB_PRODUTOS")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProdutoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;
    @Column
    private String nome;
    private Long quantidade;
    private Double valor;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "produtos", fetch = FetchType.LAZY)
    private List<PedidoEntity> pedidos;
}
