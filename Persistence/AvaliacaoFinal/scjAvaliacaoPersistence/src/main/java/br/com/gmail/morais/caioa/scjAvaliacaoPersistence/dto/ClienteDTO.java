package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto;

import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity.ClienteEntity;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO implements Serializable {
    private Long idCliente;
    private String nome;
    private LocalDate dataNascimento;
    private String cep;
    private Integer numeroResidencia, idade;
    private String complmento;

    public ClienteDTO(ClienteEntity entity) {
        this.idCliente = entity.getIdCliente();
        this.cep = entity.getCep();
        this.complmento = entity.getComplemento();
        this.numeroResidencia = entity.getNumeroResidencia();
        this.dataNascimento = entity.getDataNascimento();
        this.idade = entity.getIdade();
        this.nome = entity.getNome();
    }
}
