package br.com.morais.caioa.helloKotlin.config;

import br.com.morais.caioa.helloKotlin.repository.PessoaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackageClasses = PessoaRepository::class)
class MongoConfig : AbstractReactiveMongoConfiguration() {
        override fun getDatabaseName() = "mongoDatabase"
        override fun reactiveMongoClient(): MongoClient = mongoClient()

@Bean
   fun mongoClient(): MongoClient = MongoClients.create()
           override fun reactiveMongoTemplate(databaseFactory: ReactiveMongoDatabaseFactory, mongoConverter: MappingMongoConverter) =
           ReactiveMongoTemplate(mongoClient(), databaseName)
           }
}