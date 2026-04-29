# 📬 Notification Service

Sistema de notificações assíncrono construído com Java, Spring Boot e Apache Kafka, seguindo os princípios de Clean Architecture.

## 🏗️ Arquitetura

O projeto segue os princípios da Clean Architecture, separando responsabilidades em camadas independentes:
src/
├── domain/          # Entidades de negócio (sem dependência de frameworks)
├── application/     # Casos de uso e regras de negócio
├── infrastructure/  # Kafka, configurações técnicas
└── adapters/        # Controllers REST (porta de entrada)

## 🚀 Tecnologias

- Java 21
- Spring Boot 3.4.5
- Apache Kafka
- Docker & Docker Compose
- GitHub Actions (CI/CD)
- Maven

## ⚙️ Como executar localmente

### Pré-requisitos
- Java 21
- Docker e Docker Compose

### 1. Subir o Kafka com Docker Compose
```bash
docker-compose up -d
```

### 2. Rodar a aplicação
```bash
./mvnw spring-boot:run
```

### 3. Testar o endpoint
```bash
curl -X POST http://localhost:8080/pedidos \
  -H "Content-Type: application/json" \
  -d '{
    "id": "1",
    "cliente": "Enzo",
    "produto": "Notebook",
    "valor": 4500.00
  }'
```

## 🔄 Fluxo da aplicação
POST /pedidos → Controller → UseCase → Kafka Producer → Tópico "pedidos" → Kafka Consumer → Notificação processada

## 🐳 Docker Hub

A imagem está disponível publicamente:

```bash
docker pull enzoanthony/notification-service:latest
```

## ⚡ CI/CD

O pipeline é disparado automaticamente a cada push na branch `main`:

1. Build com Maven
2. Login no Docker Hub
3. Build e Push da imagem Docker

## 📂 Estrutura do projeto
notification-service/
├── .github/workflows/    # Pipeline CI/CD
├── src/
│   └── main/java/com/enzo/notificationservice/
│       ├── adapters/controller/      # PedidoController
│       ├── application/usecase/      # EnviarNotificacaoUseCase
│       ├── domain/model/             # Pedido
│       └── infrastructure/kafka/     # Producer, Consumer, Config
├── docker-compose.yml
├── Dockerfile
└── pom.xml
