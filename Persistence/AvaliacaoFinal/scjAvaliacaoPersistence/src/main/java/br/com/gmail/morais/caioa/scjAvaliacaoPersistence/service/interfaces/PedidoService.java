package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.service.interfaces;


import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto.CreateUpdatePedidoDTO;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto.PedidoDTO;
import java.util.List;


public interface PedidoService {

    PedidoDTO create(CreateUpdatePedidoDTO createUpdatePedidoDTO);

    PedidoDTO findById(Long id);
    List<PedidoDTO> listAll(Long idCliente);
    PedidoDTO updatePedidoDTO(Long id, CreateUpdatePedidoDTO createUpdatePedidoDTO);
    void delete (Long id);
}
