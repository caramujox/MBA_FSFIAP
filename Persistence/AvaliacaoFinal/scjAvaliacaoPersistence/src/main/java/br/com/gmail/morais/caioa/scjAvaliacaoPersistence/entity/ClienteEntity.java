package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name= "TB_CLIENTES")
@Data
@NoArgsConstructor
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column
    private String nome;
    private Integer idade;
    private LocalDate dataNascimento;
    private String cep;
    private Integer numeroResidencia;
    private String complemento;

    @OneToMany(mappedBy = "cliente")
    private List<PedidoEntity> pedidos;
}
