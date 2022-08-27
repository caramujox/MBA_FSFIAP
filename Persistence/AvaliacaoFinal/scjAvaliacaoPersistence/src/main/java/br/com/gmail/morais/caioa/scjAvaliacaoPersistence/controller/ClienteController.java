package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.controller;

import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto.ClienteDTO;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto.ClienteFilterDTO;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto.CreateUpdateClienteDTO;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.service.interfaces.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {

    private ClienteService service;

    @GetMapping
    public List<ClienteDTO> list(ClienteFilterDTO clienteFilterDTO) {
        return service.listAll(clienteFilterDTO.getNome());
    }

    @GetMapping("{id}")
    public ClienteDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO create(@RequestBody CreateUpdateClienteDTO createUpdateClienteDTO) {
        return service.create(createUpdateClienteDTO
        );
    }

    @PutMapping("{id}")
    public ClienteDTO update(@PathVariable Long id, @RequestBody CreateUpdateClienteDTO createUpdateClienteDTO) {
        return service.updateClienteDTO(id, createUpdateClienteDTO
        );
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id)
    {
        service.delete(id);
    }
}
