package br.com.morais.caioa.helloKotlin.service.interfaces

import br.com.morais.caioa.helloKotlin.dto.CreatePessoaDTO
import br.com.morais.caioa.helloKotlin.dto.PessoaDTO
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PessoaService {
    fun create(CreatePessoaDto: CreatePessoaDTO): Mono<PessoaDTO>

    fun list(): Flux<PessoaDTO>
}