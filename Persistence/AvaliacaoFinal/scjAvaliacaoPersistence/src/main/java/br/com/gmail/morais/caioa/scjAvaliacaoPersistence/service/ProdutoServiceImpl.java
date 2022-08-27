package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.service;

import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto.CreateUpdateProdutoDTO;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto.ProdutoDTO;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity.ProdutoEntity;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.repository.ProdutoRepository;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.service.interfaces.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoRepository repository;
    private ObjectMapper objectMapper;
    @Override
    public ProdutoDTO create(CreateUpdateProdutoDTO createUpdateProdutoDTO) {
        ProdutoEntity savedEntity = repository.save(objectMapper.convertValue(createUpdateProdutoDTO, ProdutoEntity.class));
        return new ProdutoDTO(savedEntity);
    }

    @Override
    public ProdutoDTO findById(Long id) {
        ProdutoEntity entity = repository
                .findById(id).orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
        return objectMapper.convertValue(entity, ProdutoDTO.class);
    }

    @Override
    public List<ProdutoDTO> listAll(String name) {
        List<ProdutoEntity> list;
        if(name == null)
            list = repository.findAll();
        else
            list = repository.findAllByNomeContaining(name);
        return list.stream().map(ProdutoDTO::new).toList();
    }

    @Override
    public ProdutoDTO updateProdutoDTO(Long id, CreateUpdateProdutoDTO createUpdateProdutoDTO) {
        ProdutoEntity entity = repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        entity.setNome(createUpdateProdutoDTO.getNome());
        entity.setQuantidade(createUpdateProdutoDTO.getQuantidade());
        entity.setValor(createUpdateProdutoDTO.getValor());
        return new ProdutoDTO(entity);
    }

    @Override
    public void delete(Long id) {
        ProdutoEntity entity = repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        repository.delete(entity);
    }
}
