package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.service;

import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto.CreateUpdatePedidoDTO;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto.PedidoDTO;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity.ClienteEntity;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity.PedidoEntity;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity.ProdutoEntity;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.repository.ClienteRepository;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.repository.PedidoRepository;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.repository.ProdutoRepository;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.service.interfaces.PedidoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private PedidoRepository pedidoRepository;
    private ClienteRepository clienteRepository;
    private ProdutoRepository produtoRepository;
    private ObjectMapper objectMapper;
    @Override
    public PedidoDTO create(CreateUpdatePedidoDTO createUpdatePedidoDTO) {
        ClienteEntity cliente = clienteRepository.findById(createUpdatePedidoDTO.getIdCliente())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<ProdutoEntity> produtos = new ArrayList<>();

        PedidoEntity entity = PedidoEntity.builder()
                .dataPedido(LocalDate.now())
                .cliente(cliente)
                .produtos(produtos)
                .valorPedido(createUpdatePedidoDTO.getValorPedido())
                .build();
        PedidoEntity savedEntity = pedidoRepository.save(entity);
        return new PedidoDTO(savedEntity);
    }

    @Override
    public PedidoDTO findById(Long id) {
        PedidoEntity entity = pedidoRepository.findById(id).orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return objectMapper.convertValue(entity, PedidoDTO.class);
    }

    @Override
    public List<PedidoDTO> listAll(Long idCliente) {
        List<PedidoEntity> list;
        if(idCliente == null)
            list = pedidoRepository.findAll();
        else
            list = pedidoRepository.findAllByClienteContaining(idCliente);
        return list.stream().map(PedidoDTO::new).toList();
    }

    @Override
    public PedidoDTO updatePedidoDTO(Long id, CreateUpdatePedidoDTO createUpdatePedidoDTO) {
        PedidoEntity entity = pedidoRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        entity.setDataPedido(createUpdatePedidoDTO.getDataPedido());
        entity.setValorPedido(createUpdatePedidoDTO.getValorPedido());
        return new PedidoDTO(entity);
    }

    @Override
    public void delete(Long id) {
        PedidoEntity entity = pedidoRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        pedidoRepository.delete(entity);
    }
}
