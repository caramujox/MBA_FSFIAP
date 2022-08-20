package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdateProdutoDTO {
    private Long quantidade;
    private Double valor;
    private String nome;
}
