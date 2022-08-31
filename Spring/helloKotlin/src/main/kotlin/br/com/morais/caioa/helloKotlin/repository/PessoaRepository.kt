package br.com.morais.caioa.helloKotlin.repository

import br.com.morais.caioa.helloKotlin.document.PessoaDocument
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface PessoaRepository: ReactiveCrudRepository<PessoaDocument, String>