package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name= "TB_CLIENTES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteEntity implements Serializable {

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

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<PedidoEntity> pedidos;
}
