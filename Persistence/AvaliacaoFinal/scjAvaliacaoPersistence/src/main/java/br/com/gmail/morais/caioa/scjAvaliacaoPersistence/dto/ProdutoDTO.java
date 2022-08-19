package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto;

import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity.ProdutoEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {
    private Long id;
    private Long quantidade;
    private Double valor;
    private String nome;

    public ProdutoDTO(ProdutoEntity entity){
        this.id = entity.getIdProduto();
        this.quantidade = entity.getQuantidade();
        this.nome = entity.getNome();
        this.valor = entity.getValor();
    }
}
