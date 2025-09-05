CREATE TYPE user_role AS ENUM ('admin', 'user');
CREATE TYPE notification_status AS ENUM ('read', 'unread');
CREATE TYPE notification_type AS ENUM ('NEW', 'EDIT');


CREATE TABLE users
(
    id            SERIAL PRIMARY KEY,
    login         VARCHAR(255)                                        NOT NULL UNIQUE,
    password_hash TEXT                                                NOT NULL,
    full_name     VARCHAR(255),
    role          user_role default 'user',
    email         VARCHAR(255) UNIQUE,
    status        VARCHAR(20) CHECK (status IN ('active', 'blocked')) NOT NULL,
    token         TEXT                                                NOT NULL
);

CREATE TABLE notifications
(
    id                SERIAL PRIMARY KEY,
    user_id           INTEGER           NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    notification_type notification_type NOT NULL,
    message           TEXT              NOT NULL,
    status            notification_status      DEFAULT 'unread',
    created_at        TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at        TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE points
(
    id            SERIAL PRIMARY KEY,    -- Уникальный идентификатор точки
    name          VARCHAR(255) NOT NULL, -- Название точки
    address       VARCHAR(255),          -- Адрес точки
    latitude      float        not null, -- Широта
    longitude     float        not null,
    opening_date  DATE,                  -- Дата открытия
    working_hours VARCHAR(50),           -- Часы работы
    description   TEXT,                  -- Описание
    image_url     VARCHAR(255)           -- Ссылка на изображение (логотип магазина)
);

CREATE TABLE user_actions
(
    id             SERIAL PRIMARY KEY,
    user_id        INTEGER      NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    action_type    VARCHAR(100) NOT NULL,
    action_details TEXT,
    created_at     TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);


