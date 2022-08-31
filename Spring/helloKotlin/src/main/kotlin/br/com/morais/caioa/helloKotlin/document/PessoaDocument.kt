package br.com.morais.caioa.helloKotlin.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class PessoaDocument (
    @Id
    var id: String? = null,
    var name: String
)