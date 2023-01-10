INSERT INTO ACCOUNT_INFORMATION(account_username,account_password,account_email,account_age,account_birthday,account_subscription_date) VALUES ('test_username', 'test_password', 'test_mail',1,CURRENT_DATE,CURRENT_DATE);    

INSERT INTO BASE_WEAPON(base_weapon_name,base_stat_strength,base_stat_agility,base_stat_intelligence,base_stat_wisdom,base_stat_stealth,base_stat_vitality,base_stat_energy) VALUES ('Bow',8,9,6,5,7,4,6); 
INSERT INTO BASE_WEAPON(base_weapon_name,base_stat_strength,base_stat_agility,base_stat_intelligence,base_stat_wisdom,base_stat_stealth,base_stat_vitality,base_stat_energy) VALUES ('Sword',10,6,5,4,5,9,7); 
INSERT INTO BASE_WEAPON(base_weapon_name,base_stat_strength,base_stat_agility,base_stat_intelligence,base_stat_wisdom,base_stat_stealth,base_stat_vitality,base_stat_energy) VALUES ('Staff',6,5,10,9,5,4,9); 
INSERT INTO BASE_WEAPON(base_weapon_name,base_stat_strength,base_stat_agility,base_stat_intelligence,base_stat_wisdom,base_stat_stealth,base_stat_vitality,base_stat_energy) VALUES ('Wand',5,6,8,10,7,5,9); 

INSERT INTO CHARACTERS(account_id,base_weapon_id,character_name,character_title,character_strength,character_agility,character_intelligence,character_wisdom,character_stealth,character_vitality,character_energy,character_life) 
	VALUES (SELECT account_id FROM ACCOUNT_INFORMATION where account_username='test_username',
			SELECT base_weapon_id from BASE_WEAPON where base_weapon_name='Bow',
			'Test_name1','Test_title',8,9,6,5,7,4,6,100.0); 

INSERT INTO SKILLS(base_weapon_id,skill_quality_code,skill_rarity_code,skill_quantity_available,skill_name,skill_effect,skill_value_effect,skill_value_calcul) VALUES (1,1,1,10,'Fire Arrow','damage flat',10,'substraction');
INSERT INTO SKILLS(base_weapon_id,skill_quality_code,skill_rarity_code,skill_quantity_available,skill_name,skill_effect,skill_value_effect,skill_value_calcul) VALUES (1,1,1,10,'Celerity','boost agility',10,'add');
INSERT INTO SKILLS(base_weapon_id,skill_quality_code,skill_rarity_code,skill_quantity_available,skill_name,skill_effect,skill_value_effect,skill_value_calcul) VALUES (2,1,1,10,'Slicer','damage flat',10,'substraction');
INSERT INTO SKILLS(base_weapon_id,skill_quality_code,skill_rarity_code,skill_quantity_available,skill_name,skill_effect,skill_value_effect,skill_value_calcul) VALUES (2,1,1,10,'Bleed Hit','dot10sec',2,'substraction');
INSERT INTO SKILLS(base_weapon_id,skill_quality_code,skill_rarity_code,skill_quantity_available,skill_name,skill_effect,skill_value_effect,skill_value_calcul) VALUES (3,1,1,10,'Fire Ball','damage flat',15,'substraction');
INSERT INTO SKILLS(base_weapon_id,skill_quality_code,skill_rarity_code,skill_quantity_available,skill_name,skill_effect,skill_value_effect,skill_value_calcul) VALUES (3,1,1,10,'Ica Calamity','damage flat',15,'percent');
INSERT INTO SKILLS(base_weapon_id,skill_quality_code,skill_rarity_code,skill_quantity_available,skill_name,skill_effect,skill_value_effect,skill_value_calcul) VALUES (4,1,1,10,'Holy Light','heal',10,'add');
INSERT INTO SKILLS(base_weapon_id,skill_quality_code,skill_rarity_code,skill_quantity_available,skill_name,skill_effect,skill_value_effect,skill_value_calcul) VALUES (4,1,1,10,'White Light','debuff strenght',10,'percent');