package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.service;

import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto.ClienteDTO;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto.CreateUpdateClienteDTO;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.entity.ClienteEntity;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.repository.ClienteRepository;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.service.interfaces.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;
    private ObjectMapper objectMapper;

    @CacheEvict(cacheNames = "cliente", allEntries = true)
    public ClienteDTO create(CreateUpdateClienteDTO createUpdateClienteDTO) {
        ClienteEntity savedEntity = clienteRepository.save(objectMapper.convertValue(createUpdateClienteDTO, ClienteEntity.class));
        return new ClienteDTO(savedEntity);
    }

    @Cacheable(cacheNames = "cliente", key = "#id", unless = "#result == null")
    public ClienteDTO findById(Long id) {
        ClienteEntity entity = clienteRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return objectMapper.convertValue(entity, ClienteDTO.class);
    }

    @Cacheable(cacheNames = "cliente")
    public List<ClienteDTO> listAll(String name) {
        List<ClienteEntity> list;
        if(name == null)
            list = clienteRepository.findAll();
        else
            list = clienteRepository.findAllByNomeContaining(name);
        return list.stream().map(ClienteDTO::new).toList();
    }

    @CacheEvict(cacheNames = "cliente", allEntries = true)
    public ClienteDTO updateClienteDTO(Long id, CreateUpdateClienteDTO createUpdateClienteDTO) {
        ClienteEntity entity = clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        entity.setNome(createUpdateClienteDTO.getNome());
        entity.setCep(createUpdateClienteDTO.getCep());
        entity.setIdade(createUpdateClienteDTO.getIdade());
        entity.setComplemento(createUpdateClienteDTO.getComplemento());
        entity.setDataNascimento(createUpdateClienteDTO.getDataNascimento());
        entity.setNumeroResidencia(createUpdateClienteDTO.getNumeroResidencia());
        return new ClienteDTO(entity);
    }

    @Caching(evict = { @CacheEvict(cacheNames = "cliente", key = "#id"),
            @CacheEvict(cacheNames = "cliente", allEntries = true) })
    public void delete(Long id) {
        ClienteEntity entity = clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        clienteRepository.delete(entity);
    }
}
