# serviceSubscriptions

## Описание

Микросервис на Spring Boot для управления пользователями и их подписками на цифровые сервисы (Netflix, YouTube Premium, VK Музыка, Яндекс.Плюс и др.).

## Функциональность

- CRUD-операции для пользователей
- Управление подписками пользователей
- Получение ТОП-3 популярных подписок
- Хранение данных в PostgreSQL с миграциями через Liquibase
- REST API с логированием через SLF4J
- Контейнеризация через Docker и docker-compose

## Технологии

- Java 17, Spring Boot
- Spring Data JPA, PostgreSQL
- Liquibase (.xml миграции)
- SLF4J, Logback
- Docker, Docker Compose
- Maven

## Запуск

Сервис будет доступен по адресу: http://localhost:8084

```bash
docker-compose up --build