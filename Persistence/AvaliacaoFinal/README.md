# Persistencia em Java Avaliação da Disciplina

<p align="center">
<img style="center" src="img\MER_trabalho_final.png" alt="Desenho do modelo entidade-relacionamento de solução para o Trabalho">
</p>

> Trata-se de um sistema de cadastro de produtos e pedidos em um portal de e-commerce. Considere os requisitos:

### :white_check_mark: Objetivos, Regras e Requisitos

O projeto contem as seguintes regras de avaliação:

- O portal possui vários produtos em estoque e com uma determinada quantidade em estoque de cada um desses produtos.
- Cada pedido possui um ou mais produtos e um cliente associado a esse pedido.
- Um produto pode aparecer em um ou mais pedidos.
- Cada produto possui um código, um nome, uma quantidade e um valor.
- Cada cliente possui seus dados pessoais e dados de entrega.

Com base nestes requisitos de projeto:

- [x] Escrever o modelo do banco de dados (o famoso MER).
- [x] Definir as entidades necessárias.
- [x] Desenvolver uma aplicação, do tipo Java Project, onde todas as informações são fornecidas pelo usuário.
- [x] Utilizar o Maven ou Gradle para o gerenciamento de dependências.
- [x] O sistema deve ser desenvolvido utilizando uma das cinco combinações de técnicas:
  - :white_check_mark: Spring Data JPA + Cache Redis (os dois em um único projeto).
  - Spring Data JPA (em um projeto separado) e Neo4J (em outro projeto separado).
  - Spring Data JPA (em um projeto separado) e MongoDB (em outro projeto separado, sendo que neste projeto considere que pode existir um ou mais endereços de entrega cadastrados).
  - Cassandra (em outro projeto separado, lembrando que o Cassandra não suporta relacionamentos, então a lógica associada a isso deverá ser implementada pela aplicação).
  - :white_check_mark: Elaboração de Dockerfile ou Docker Compose referente a dois bancos de dados utilizados na disciplina, envolvendo o processo de clonagem de um repo até a disponibilização do ambiente (nesse caso basta construir um projeto básico para provar o conceito).

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

- Você instalou a versão mais recente de `Docker, Docker-compose, Docker Desktop, etc...`

- Você tenha instalado a `JDK 17 juntamente com sua IDE favorita para Java`.

- Você tenha instalado alguma plataforma de API para desenvolvedores, como o `Postman API ou Insomnia REST`.

- Caso deseje também, pode utilizar o `MySQL Workbench` para visualizar melhor o banco de dados e seus schemas.

## 🚀 Executando o projeto

Para executar o projeto, siga estas etapas:

Acesse o diretorio AvaliacaoFInal via terminal e execute o comando abaixo para disponibilizar minimamente o ambiente para a aplicação (MySQL, Redis, MongoDB, etc.):

```
docker-compose up -d
```

## 😄 Fique a vontade para avaliar e contribuir!<br>

Todo feedback é bem-vindo e o processo de melhoria é continuo!

<p align="center"><a href="https://www.linkedin.com/in/caramujox/" alt="Linkedin">
<img src="https://img.shields.io/badge/-Linkedin-0e76a8?style=flat-square&logo=Linkedin&logoColor=white" /></a>
<a href="#" alt="Twitter">
<img src="https://img.shields.io/twitter/follow/camirujo?style=social" /></a>
</p>

[⬆ Voltar ao topo](#perisistencia-em-java-avaliação-da-disciplina)<br>
