package com.gmail.morais.caioa.helloSpringBatch;

import com.gmail.morais.caioa.helloSpringBatch.model.User;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.core.io.Resource;
import javax.sql.DataSource;

@SpringBootApplication
@EnableBatchProcessing
public class SoccerBatchChunkApplication {
        Logger logger = LoggerFactory.getLogger(SoccerBatchChunkApplication.class.getName());

        public static void main(String[] args) {
            SpringApplication.run(SoccerBatchChunkApplication.class, args);
        }

        @Bean
        public ItemReader<User> itemReader(@Value("${file.resource}") Resource resource) {
            return new FlatFileItemReaderBuilder<User>()
                    .name("User item reader")
                    .delimited().delimiter(";").names("name", "cpf")
                    .targetType(User.class)
                    .build();
        }

        @Bean
        public ItemProcessor<User, User> itemProcessor() {
            return user -> {
                user.setName(user.getName().toUpperCase());
                user.setCpf(user.getCpf().replaceAll("[^\\d]", ""));
                return user;
            };
        }

        @Bean
        public ItemWriter<User> itemWriter(DataSource dataSource){
            return new JdbcBatchItemWriterBuilder<User>()
                    .dataSource(dataSource)
                    .beanMapped()
                    .sql("insert into TB_USER(nome, cpf) values (:nome, :cpf)")
                    .build();
        }


    }

