-- 7. В подключенном MySQL репозитории создать базу данных “Друзья человека”

CREATE DATABASE IF NOT EXISTS human_friends;

-- 8. Создать таблицы с иерархией из диаграммы в БД

USE human_friends;

CREATE TABLE IF NOT EXISTS animals
(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(15)
);