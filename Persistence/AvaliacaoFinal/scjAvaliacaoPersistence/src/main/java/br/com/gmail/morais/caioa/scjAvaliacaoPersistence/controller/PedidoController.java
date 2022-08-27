package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.controller;

import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto.*;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.service.interfaces.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@AllArgsConstructor
public class PedidoController {

    private PedidoService service;

    @GetMapping
    public List<PedidoDTO> list(PedidoFilterDTO clienteFilterDTO) {
        return service.listAll(clienteFilterDTO.getIdCliente());
    }

    @GetMapping("{id}")
    public PedidoDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoDTO create(@RequestBody CreateUpdatePedidoDTO createUpdatePedidoDTO) {
        return service.create(createUpdatePedidoDTO);
    }

    @PutMapping("{id}")
    public PedidoDTO update(@PathVariable Long id, @RequestBody CreateUpdatePedidoDTO createUpdatePedidoDTO) {
        return service.updatePedidoDTO(id, createUpdatePedidoDTO);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id)
    {
        service.delete(id);
    }

}
