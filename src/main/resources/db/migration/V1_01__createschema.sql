DROP TABLE IF EXISTS ACCOUNT_INFORMATION;  
DROP SEQUENCE IF EXISTS account_information_seq;

CREATE SEQUENCE account_information_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE ACCOUNT_INFORMATION
(
	account_id BIGINT DEFAULT NEXT VALUE FOR account_information_seq PRIMARY KEY NOT NULL,
	account_username VARCHAR(100),
	account_password VARCHAR(100),
	account_email VARCHAR(255),
	account_age INT,
	account_birthday DATE,
	account_subscription_date DATE
);

DROP TABLE IF EXISTS BASE_WEAPON;  
DROP SEQUENCE IF EXISTS base_weapon_seq;

CREATE SEQUENCE base_weapon_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE BASE_WEAPON
(
    base_weapon_id BIGINT  DEFAULT NEXT VALUE FOR base_weapon_seq PRIMARY KEY NOT NULL,
    base_weapon_name VARCHAR(100),
    base_stat_strength INT,
    base_stat_agility INT,
    base_stat_intelligence INT,
    base_stat_wisdom INT,
    base_stat_stealth INT,
    base_stat_vitality INT,
    base_stat_energy INT
);

DROP TABLE IF EXISTS CHARACTERS;  
DROP SEQUENCE IF EXISTS characters_seq;

CREATE SEQUENCE characters_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE CHARACTERS
(
    character_id BIGINT  DEFAULT NEXT VALUE FOR characters_seq PRIMARY KEY NOT NULL,
    account_id BIGINT NOT NULL ,
    base_weapon_id BIGINT NOT NULL ,
    character_name VARCHAR(100),
    character_title VARCHAR(100),
    character_strength INT,
    character_agility INT,
    character_intelligence INT,
    character_wisdom INT,
    character_stealth INT,
    character_vitality INT,
    character_energy INT,
    character_life FLOAT,
    FOREIGN KEY(account_id) REFERENCES ACCOUNT_INFORMATION,
    FOREIGN KEY(base_weapon_id) REFERENCES BASE_WEAPON
);

DROP TABLE IF EXISTS SKILLS;  
DROP SEQUENCE IF EXISTS skill_id_seq;

CREATE SEQUENCE skill_id_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE SKILLS
(
    skill_id BIGINT  DEFAULT NEXT VALUE FOR skill_id_seq PRIMARY KEY NOT NULL,
    base_weapon_id BIGINT,
    skill_quality_code INT, -- check in NOMENCLATURE table
    skill_rarity_code INT, -- check in NOMENCLATURE table
    skill_quantity_available INT, -- 1 if unique
    skill_name VARCHAR(255),
    skill_effect VARCHAR(50), --damage flat/heal/dot/boost etc...
    skill_value_effect INT,
    skill_value_calcul VARCHAR(20), -- operator (add, multiply, percent,divide)
    FOREIGN KEY(base_weapon_id) REFERENCES BASE_WEAPON
);