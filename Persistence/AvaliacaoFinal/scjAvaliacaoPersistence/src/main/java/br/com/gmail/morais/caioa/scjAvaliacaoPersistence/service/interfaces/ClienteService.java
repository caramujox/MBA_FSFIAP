package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.service.interfaces;

import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto.ClienteDTO;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto.CreateUpdateClienteDTO;

import java.util.List;

public interface ClienteService {

    ClienteDTO create(CreateUpdateClienteDTO createUpdateClienteDTO);

    ClienteDTO findById(Long id);
    List<ClienteDTO> listAll(String name);
    ClienteDTO updateClienteDTO(Long id, CreateUpdateClienteDTO createUpdateClienteDTO);
    void delete (Long id);
}
