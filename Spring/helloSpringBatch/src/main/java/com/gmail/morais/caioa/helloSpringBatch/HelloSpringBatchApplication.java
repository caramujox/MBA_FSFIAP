package com.gmail.morais.caioa.helloSpringBatch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.nio.file.Paths;

@Slf4j
@SpringBootApplication
@EnableBatchProcessing
public class HelloSpringBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBatchApplication.class, args);
	}

	@Bean
	public Tasklet deleteFile(@Value("${file.path}") String filePath){
		return (stepContribution, chunkContext) -> {
			File file = Paths.get(filePath).toFile();
			if (file.delete())
				log.info("Arquivo deletado");
			else
				log.warn("arquivo nao deletado ou nao encontrado");

			return RepeatStatus.FINISHED;
		};
	}

	@Bean
	public Step step(StepBuilderFactory stepBuilderFactory, Tasklet tasklet){
		return stepBuilderFactory.get("delete step")
				.tasklet(tasklet)
				.allowStartIfComplete(true)
				.build();
	}

	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory, Step step){
		return jobBuilderFactory.get("delete file job").start(step).build();
	}
}
