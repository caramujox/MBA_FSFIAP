# MBA_FSFIAP - Repositório de laboratórios e entrega de trabalhos
# 

<img src="img\macro_trabalho_final.png" alt="Desenho macro de solução para o Trabalho">

>Repositório para projetos de classe das disciplinas do MBA Full Stack Development - FIAP 2022 - 43SCJ

### :white_check_mark: Disciplinas
O projeto contem as seguintes regras de avaliação

- [x] Design Thinking
- [x] UX Design
- [x] StartUp One
- [x] Java Platform
- [x] Modern Web
- [x] Persistence
- [ ] Spring
- [ ] Big Data Development

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

- Você instalou a versão mais recente de `Docker, Docker-compose, Docker Desktop, etc...`

- Você tenha instalado a `JDK 17 juntamente com sua IDE favorita para Java`.

- Você tenha instalado alguma plataforma de API para desenvolvedores, como o `Postman API ou Insomnia REST`.

- Caso deseje também, pode utilizar o `MySQL Workbench` para visualizar melhor o banco de dados e seus schemas.

## 🚀 Executando o projeto

Para executar o projeto, siga estas etapas:

Acesse o diretorio TrabalhoFinal via terminal e execute o comando:

```
docker-compose up -d
```

Em seguida execute as três aplicações inclusas no repositório (`43scjAdmCentralApp, 43scjDroneApp, 43scjNotifyApp`). Lembre-se de sempre fazer o Reload das suas dependências Maven e, quando julgar necessário, limpar e refazer o build da aplicação com o comando

```
mvn clean install
```

:heavy_exclamation_mark::heavy_exclamation_mark::heavy_exclamation_mark: <b>ATENÇÃO:</b> Verifique sempre os logs da aplicação na sua IDE para análisar os resultados. Preste atenção as configurações de porta no `application.properties` de cada aplicação e faça as alterações que achar necessárias para execução.

## ☕ Usando e testando o projeto

Para testar o projeto basta abrir a sua plataforma de API (Postman ou Insomnia, por exemplo) e realizar uma requisição HTTP com metodo `POST` qualquer com o seguinte formato :

```
{
	"id_drone":"3",
	"latitude":"2330.0",
	"longitude":"1230.3",
	"umidade":"0.352",
	"rastreamento_ativo": true
}
```

Para validar se o projeto atende as regras, é só alterar os valores da requisição, executa-la novamente e avaliar os logs da aplicação.

## 😄 Fique a vontade para avaliar e contribuir!<br>

Todo feedback é bem-vindo e o processo de melhoria é continuo!

<p align="center"><a href="https://www.linkedin.com/in/caramujox/" alt="Linkedin">
<img src="https://img.shields.io/badge/-Linkedin-0e76a8?style=flat-square&logo=Linkedin&logoColor=white" /></a>
<a href="#" alt="Twitter">
<img src="https://img.shields.io/twitter/follow/camirujo?style=social" /></a>
</p>

[⬆ Voltar ao topo](#projeto-final-integration-and-devtools)<br>
