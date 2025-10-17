# ===== build =====
FROM docker.io/library/maven:3.9.9-eclipse-temurin-21-alpine AS build
WORKDIR /app

# cache de dependências (rápido e reprodutível)
COPY pom.xml .
RUN --mount=type=cache,target=/root/.m2 \
    mvn -B -q -e -DskipTests dependency:go-offline

# copia o código e compila
COPY src ./src
RUN --mount=type=cache,target=/root/.m2 \
    mvn -B -q -e clean package -DskipTests

# ===== runtime =====
FROM docker.io/library/eclipse-temurin:21-jre-alpine
WORKDIR /app

# opções extras de JVM (opcional)
ENV JAVA_OPTS=""

# copia o jar gerado na etapa de build
# (pega qualquer .jar em target; se quiser fixo, troque o padrão)
COPY --from=build /app/target/*.jar /app/app.jar

EXPOSE 8080
ENTRYPOINT ["sh","-c","exec java $JAVA_OPTS -jar /app/app.jar"]
