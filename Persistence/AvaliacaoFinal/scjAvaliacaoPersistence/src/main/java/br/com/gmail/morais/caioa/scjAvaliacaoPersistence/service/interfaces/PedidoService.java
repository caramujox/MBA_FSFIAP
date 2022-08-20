package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.service.interfaces;


import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto.CreateUpdatePedidoDTO;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto.PedidoDTO;
import java.util.List;


public interface PedidoService {

    PedidoDTO create(CreateUpdatePedidoDTO createUpdateClienteDTO);

    PedidoDTO findById(Long id);
    List<PedidoDTO> listAll(String name);
    PedidoDTO updateClienteDTO(Long id, CreateUpdatePedidoDTO createUpdateClienteDTO);
    void delete (Long id);
}
