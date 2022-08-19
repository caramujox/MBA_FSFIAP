package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUpdateClienteDTO {
    private String nome;
    private Integer idade;
    private LocalDate dataNascimento;
    private String cep;
    private Integer numeroResidencia;
    private String complemento;
}
