./mvnw clean package -Dquarkus.container-image.build=true -DskipTests
docker-compose up
