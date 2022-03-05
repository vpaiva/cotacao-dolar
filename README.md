# Sistema de cotação do dolar

O sistema de cotação do dolar consome uma API externa do Banco Central do Brasil. 

# Tecnologias utilizadas
Foi utilizado o framework quarkus e RestClient para consumo da API do BCB. O RestClient foi utilizado também para o segundo microserviço que consome o primeiro e retorna a devida resposta. 

O swagger foi utilizado para teste da API e o docker foi utilizado para criação de containers para cada microserviço. O QuarkusTest também foi utilizado para testes de integração

# Portas
  
Microserviço de consumo da API: 8080

# swagger

O swagger foi utilizado apenas no segundo microserviço e, após o sistema ser executado, pode ser acessado pela seguinte url: 

http://localhost:8080/q/swagger-ui

# docker

Foi utilizado o docker compose. Para executar a aplicação no docker, basta fazer clone do projeto, navegar até a pasta raiz e, então, executar o seguinte comando:

./runProject.sh 

ou rodar os comandos:

./mvnw clean package -Dquarkus.container-image.build=true -DskipTests
docker-compose up

Feito isso, se pode utilizar o swagger para testes, o curl para requisição GET ou acessar direto por um navegador através de uma url que está exemplificada abaixo:

http://localhost:8080/v1/cotacao?dataCotacao=03-03-2022

swagger: http://localhost:8080/q/swagger-ui
jaeger: http://localhost:16686/search?service=cotacao-dolar

# Testes

Para testes de integração foi utilizado o QuarkusTest. Foram feitos testes para verificar se o parâmetro obrigatório foi preenchido e retornar 400 e casos de sucesso.

