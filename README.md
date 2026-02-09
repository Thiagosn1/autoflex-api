# autoflex-api

Este projeto utiliza **Quarkus**, o Supersonic Subatomic Java Framework.

Documentação oficial do Quarkus: [https://quarkus.io/](https://quarkus.io/)

---

## Pré-requisitos

Antes de rodar a API, certifique-se de ter os seguintes itens instalados:

* Docker
* Docker Compose
* Java 17+

---

## 1. Instalação e configuração do Docker

### Windows

1. Baixe o **Docker Desktop** em: [https://www.docker.com/products/docker-desktop/](https://www.docker.com/products/docker-desktop/)
2. Execute o instalador e siga as instruções padrão.
3. Durante a instalação, mantenha habilitada a opção de usar **WSL 2**.

Após a instalação, reinicie o computador e verifique no terminal:

```bash
docker --version
docker compose version
```

---

### Linux (Ubuntu/Debian)

```bash
sudo apt update
sudo apt install -y docker.io docker-compose-plugin
```

Inicie e habilite o Docker:

```bash
sudo systemctl start docker
sudo systemctl enable docker
```

Opcionalmente, adicione seu usuário ao grupo docker para não precisar usar sudo:

```bash
sudo usermod -aG docker $USER
```

Após isso, reinicie a sessão.

Verifique a instalação:

```bash
docker --version
docker compose version
```

---

## 2. Subindo os containers com Docker Compose

Na raiz do projeto, onde está localizado o arquivo `docker-compose.yml`, execute:

```bash
docker compose up -d
```

Esse comando irá subir os serviços necessários (ex: banco de dados).

Para verificar se os containers estão em execução:

```bash
docker compose ps
```

---

## 3. Instalação do Quarkus (Quarkus CLI)

O Quarkus pode ser utilizado via **Maven Wrapper**, não sendo obrigatória a instalação da CLI. Ainda assim, segue a opção:

### Instalando a Quarkus CLI

```bash
sdk install quarkus
```

> É necessário ter o **SDKMAN** instalado: [https://sdkman.io/](https://sdkman.io/)

Verifique a instalação:

```bash
quarkus --version
```

---

## 4. Rodando a aplicação Quarkus em modo desenvolvimento

Com os containers ativos, execute:

```bash
./mvnw quarkus:dev
```

A aplicação ficará disponível em:

```
http://localhost:8080
```

A interface de desenvolvimento do Quarkus (Dev UI) pode ser acessada em:

```
http://localhost:8080/q/dev/
```

---

## Rodando o frontend da aplicação

Após configurar e rodar a **API**, o frontend da aplicação deve ser executado separadamente.

O frontend está disponível neste repositório:

[https://github.com/Thiagosn1/autoflex-frontend](https://github.com/Thiagosn1/autoflex-frontend)

As instruções completas de instalação e execução do frontend estão descritas no README do próprio repositório.

Certifique-se apenas de que a API esteja em execução em `http://localhost:8080` para que a integração funcione corretamente.

---

## Build e execução da aplicação

### Gerando o pacote da aplicação

```bash
./mvnw package
```

O arquivo `quarkus-run.jar` será gerado em:

```
target/quarkus-app/
```

Execute com:

```bash
java -jar target/quarkus-app/quarkus-run.jar
```

---

## Criando um JAR Uber

```bash
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

Execute com:

```bash
java -jar target/*-runner.jar
```

---

## Executável nativo

```bash
./mvnw package -Dnative
```

Ou, sem GraalVM instalado:

```bash
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

O executável será gerado em `target/`.

---

## Guias relacionados

* REST: [https://quarkus.io/guides/rest](https://quarkus.io/guides/rest)
* REST Jackson: [https://quarkus.io/guides/rest#json-serialisation](https://quarkus.io/guides/rest#json-serialisation)
* Hibernate ORM com Panache: [https://quarkus.io/guides/hibernate-orm-panache](https://quarkus.io/guides/hibernate-orm-panache)
* JDBC MySQL: [https://quarkus.io/guides/datasource](https://quarkus.io/guides/datasource)
