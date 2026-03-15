-- 1. Створення таблиці city
CREATE TABLE city (
    city_id TEXT PRIMARY KEY,
    display_name TEXT NOT NULL,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);

-- 2. Створення таблиці user_profile
CREATE TABLE user_profile (
    user_profile_id TEXT PRIMARY KEY,
    first_name TEXT,
    last_name TEXT,
    username TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);

-- 3. Створення таблиці flight
CREATE TABLE flight (
    flight_id TEXT PRIMARY KEY,
    flight_number TEXT NOT NULL,
    departure_city_id TEXT REFERENCES city(city_id),
    arrival_city_id TEXT REFERENCES city(city_id),
    departure_time TIMESTAMPTZ NOT NULL,
    arrival_time TIMESTAMPTZ NOT NULL,
    price TEXT, -- на схемі вказано text
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);

-- 4. Створення таблиці ticket
CREATE TABLE ticket (
    ticket_id TEXT PRIMARY KEY,
    flight_id TEXT REFERENCES flight(flight_id),
    user_profile_id TEXT REFERENCES user_profile(user_profile_id),
    pnr TEXT NOT NULL
);

-- ЗАПОВНЕННЯ ДАНИМИ (Seed data)

-- Міста
INSERT INTO city (city_id, display_name) VALUES
('KBP', 'Kyiv Boryspil'),
('WAW', 'Warsaw Chopin'),
('LHR', 'London Heathrow');

-- Користувачі
INSERT INTO user_profile (user_profile_id, first_name, last_name, username, password) VALUES
('u1', 'Ivan', 'Ivanov', 'ivan_arcane', 'pass123'),
('u2', 'Olena', 'Petrova', 'olena_sky', 'secure777');

-- Рейси
INSERT INTO flight (flight_id, flight_number, departure_city_id, arrival_city_id, departure_time, arrival_time, price) VALUES
('f1', 'PS101', 'KBP', 'WAW', '2025-06-01 10:00:00+02', '2025-06-01 11:30:00+02', '150.00'),
('f2', 'LO202', 'WAW', 'LHR', '2025-06-02 14:00:00+02', '2025-06-02 16:45:00+02', '250.00');

-- Квитки
INSERT INTO ticket (ticket_id, flight_id, user_profile_id, pnr) VALUES
('t1', 'f1', 'u1', 'ABC123XYZ'),
('t2', 'f2', 'u2', 'QWERTY987');