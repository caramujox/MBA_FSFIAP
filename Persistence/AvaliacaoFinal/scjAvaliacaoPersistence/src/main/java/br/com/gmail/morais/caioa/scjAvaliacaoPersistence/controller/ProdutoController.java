package br.com.gmail.morais.caioa.scjAvaliacaoPersistence.controller;

import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.dto.*;
import br.com.gmail.morais.caioa.scjAvaliacaoPersistence.service.interfaces.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
public class ProdutoController {

    private ProdutoService service;

    @GetMapping
    public List<ProdutoDTO> list(ProdutoFilterDTO produtoFilterDTO) {
        return service.listAll(produtoFilterDTO.getNome());
    }

    @GetMapping("{id}")
    public ProdutoDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoDTO create(@RequestBody CreateUpdateProdutoDTO createUpdateProdutoDTO) {
        return service.create(createUpdateProdutoDTO
        );
    }

    @PutMapping("{id}")
    public ProdutoDTO update(@PathVariable Long id, @RequestBody CreateUpdateProdutoDTO createUpdateProdutoDTO) {
        return service.updateProdutoDTO(id, createUpdateProdutoDTO);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id)
    {
        service.delete(id);
    }
}
