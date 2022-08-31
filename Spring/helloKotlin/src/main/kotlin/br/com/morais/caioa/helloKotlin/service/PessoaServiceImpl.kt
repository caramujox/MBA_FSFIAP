package br.com.morais.caioa.helloKotlin.service

import br.com.morais.caioa.helloKotlin.document.PessoaDocument
import br.com.morais.caioa.helloKotlin.dto.CreatePessoaDTO
import br.com.morais.caioa.helloKotlin.dto.PessoaDTO
import br.com.morais.caioa.helloKotlin.repository.PessoaRepository
import br.com.morais.caioa.helloKotlin.service.interfaces.PessoaService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PessoaServiceImpl(val pessoaRepository: PessoaRepository): PessoaService {
    override fun create(createPessoaDTO: CreatePessoaDTO)=
            Mono.just(createPessoaDTO)
                    .map { PessoaDocument(name = it.nome) }
                    .flatMap{ pessoaRepository.save(it)}
                    .map { PessoaDTO(id = it.id?:throw Exception(), nome = it.name) }


    override fun list(): Flux<PessoaDTO> = pessoaRepository.findAll().map { PessoaDTO(
            id = it.id ?: throw Exception(),
            nome = it.name
    ) }
}