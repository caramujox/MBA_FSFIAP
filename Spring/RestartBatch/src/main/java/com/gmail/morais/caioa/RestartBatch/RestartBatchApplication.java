package com.gmail.morais.caioa.RestartBatch;

import lombok.extern.slf4j.Slf4j;
import com.gmail.morais.caioa.RestartBatch.model.Pessoa;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import javax.sql.DataSource;


@SpringBootApplication
@EnableBatchProcessing
@Slf4j
public class RestartBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestartBatchApplication.class, args);
    }

    @Bean
    public FlatFileItemReader<Pessoa> fileReader(@Value("${input.file}") Resource resource) {
        return new FlatFileItemReaderBuilder<Pessoa>()
                .name("read file")
                .resource(resource)
                .targetType(Pessoa.class)
                .delimited().delimiter(";").names("nome", "cpf")
                .build();
    }

    @Bean
    public ItemProcessor<Pessoa, Pessoa> processor() {
        return pessoa -> {
            pessoa.setNome(pessoa.getNome().toUpperCase());
            pessoa.setCpf(pessoa.getCpf().replaceAll("\\.", "").replace("-", ""));
            return pessoa;
        };
    }

    @Bean
    public JdbcBatchItemWriter databaseWriter(DataSource datasource) {
        return new JdbcBatchItemWriterBuilder<Pessoa>()
                .dataSource(datasource)
                .sql("insert into TB_PESSOA (NOME, CPF) values (:nome, :cpf)")
                .beanMapped()
                .build();
    }

    @Bean
    public Step step(StepBuilderFactory stepBuilderFactory,
                     ItemReader<Pessoa> itemReader,
                     ItemWriter<Pessoa> itemWriter,
                     ItemProcessor<Pessoa, Pessoa> processor) {
        return stepBuilderFactory.get("Step file to DB")
                .<Pessoa, Pessoa>chunk(2)
                .reader(itemReader)
                .processor(processor)
                .writer(itemWriter)
                .build();
    }

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   Step step) {
        return jobBuilderFactory.get("meuPrimeiroJobs")
                .start(step)
                .build();
    }

}
