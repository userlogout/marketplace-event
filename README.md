# marketplace-event


## Запуск и остановка контейнеров
- docker-compose up --build
- docker-compose down -v   # удалить контейнеры + volume

## Настройка БД в контейнере
Контейнер запускается с уже созданной БД

 1. Проверить подключение к БД. postgresql://localhost:5434/marketplace
    user: marketplace
    passw: 123456

 2. Для создания таблиц выполнить SQL: database/create_tables.sql
