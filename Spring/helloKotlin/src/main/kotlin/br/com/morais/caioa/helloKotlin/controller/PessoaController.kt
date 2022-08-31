package br.com.morais.caioa.helloKotlin.controller

import br.com.morais.caioa.helloKotlin.dto.CreatePessoaDTO
import br.com.morais.caioa.helloKotlin.dto.PessoaDTO
import br.com.morais.caioa.helloKotlin.service.interfaces.PessoaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

class PessoaController(val pessoaService: PessoaService) {

    @GetMapping
    fun list() = pessoaService.list()

    @PostMapping
    fun create(@RequestBody createPessoaDTO: CreatePessoaDTO) = pessoaService.create(createPessoaDTO)
}