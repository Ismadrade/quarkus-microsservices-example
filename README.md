# Quarkus / Keycloak Example

Modelo simples de uma aplicação Java utilizando framework Quarkus, banco de dados com Postgres e autenticação com Keycloak.

<p align="center">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=idea,java,docker,maven,postman,postgres" />
    &nbsp;&nbsp;&nbsp;<img height="45" width="45" src="https://seeklogo.com/images/Q/quarkus-logo-C9F006782E-seeklogo.com.png" />
    </a>
</p>

# Tecnologias Abordadas:

- Quarkus Framework
- Keycloak;
- Docker para rodar o servidor do Keycloak;

# Requisitos:
- Java 11
- Docker
- Postman ou Insomnia
- Gerenciador de banco (Recomendado: DBeaver)
- Maven (Opcional: ./mvnw + command )



# Execuções no Docker:

## Postgres

```
docker run -p 5432:5432 -e POSTGRES_PASSWORD=1234 postgres
```
## Keycloak

```
docker run --name keycloak -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin -p 8180:8080 quay.io/keycloak/keycloak:17.0.0 start-dev
```

# Configurando o banco de dados:

Após realizar o download das imagens no docker, certifique-se de que as mesmas estão rodando:

```
docker ps 
```

Com um gerenciador de bancos de sua preferencia, configure uma conexão remota, utilizando os seguintes parâmetros:

- customer: `jdbc:postgresql://localhost:5432/customerdb`
- product: `jdbc:postgresql://localhost:5432/productdb`
- order: `jdbc:postgresql://localhost:5432/orderdb`

Obs: O username e o password encontram-se dentro do arquivo applications.yml de cada micro serviço.

# Configurando o Keycloak:

Após realizar o download das imagens no docker, certifique-se de que as mesmas estão rodando:

```
docker ps 
```

No seu navegador, acesso a url: `http://localhost:8180/` em seguida, informe o login e a senha:

Username or email: `admin`
Password: `admin`

**Obs: Lembrando que o o login e a senha são de fins didáticos e não devem ser usadas em ambientes de produção.

### Importando as configurações
O próximo passo é importar as configurações do Keykloak, que estão dentro do arquivo **realm.json**, na raiz do projeto. 
Para realizar a importação, clique no botão **Add realm** que se encontra no menu **Quarkus** em baixo do logotipo do Keycloak.

### Adicionando um usuário

Após importar as configurações, será necessário criar um usuário no keycloak.
Para isso, basta ir no menu **Manage**, na opção **user** e clicar na opção **Add user**.
Informe um nome de usuário e clique na opção **Save**.

Precisamos criar uma senha para este usuário. Para isso,  clique na opção **View all users** e clique no ID do seu usuário criado.
Na guia **Credentials**, informe um password, repita o password e desmarque a opção **Temporary** e clique em **Reset Password**.

### Configurando o client:

Agora, precisamos configurar o client que será utilizado na aplicação, no nosso exemplo será o **Backend-service**.

No menu **Configure**, na opção **Clients**, clique no nome do **Backend-service**.
Na guia **Service Account Roles**, adicione as roles **admin** e **user**.

### Configurando as roles do usuário:

Vá para o menu **Manage**, na opção **user** e clique no ID do seu usuário criado.
Na guia **Role Mappings**, adicione todas as roles existentes. 


# Executando o projeto:


Dentro da raiz de cada micro serviço, execute o seguinte comando no Windows:

```shell
.\mvn clean package -DskipTests 
```

ou caso esteja utilizando o Linux:

```shell
./mvn clean package -DskipTests 
```
***Obs: É recomendado utilizar três terminais separados, pois em cada um será rodado um micro serviço.

Em cada terminal, rode o seguinte comando:

```shell
java -jar target/quarkus-app/quarkus-run.jar
```

# Portas dos Projetos:
- Customer: 8080
- Product: 8081
- Order: 8082
- Keycloak: 8100

# Post Collection:

Na pasta postman_collection, se encontra todos os endpoints utilizados nos micro serviços, bem como a autenticação no keycloak.










