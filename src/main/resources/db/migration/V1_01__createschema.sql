DROP TABLE IF EXISTS NOMENCLATURE;  
DROP SEQUENCE IF EXISTS nomenclature_id_seq;

DROP TABLE IF EXISTS CHARACTERS;  
DROP SEQUENCE IF EXISTS characters_seq;

DROP TABLE IF EXISTS ACCOUNT_INFORMATION;  
DROP SEQUENCE IF EXISTS account_information_seq;

DROP TABLE IF EXISTS BASE_WEAPON;  
DROP SEQUENCE IF EXISTS base_weapon_seq;

DROP TABLE IF EXISTS CHARACTERS_STATS;  
DROP SEQUENCE IF EXISTS characters_stats_seq;

DROP TABLE IF EXISTS SKILLS;  
DROP SEQUENCE IF EXISTS skill_id_seq;

CREATE SEQUENCE nomenclature_id_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE NOMENCLATURE
(
    nomenclature_id BIGINT  DEFAULT nextval('nomenclature_id_seq') PRIMARY KEY NOT NULL,
    nomenclature_code VARCHAR(50),
    nomenclature_category VARCHAR(50), 
    nomenclature_label VARCHAR(255)
);

CREATE SEQUENCE account_information_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE ACCOUNT_INFORMATION
(
	account_id BIGINT DEFAULT nextval('account_information_seq') PRIMARY KEY NOT NULL,
	account_username VARCHAR(100),
	account_password VARCHAR(100),
	account_email VARCHAR(255),
	account_age INT,
	account_birthday DATE,
	account_subscription_date DATE
);

CREATE SEQUENCE base_weapon_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE BASE_WEAPON
(
    base_weapon_id BIGINT  DEFAULT nextval('base_weapon_seq') PRIMARY KEY NOT NULL,
    base_weapon_name VARCHAR(100),
    base_stat_strength INT,
    base_stat_agility INT,
    base_stat_intelligence INT,
    base_stat_wisdom INT,
    base_stat_stealth INT,
    base_stat_vitality INT,
    base_stat_energy INT
);

CREATE SEQUENCE characters_stats_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE CHARACTERS_STATS
(
    character_stats_id BIGINT  DEFAULT nextval('characters_stats_seq') PRIMARY KEY NOT NULL,
    character_strength INT,
    character_agility INT,
    character_intelligence INT,
    character_wisdom INT,
    character_stealth INT,
    character_vitality INT,
    character_energy INT,
    character_life FLOAT
);

CREATE SEQUENCE characters_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE CHARACTERS
(
    character_id BIGINT  DEFAULT nextval('characters_seq') PRIMARY KEY NOT NULL,
    account_id BIGINT NOT NULL ,
    base_weapon_id BIGINT DEFAULT NULL,
    character_stats_id BIGINT DEFAULT NULL,
    character_name VARCHAR(100) NOT NULL,
    character_title VARCHAR(100),
    FOREIGN KEY(account_id) REFERENCES ACCOUNT_INFORMATION,
    FOREIGN KEY(base_weapon_id) REFERENCES BASE_WEAPON,
    FOREIGN KEY(character_stats_id) REFERENCES CHARACTERS_STATS
);

CREATE SEQUENCE skill_id_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE SKILLS
(
    skill_id BIGINT  DEFAULT nextval('skill_id_seq') PRIMARY KEY NOT NULL,
    base_weapon_id BIGINT,
    skill_quality_id INT, -- check in NOMENCLATURE table
    skill_rarity_id INT, -- check in NOMENCLATURE table
    skill_quantity_available INT, -- 1 if unique
    skill_name VARCHAR(255),
    skill_effect VARCHAR(50), --damage flat/heal/dot/boost etc...
    skill_value_effect INT,
    skill_value_calcul VARCHAR(20), -- operator (add, multiply, percent,divide)
    FOREIGN KEY(base_weapon_id) REFERENCES BASE_WEAPON,
    FOREIGN KEY(skill_quality_id) REFERENCES NOMENCLATURE,
    FOREIGN KEY(skill_rarity_id) REFERENCES NOMENCLATURE
);
