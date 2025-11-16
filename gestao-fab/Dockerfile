# ----------------------------------------------------------------------
# ETAPA 1: BUILD (Compilação do JAR)
# Usa uma imagem com Maven e Java 17 para compilar o projeto.
# ----------------------------------------------------------------------
FROM maven:3.9.5-eclipse-temurin-17 AS build
# Define o diretório de trabalho padrão
WORKDIR /app

# Copia e baixa o pom.xml primeiro para otimizar o cache
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o código fonte e compila
COPY src ./src
# Gera o arquivo JAR, pulando os testes
RUN mvn clean package -DskipTests


# ----------------------------------------------------------------------
# ETAPA 2: RUNTIME (Execução da Aplicação)
# Usa uma imagem leve (somente JRE 17) para o ambiente de produção.
# ----------------------------------------------------------------------
FROM eclipse-temurin:17-jre-alpine
# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR gerado na etapa 'build' para esta imagem leve
COPY --from=build /app/target/*.jar app.jar

# O comando que será executado para iniciar o Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]

# Informa o Docker que a aplicação escuta na porta 8080
EXPOSE 8080