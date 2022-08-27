package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.service;

import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto.*;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity.ClienteEntity;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity.PedidoEntity;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity.ProdutoEntity;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.repository.PedidoRepository;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.service.interfaces.ClienteService;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.service.interfaces.PedidoService;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.service.interfaces.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private PedidoRepository pedidoRepository;
    private ClienteService clienteService;
    private ProdutoService produtoService;
    private ObjectMapper objectMapper;

    @Override
    @CacheEvict(cacheNames = "pedido", allEntries = true)
    public PedidoDTO create(CreateUpdatePedidoDTO createUpdatePedidoDTO) {
        ClienteEntity cliente = mapClienteDTO(clienteService.findById(createUpdatePedidoDTO.getIdCliente()));
        List<ProdutoEntity> produtos = createUpdatePedidoDTO.getProdutos().stream().map(
                this::mapProdutoPedidoDTO
        ).collect(Collectors.toList());
//        List<ProdutoEntity> produtos = new ArrayList<>();
        PedidoEntity entity = PedidoEntity.builder()
                .dataPedido(LocalDate.now())
                .cliente(cliente)
                .produtos(produtos)
                .valorPedido(calculaValorPedido(createUpdatePedidoDTO.getProdutos()))
                .build();
        PedidoEntity savedEntity = pedidoRepository.save(entity);
        return new PedidoDTO(savedEntity);
    }

    @Override
    @Cacheable(cacheNames = "pedido", key = "#id", unless = "#result == null")
    public PedidoDTO findById(Long id) {
        PedidoEntity entity = pedidoRepository.findById(id).orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return objectMapper.convertValue(entity, PedidoDTO.class);
    }

    @Override
    @Cacheable(cacheNames = "pedido")
    public List<PedidoDTO> listAll(Long idCliente) {
        List<PedidoEntity> list;
        if(idCliente == null)
            list = pedidoRepository.findAll();
        else
            list = pedidoRepository.findAllByClienteContaining(idCliente);
        return list.stream().map(PedidoDTO::new).toList();
    }

    @Override
    @CacheEvict(cacheNames = "pedido", allEntries = true)
    public PedidoDTO updatePedidoDTO(Long id, CreateUpdatePedidoDTO createUpdatePedidoDTO) {
        PedidoEntity entity = pedidoRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        entity.setDataPedido(createUpdatePedidoDTO.getDataPedido());
//        entity.setValorPedido(createUpdatePedidoDTO.getValorPedido());
        return new PedidoDTO(entity);
    }

    @Override
    @Caching(evict = { @CacheEvict(cacheNames = "pedido", key = "#id"),
            @CacheEvict(cacheNames = "pedido", allEntries = true) })
    public void delete(Long id) {
        PedidoEntity entity = pedidoRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        pedidoRepository.delete(entity);
    }


    //Metodos Privados

    private ClienteEntity mapClienteDTO(ClienteDTO dto){
        return ClienteEntity.builder()
                .idCliente(dto.getIdCliente())
                .cep(dto.getCep())
                .complemento(dto.getComplmento())
                .numeroResidencia(dto.getNumeroResidencia())
                .dataNascimento(dto.getDataNascimento())
                .idade(dto.getIdade())
                .nome(dto.getNome())
                .build();
    }
    private ProdutoEntity mapProdutoPedidoDTO(ProdutoPedidoDTO dto){
        ProdutoDTO produto = produtoService.findById(dto.getIdProduto());
        return ProdutoEntity.builder()
                .idProduto(dto.getIdProduto())
                .quantidade(dto.getQuantidade())
                .nome(produto.getNome())
                .valor(produto.getValor())
                .build();
    }

    private Double calculaValorPedido(List<ProdutoPedidoDTO> dto){
        Double valor = dto.stream().mapToDouble(produto -> {
            return produtoService.findById(produto.getIdProduto()).getValor() * produto.getQuantidade();
        }).sum();
        return valor;
    }
}
