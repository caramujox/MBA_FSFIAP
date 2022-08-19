package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto;

import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity.ClienteEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class ClienteDTO {
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cep;
    private Integer numeroResidencia;
    private String complmento;

    public ClienteDTO(ClienteEntity entity) {
        this.id = entity.getIdCliente();
        this.cep = entity.getCep();
        this.complmento = entity.getComplemento();
        this.numeroResidencia = entity.getNumeroResidencia();
        this.dataNascimento = entity.getDataNascimento();
        this.nome = entity.getNome();
    }
}
