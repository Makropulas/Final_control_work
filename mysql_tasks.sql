-- 7. В подключенном MySQL репозитории создать базу данных “Друзья человека”

CREATE DATABASE IF NOT EXISTS human_friends;


-- 8. Создать таблицы с иерархией из диаграммы в БД

USE human_friends;

CREATE TABLE IF NOT EXISTS animals
(
	id INT NOT NULL PRIMARY KEY,
    type_name VARCHAR(15)
);

INSERT INTO animals(id, type_name)
VALUES
	(1, "Pet"),
    (2, "Pack animal");

CREATE TABLE IF NOT EXISTS pets
(
	id INT NOT NULL PRIMARY KEY,
    species_name VARCHAR(15),
    animals_id INT,
    CONSTRAINT pets_animals_fk
    FOREIGN KEY (animals_id) REFERENCES animals(id)
);

INSERT INTO pets(id, species_name, animals_id)
VALUES
	(1, "Dog", 1),
    (2, "Cat", 1),
    (3, "Hamster", 1);

CREATE TABLE IF NOT EXISTS packanimals
(
	id INT NOT NULL PRIMARY KEY,
    species_name VARCHAR(15),
    animals_id INT,
    CONSTRAINT packanimals_animals_fk
    FOREIGN KEY (animals_id) REFERENCES animals(id)
);

INSERT INTO packanimals(id, species_name, animals_id)
VALUES
	(1, "Horse", 2),
    (2, "Camel", 2),
    (3, "Donkey", 2);
    
CREATE TABLE IF NOT EXISTS commands
(
	id INT NOT NULL PRIMARY KEY,
    commands VARCHAR(45)
);

INSERT INTO commands(id, commands)
VALUES
	(1, "Sit, Down, Place, Speak, Heel"),
    (2, "Come, Stop, Back-up, Jump"),
    (3, "Come"),
    (4, "Brrr, Hop, Easy"),
    (5, "Down, Stand, Go, Stay"),
    (6, "Go, Stay"),
    (7, "");

CREATE TABLE IF NOT EXISTS dogs
(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(15),
    birthdate DATE NOT NULL,
    commands_id INT,
    pets_id INT DEFAULT 1,
    CONSTRAINT dogs_commands_fk
    FOREIGN KEY (commands_id) REFERENCES commands(id),
    CONSTRAINT dogs_pets_fk
    FOREIGN KEY (pets_id) REFERENCES pets(id)
);

CREATE TABLE IF NOT EXISTS cats
(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(15),
    birthdate DATE NOT NULL,
    commands_id INT,
    pets_id INT DEFAULT 2,
    CONSTRAINT cats_commands_fk
    FOREIGN KEY (commands_id) REFERENCES commands(id),
    CONSTRAINT cats_pets_fk
    FOREIGN KEY (pets_id) REFERENCES pets(id)
);

CREATE TABLE IF NOT EXISTS hamsters
(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(15),
    birthdate DATE NOT NULL,
    commands_id INT,
    pets_id INT DEFAULT 3,
    CONSTRAINT hamsters_commands_fk
    FOREIGN KEY (commands_id) REFERENCES commands(id),
    CONSTRAINT hamsters_pets_fk
    FOREIGN KEY (pets_id) REFERENCES pets(id)
);

CREATE TABLE IF NOT EXISTS horses
(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(15),
    birthdate DATE NOT NULL,
    commands_id INT,
    packanimals_id INT DEFAULT 1,
    CONSTRAINT horses_commands_fk
    FOREIGN KEY (commands_id) REFERENCES commands(id),
    CONSTRAINT horses_packanimals_fk
    FOREIGN KEY (packanimals_id) REFERENCES packanimals(id)
);

CREATE TABLE IF NOT EXISTS camels
(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(15),
    birthdate DATE NOT NULL,
    commands_id INT,
    packanimals_id INT DEFAULT 2,
    CONSTRAINT camels_commands_fk
    FOREIGN KEY (commands_id) REFERENCES commands(id),
    CONSTRAINT camels_packanimals_fk
    FOREIGN KEY (packanimals_id) REFERENCES packanimals(id)
);

CREATE TABLE IF NOT EXISTS donkeys
(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(15),
    birthdate DATE NOT NULL,
    commands_id INT,
    packanimals_id INT DEFAULT 3,
    CONSTRAINT donkeys_commands_fk
    FOREIGN KEY (commands_id) REFERENCES commands(id),
    CONSTRAINT donkeys_packanimals_fk
    FOREIGN KEY (packanimals_id) REFERENCES packanimals(id)
);


-- 9. Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения

INSERT INTO dogs(name, birthdate, commands_id)
VALUES
	("Ray", '2022-01-01', 1),
    ("Lada", '2022-01-01', 2),
    ("Anyeta", '2017-05-03', 1);
    
INSERT INTO cats(name, birthdate, commands_id)
VALUES
	("Maysey", '2020-10-20', 2),
    ("Kiara", '2017-02-10', 2),
    ("Lusia", '2013-11-19', 3);
    
INSERT INTO hamsters(name, birthdate, commands_id)
VALUES
	("Homa", '2021-08-23', 3),
    ("Daizy", '2022-12-11', 7),
    ("Chuck", '2023-02-15', 7);
    
INSERT INTO horses(name, birthdate, commands_id)
VALUES
	("Lizzy", '2015-04-26', 4),
    ("Lucky", '2018-12-06', 4),
    ("Burn", '2017-12-03', 4);
    
INSERT INTO camels(name, birthdate, commands_id)
VALUES
	("Barry", '2012-03-24', 6),
    ("Dan", '2011-10-13', 5),
    ("Wook", '2015-05-15', 5);
    
INSERT INTO donkeys(name, birthdate, commands_id)
VALUES
	("Buddy", '2014-07-28', 6),
    ("Fil", '2016-08-12', 6),
    ("Many", '2019-10-02', 5);
    

-- 10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. 
--     Объединить таблицы лошади, и ослы в одну таблицу.

DELETE FROM camels;

CREATE TABLE IF NOT EXISTS horsesanddonkeys
SELECT * FROM horses
UNION SELECT * FROM donkeys;


-- 11. Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, но младше 3 лет 
--     и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице

CREATE TABLE IF NOT EXISTS younganimals
SELECT *, TIMESTAMPDIFF(MONTH, birthdate, CURDATE()) `age (in month)` FROM (
	SELECT * FROM cats
	UNION SELECT * FROM dogs
	UNION SELECT * FROM hamsters
	UNION SELECT * FROM horses
    UNION SELECT * FROM donkeys
) AS allanimals
WHERE birthdate BETWEEN DATE_SUB(CURDATE(), INTERVAL 3 YEAR) AND DATE_SUB(CURDATE(), INTERVAL 1 YEAR);


-- 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.